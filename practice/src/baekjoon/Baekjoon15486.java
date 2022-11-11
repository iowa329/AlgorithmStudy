package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon15486 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[][] consults = new int[n+2][2];
		for(int i=1; i<=n; i++) {
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			consults[i][0] =  Integer.parseInt(strTkr.nextToken()); // Ti
			consults[i][1] =  Integer.parseInt(strTkr.nextToken()); // Pi
		}
		br.close();
		
		int curMaxProfit = 0;
		int[] dp = new int[n+2]; // index 시점의 최대 pay값 dp배열
		for(int curDay=1; curDay<=n+1; curDay++) { // 정산은 curDay+1에 받기 때문에 최대값 탐색범위는 1~n이 아닌 1~n+1까지
			curMaxProfit = Math.max(curMaxProfit, dp[curDay]); // 현재(curDay) 시점까지의 최대수익
			
			int nextDay = curDay + consults[curDay][0];
			if(nextDay <= n+1) { // 현 index 시점에서 다음 상담 종료일이 근무일(정산일) 안에 있을 때
				// 현재시점까지의 최대수익과 다음상담 종료까지의 수익의 합이 여태계산된 다음 상담 종료 시점에서의 최대수익(dp[nextDay]) 값 보다 큰지 비교
				dp[nextDay] = Math.max(dp[nextDay], curMaxProfit + consults[curDay][1]);
			}
		}
		
		// curMaxProfit으로 curDay를 n+1까지 순차적으로 탐색하면 마지막 dp배열 값이 최대수익으로 결론난다
		System.out.println(dp[n+1]);
	}
	
}