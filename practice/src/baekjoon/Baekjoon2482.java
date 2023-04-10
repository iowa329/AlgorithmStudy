package baekjoon;

import java.io.*;

// 색상환
public class Baekjoon2482 {

	static int DIVISON = 1_000_000_003;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		br.close();

		// i개의 색이 있을 때, j개의 색을 선택할 수 있는 경우의 수 dp배열 선언
		int[][] dp = new int[n+1][n+1];
		
		// dp 초기화
		for(int i=1; i<=n; i++) {
			dp[i][1] = i; // i개의 색 중에 하나를 선택하는 경우의 수는 i개
			dp[i][0] = 1; // 선택하지 않는 경우는 1로 초기화
		}
		
		for(int i=3; i<=n; i++) {
			// n개의 색상 중 (n/2)보다 많이 선택할 수 있는 경우의 수는 없으므로 범위는 n/2까지 설정
			for(int j=2; j<=(i+1)/2; j++) {
				// i번째를 선택한 경우 + i번째를 선택하지 않은 경우
				dp[i][j] = (dp[i-2][j-1] + dp[i-1][j]) % DIVISON;
			}
		}
		
		// 결과
		// n번째 색을 선택한 경우 + n번째 색을 선택하지 않은 경우 <-- *이해 필요
        System.out.println(((dp[n - 3][k - 1] + dp[n - 1][k]) % DIVISON));
	}
	// <*-- 복습필요..
	
}
