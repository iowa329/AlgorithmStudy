package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon9084 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int cases=1; cases<=t; cases++) {
			// 동전 종류 입력받기
			int n = Integer.parseInt(br.readLine());
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			
			// 만들어야 할 금액 m
			int m = Integer.parseInt(br.readLine());
			
			// index금액을 만들 수 있는 동전의 조합 경우의 수를 누적 저장할 dp배열 선언
			int[] dp = new int[m+1];
			dp[0] = 1; // 0원으로 만들 수 있는 조합의 개수는 1개
			
			// 각 coin의 금액으로 amount값을 조합할 수 있는 경우 탐색
			for(int i=1; i<=n; i++) {
				int coin = Integer.parseInt(strTkr.nextToken());
				
				// 1~m 까지 금액에 대해 (오름차순으로 주어진)coin의 조합의 수를 누적(이전 coin의 조합의 수) 저장
				for(int amount=coin; amount<=m; amount++) // coin 이하의 액수에서는 coin의 조합이 불가능하므로 coin부터 범위 시작
					dp[amount] += dp[amount - coin]; // coin 차이만큼의 이전 조합 개수가 현재 금액에 대한 coin의 조합개수와 동일하다
			}
			
			sb.append(dp[m] + "\n");
		}
		br.close();
		
		// 결과
		System.out.println(sb.toString());
	}
	
}