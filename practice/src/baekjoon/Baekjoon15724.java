package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon15724 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(strTkr.nextToken());
		int m = Integer.parseInt(strTkr.nextToken());
		int[][] territory = new int[n+1][m+1];
		
		// (1,1) ~ (x, y) 까지의 직사각형 총 인구수의 합을 저장할 dp배열 선언
		int[][] dp = new int[n+1][m+1];
		
		// 인구 정보 입력 및 dp값 계산
		for(int i=1; i<=n; i++) {
			strTkr = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				territory[i][j] = Integer.parseInt(strTkr.nextToken());
				dp[i][j] = dp[i-1][j] + dp[i][j-1] + territory[i][j] - dp[i-1][j-1];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		
		// 인구 수를 궁금해하는 직사각형 범위의 개수 입력 및 정답입력 
		int k = Integer.parseInt(br.readLine());
		for(int i=0; i<k; i++) {
			strTkr = new StringTokenizer(br.readLine());
			int x1 = Integer.parseInt(strTkr.nextToken());
			int y1 = Integer.parseInt(strTkr.nextToken());
			int x2 = Integer.parseInt(strTkr.nextToken());
			int y2 = Integer.parseInt(strTkr.nextToken());
			
			// dp기준 : x2, y2 - 왼쪽 직사각형 - 윗쪽 직사각형 - 중복된 직사격형
			sb.append(dp[x2][y2] - dp[x2][y1-1] - dp[x1-1][y2] + dp[x1-1][y1-1] + "\n");
		}
		br.close();
		
		// 결과 출력
		System.out.println(sb.toString());
	}
	
}