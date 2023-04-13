package baekjoon;

import java.io.*;
import java.util.*;

// 구간 합 구하기
public class Baekjoon2042 {
	
	static long[] arr;
	static long[] tree;
	
	// 세그먼트 트리(Segment Tree)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(strTkr.nextToken());
		int m = Integer.parseInt(strTkr.nextToken());
		int k = Integer.parseInt(strTkr.nextToken());
	
		// n개의 수 입력받기
		arr = new long[n+1];
		for(int i=1; i<=n; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		// 세그먼트 트리 초기화
		tree = new long[n*4];
		initTree(1, n, 1);
		
		// 변경 m과 구간 합 k번에 대한 입력
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=m+k; i++) {
			strTkr = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(strTkr.nextToken());
			int b = Integer.parseInt(strTkr.nextToken());
			long c = Long.parseLong(strTkr.nextToken());
			
			switch (a) {
			// update
			case 1:
				// b번째 수를 c로 변경
				long diff = c - arr[b];
				arr[b] = c;
				
				update(1, n, 1, b, diff);
				break;
				
			// sum
			case 2:
				sb.append(sum(1, n, 1, b, (int)c) + "\n");
				break;
				
			default:
				continue;
			}
		}
		br.close();
		
		// 결과출력
		System.out.println(sb.toString());
	}
	
	// 트리 초기화
	private static long initTree(int start, int end, int nodeNum) {
		if(start == end)
			return tree[nodeNum] = arr[start];
		
		int mid = (start + end) / 2;
		
		// 자식노드 좌(nodeNum * 2), 우(nodeNum * 2 + 1)
		return tree[nodeNum] = initTree(start, mid, nodeNum * 2) + initTree(mid + 1, end, nodeNum * 2 + 1);
	}
	
	// 트리 업데이트
	private static void update(int start, int end, int nodeNum, int toEditIndex, long diff) {
		// 범위 밖에 있는 경우
		if(toEditIndex < start || end < toEditIndex)
			return;
		
		// 범위 안에 있는 경우 트리 갱신
		tree[nodeNum] += diff;
		
		// 재귀 종료조건(트리의 최하단인 경우)
		if(start == end)
			return;
		
		// 수정 할 노드를 전부 탐색
		int mid = (start + end) / 2;
		// 자식노드 좌
		update(start, mid, nodeNum * 2, toEditIndex, diff);
		// 자식노드 우
		update(mid + 1, end, nodeNum * 2 + 1, toEditIndex, diff);
	}
	
	// 구간 합 계산
	private static long sum(int start, int end, int nodeNum, int left, int right) {
		// 범위 밖에 있는 경우
		if(end < left || right < start)
			return 0;
		
		// 범위 안에 있는 경우
		if(left <= start && end <= right)
			return tree[nodeNum];
		
		// 범위 안(left ~ right)에 있는 값은 모두 합산
		int mid = (start + end) / 2;
		return sum(start, mid, nodeNum * 2, left, right) + sum(mid + 1, end, nodeNum * 2 + 1, left, right);
	}
	
}