package baekjoon;

import java.io.*;
import java.util.*;

// 내리막 길
public class Baekjoon1520 {

	static int n, m;
	static int[][] map, dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		n = Integer.parseInt(strTkr.nextToken());
		m = Integer.parseInt(strTkr.nextToken());
		
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			strTkr = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(strTkr.nextToken());
			}
		}
		br.close();
		
		// dp배열 -1로 초기화
		dp = new int[n][m];
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				dp[i][j] = -1;
		
		// DFS + DP
		int result = findDownhillRoute(0, 0);
		
		// 결과
		System.out.println(result);
	}
	
	// DFS
	private static int findDownhillRoute(int x, int y) {
		// 도착지점에 도달했다면
		if(x == n-1 && y == m-1) {
			System.out.println("end");
			return 1;
		}

		// 방문처리
		dp[x][y] = 0;
		
		// 상하좌우 탐색
		int[] moveX = {-1, 1, 0, 0};
		int[] moveY = {0, 0, -1, 1};
		for(int direction=0; direction<4; direction++) {
			int movedX = x + moveX[direction];
			int movedY = y + moveY[direction];
			
			// 범위 안에 있고
			if(0 <= movedX && movedX < n && 
				0 <= movedY && movedY < m &&
				// 내리막길 일 때
				map[movedX][movedY] < map[x][y]) {
				
				// 방문한적이 없다면
				if(dp[movedX][movedY] == -1) {
					dp[x][y] += findDownhillRoute(movedX, movedY); // 다음경로 탐색
				} else
				// 가는 경로가 있다면
				if(dp[movedX][movedY] >= 1) {
					dp[x][y] += dp[movedX][movedY]; // 기존경로 저장(탐색 중단)
				}
			}
		}
		
		System.out.println("end2");
		for(int[] visit: dp) {
			System.out.println(Arrays.toString(visit));
		}
		System.out.println();
		
		return dp[x][y];
	}
	
}