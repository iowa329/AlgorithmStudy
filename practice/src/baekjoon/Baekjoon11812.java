package baekjoon;

import java.io.*;
import java.util.*;

// K진 트리
public class Baekjoon11812 {

	// 가장 가까운 공통 조상
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		long n = Long.parseLong(strTkr.nextToken()); // 노드 개수 N
		int k = Integer.parseInt(strTkr.nextToken()); // 최대 K개 가질 수 있는 트리
		int q = Integer.parseInt(strTkr.nextToken()); // 거리를 구해야 하는 노드 쌍의 개수 Q
		
		// 해당 인덱스(노드)의 부모노드 번호 저장 배열
		long[] parent = new long[n+1];
		
		// K진 트리의 부모노드 정보 입력
		parent[1] = 0;
		long parentNum = 1L;
		int count = 0;
		for(int node=2; node<=n; node++) {
			if(count == k) {
				parentNum++;
				count = 0;
			}
			
			parent[node] = parentNum;
			count++;
		}
		
		// 주어진 두 노드 x와 y 사이의 거리를 계산
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=q; i++) {
			strTkr = new StringTokenizer(br.readLine());
			int node1 = Integer.parseInt(strTkr.nextToken());
			int node2 = Integer.parseInt(strTkr.nextToken());
			
			boolean[] visited = new boolean[n+1];
			
			// 첫번째 노드 조상 탐색
			int[] distance = new int[n+1];
			int cnt1 = 0;
			while(node1 > 0) {
				visited[node1] = true; // 현재 노드 방문처리
				distance[node1] = cnt1++; // 현재 거리값 저장 후 1 증가
				
				node1 = parent[node1]; // 현재 노드의 부모 찾기
			}
			
			// 두번째 노드 조상 탐색
			int cnt2 = 0;
			while(node2 > 0) {
				// 첫번째 노드(node1)가 방문한 곳과 최초로 일치하는 곳이 두 노드 간의 최소거리 지점
				if(visited[node2])
					break;
				
				// 아직 방문한 곳을 찾지 못했으면 부모 값 갱신
				node2 = parent[node2];
				// 부모 값 갱신 후 거리 1 증가
				cnt2++;
			}
			
			// 두 노드 간 거리 입력
			sb.append(distance[node2]+cnt2+"\n");
		}
		br.close();
		
		// 결과
		System.out.println(sb.toString());
	}
	
}



























