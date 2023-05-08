package baekjoon;

import java.io.*;

// 극장 좌석
public class Baekjoon2302 {

	// DP(다이나믹 프로그래밍)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 좌석 개수
		int m = Integer.parseInt(br.readLine()); // 고정석 개수
		
		// 초기화
		int[] dp = new int[40+1];
		dp[0] = 1;
		dp[1] = 1;
		dp[2] = 2;
		for(int i=3; i<=n; i++)
			dp[i] = dp[i-1] + dp[i-2];
		
		int answer = 1;
		
		int previousVIP = 0;
		for(int i=1; i<=m; i++) {
			int curVIP = Integer.parseInt(br.readLine());
			answer *= dp[curVIP - previousVIP - 1];
			previousVIP = curVIP;
		}
		br.close();
		answer *= dp[n - previousVIP];
		
		// 결과
		System.out.println(answer);
	}
	
}