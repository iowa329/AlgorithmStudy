package baekjoon;

import java.io.*;
import java.util.*;

// 숨바꼭질 2
public class Baekjoon12851 {

	static int n;
	static int k;
	
	static Queue<Integer> que;
	
	static boolean[] visited;
	static int MAX_POS = 100_000;
	
	// BFS 너비 우선 탐색
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		n = Integer.parseInt(strTkr.nextToken());
		k = Integer.parseInt(strTkr.nextToken());
		br.close();
		
		visited = new boolean[MAX_POS+1];
		
		StringBuilder sb = new StringBuilder();
		
		int time = 0;
		if(k <= n) {
			sb.append(n-k + "\n");
			sb.append(1);
		} else {
			que = new LinkedList<>();			
			que.add(n);

			while(true) {
				int cnt = bfs();
				if(cnt > 0) {
					sb.append(time + "\n");
					sb.append(cnt);
					
					break;
				}
				
				time++;
			}
		}
		
		// 결과
		System.out.println(sb.toString());
	}
	
	private static int bfs() {
		int cnt = 0;
		
		int cases = que.size();
		for(int i=1; i<=cases; i++) {
			int curPos = que.poll();
			
			visited[curPos] = true;
			
			// 동생을 찾았다면
			if(curPos == k) {
				cnt++;
				
				// 동일한 시점에 동생을 찾을 수 있는 다른 경로가 있는지 확인
				continue;
			}
			
			if(curPos*2 <= MAX_POS && visited[curPos*2] == false)
				que.add(curPos*2);
			if(curPos+1 <= MAX_POS && visited[curPos+1] == false)
				que.add(curPos+1);
			if(0 <= curPos-1 && visited[curPos-1] == false)
				que.add(curPos-1);
		}
			
		return cnt;
	}
	
}