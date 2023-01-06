package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon7579 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(strTkr.nextToken());
		int m = Integer.parseInt(strTkr.nextToken());
		
		int[] memory = new int[n+1];
		strTkr = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++)
			memory[i] = Integer.parseInt(strTkr.nextToken());
		
		int[] cost = new int[n+1];
		strTkr = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++)
			cost[i] = Integer.parseInt(strTkr.nextToken());
		br.close();
		
		// i: 0 ~ i번째 까지 입력된 앱에 대한 계산
		// j: 비활성화 된 앱 재실행 비용
		int[][] dp = new int[n+1][100001]; // 비용의 최대값은 100, (비용개수)n의 최대값은 100: 최대범위 100 x 100
		for(int i=1; i<=n; i++) {
			for(int j=0; j<=10000; j++) {
				// 현재 탐색비용이 i번째 비용에 비해 작으면
				if(j < cost[i]) {
					dp[i][j] = dp[i-1][j]; // 이전 값 적용
				} else {
					// 탐색비용이 크다면
					dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i]] + memory[i]); // 이전값과 비교해서 큰 값 적용
				}
			}
		}
		
		// m바이트 이상의 메모리 중에 최소비용을 구하기 위해
		for(int i=0; i<10001; i++) { // 0에서 부터 탐색하여
			if(dp[n][i] >= m) { // 가장 먼저 m바이트 이상 되는 메모리가 최소비용이다
				System.out.println(i);
				break;
			}
		}
	}
}