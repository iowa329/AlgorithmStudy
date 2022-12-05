package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon3584 {
	
	// 트리
	// 가장 가까운 공통 조상
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		while(t >= 1) {
			int n = Integer.parseInt(br.readLine());
			int[] parent = new int[n+1];
			
			for(int node=1; node<=n-1; node++) {
				StringTokenizer strTkr = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(strTkr.nextToken());
				int b = Integer.parseInt(strTkr.nextToken());
				
				parent[b] = a;
			}
			
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			int toFindCommonAncestorA = Integer.parseInt(strTkr.nextToken());
			int toFindCommonAncestorB = Integer.parseInt(strTkr.nextToken());
			
			// bottom-up 방식으로 주어진 두 노드들로 부터 최상위 부모노드까지 올라가면서 탐색
			boolean[] visit = new boolean[n+1];
			int node = toFindCommonAncestorA;
			// a 노드에 대해 트리의 최상위 부모 노드 찾아가기
			while(node > 0) { // parent배열 중 노드가 없을 경우에는 0, 즉 최상위 부모노드라는 뜻
				visit[node] = true; // a 노드의 지나온 부모노드들 방문처리
				node = parent[node];
			}
			
			// b 노드에 대해 트리의 최상위 부모 노드를 찾을 때 이미 방문한 경우 a가 방문한 부모노드들과 최초로 일치하는 것이므로 답 출력 후 while문 종료
			node = toFindCommonAncestorB;
			while(node > 0) {
				if(visit[node]) {
					sb.append(node + "\n");
					break;
				}
				
				node = parent[node];
			}
			
			t--;
		}
		br.close();
		
		// 결과출력
		System.out.println(sb.toString());
	}
	
}