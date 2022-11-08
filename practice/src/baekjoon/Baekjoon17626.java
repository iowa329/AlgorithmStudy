package baekjoon;

import java.io.*;

public class Baekjoon17626 {

	static int n;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		br.close();
		
		// 인덱스의 제곱수 합의 자연수 개수 값 저장 dp(dynamic programming) 배열 선언
		int[] dp = new int[n+1];
		
		// 1부터 n까지 최소 제곱근의 개수를 점화식으로 계산하여 n의 최소 제곱근의 개수를 알아낸다
		dp[1] = 1;
		for(int num=2; num<=n; num++) {
			
			int min = 4; // 제곱수의 합의 최대 개수는 4개
			for(int root=1; root*root <= num; root++) {
				// 점화식 dp[i] = min(dp[i-j*j])+1
				// num의 제곱수 합의 개수: dp[root*root] + dp[(num - root*root)] = 1 + dp[(num - root*root)]
				min = Math.min(min, 1 + dp[num - root*root]);
			}
			dp[num] = min;
			
		}
		
		// 결과
		System.out.println(dp[n]);
	}
	
}

// idea memo

//dp[1] = 1
//dp[2] = dp[1] + dp[1]
//dp[3] = dp[1] + dp[2]
//dp[4] = 1
//dp[5] = dp[1] + dp[4]
//dp[6] = dp[1] + dp[5]
//      dp[4] + dp[2]
//dp[7] = dp[1] + dp[6]
//      dp[4] + dp[3]
//...
//dp[18] = dp[1] + dp[17]
//       dp[4] + dp[14]
//       dp[9] + dp[9]