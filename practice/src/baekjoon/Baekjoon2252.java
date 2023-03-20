package baekjoon;

import java.io.*;
import java.util.*;

// 줄 세우기
public class Baekjoon2252 {

	// 위상정렬(Topological Sort)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(strTkr.nextToken());
		int m = Integer.parseInt(strTkr.nextToken());
		
		// 비교 대상이 되는 해당 학생의 언급횟수(위상정렬 진입차수)
		int[] cntHeightCompare = new int[n+1];
		
		// 학생들의 키 비교 정보 저장 배열
		ArrayList<ArrayList<Integer>> heightCompare = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			heightCompare.add(new ArrayList<Integer>());
		}
		
		// 키 비교 값 입력받기
		for(int i=0; i<m; i++) {
			strTkr = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(strTkr.nextToken());
			int b = Integer.parseInt(strTkr.nextToken());
			
			heightCompare.get(a).add(b);
			cntHeightCompare[b]++;
		}
		br.close();
		
		// 키 순서 큐
		Queue<Integer> heightOrderQueue = new LinkedList<>();
		for(int i=1; i<=n; i++) {
			if(cntHeightCompare[i] == 0)
				heightOrderQueue.add(i);
		}
		
		// 키 순서 출력
		StringBuilder sb = new StringBuilder();
		
		// 키 순서 탐색 - 위상정렬
		while(heightOrderQueue.isEmpty() == false) {
			int curHeight = heightOrderQueue.poll();
			
			// 키 순서 정답 입력
			sb.append(curHeight + " ");
			
			// 다음 키 순서 탐색
			ArrayList<Integer> nextHeightList = heightCompare.get(curHeight);
			for(int nextHeight: nextHeightList) {
				cntHeightCompare[nextHeight]--;
				
				// 앞 순서가 모두 줄 섰다면
				if(cntHeightCompare[nextHeight] == 0) {
					heightOrderQueue.add(nextHeight); // 자기차례
				}
			}
		}
		
		// 결과
		System.out.println(sb.toString());
	}
	
}