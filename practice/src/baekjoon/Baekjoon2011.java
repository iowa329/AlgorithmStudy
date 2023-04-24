package baekjoon;

import java.io.*;

// 암호코드
public class Baekjoon2011 {

	final static long DIVISION = 1_000_000L;
	
	// DP 다이나믹 프로그래밍
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String code = br.readLine();
		br.close();
		
		// i 자리일 때, 가능한 암호의 개수 
		long[] dp = new long[code.length()+1];
		dp[0] = 1;
		for(int i=1; i<=code.length(); i++) {
			int oneDigit = code.charAt(i-1) - '0';
			if(1 <= oneDigit && oneDigit <= 9) {
				dp[i] += dp[i-1];
				dp[i] %= DIVISION;
			}
			
			if(i == 1)
				continue;
			
			int tenDigit = code.charAt(i-2) - '0';
			
			if(tenDigit == 0)
				continue;
			
			int tenNumber = tenDigit * 10 + oneDigit;
			if(10 <= tenNumber && tenNumber <= 26) {
				dp[i] += dp[i-2];
				dp[i] %= DIVISION;
			}
		}
		
		// 결과
		System.out.println(dp[code.length()]);
	}
	
}