package baekjoon;

import java.io.*;
import java.util.*;

// 욕심쟁이 판다
public class Baekjoon1937 {

	static int[][] bambooForest;
	static int n;
	
	static int[][] dp;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		bambooForest = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				bambooForest[i][j] = Integer.parseInt(strTkr.nextToken());
			}
		}
		br.close();
		
		// DFS + DP
		dp = new int[n][n];
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				max = Math.max(max, dfs(i, j));

				for(int[] d: dp) {
					System.out.println(Arrays.toString(d));
				}
				System.out.println();
				
			}
		}
		
		// 결과
		System.out.println(max);
	}
	
	// DFS
	private static int dfs(int x, int y) {
		// 이미 경로값을 갖고 있다면
		if(dp[x][y] != 0) {
			return dp[x][y];
		}
		
		dp[x][y] = 1;
		
		// 상하좌우 탐색
		int[] moveX = {-1, 1, 0, 0};
		int[] moveY = {0, 0, -1, 1};
		for(int direction=0; direction<4; direction++) {
			int movedX = x + moveX[direction];
			int movedY = y + moveY[direction];
			
			// 범위 안에 있고
			if(0 <= movedX && movedX < n && 
				0 <= movedY && movedY < n) {
				
				// 현재 대나무 보다 더 많은 대나무가 있다면
				if(bambooForest[x][y] < bambooForest[movedX][movedY]) {
					dp[x][y] = Math.max(dp[x][y], dfs(movedX, movedY) + 1);
					dfs(movedX, movedY);
				}
			}
		}
		
		return dp[x][y];
	}
	
}