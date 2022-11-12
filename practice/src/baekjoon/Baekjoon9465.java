package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon9465 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int cases=1; cases<=t; cases++) {
			// 스티커 정보 입력받기
			int n = Integer.parseInt(br.readLine());
			int[][] stickers = new int[2][n+1]; // dp에서 계산식을 편리하게 하기 위해 0번째 인덱스를 공란처리하기 위해 n+1 크기의 배열 선언
			for(int i=0; i<2; i++) {
				StringTokenizer strTkr = new StringTokenizer(br.readLine());
				for(int j=1; j<=n; j++) {
					stickers[i][j] = Integer.parseInt(strTkr.nextToken());
				}
			}

			// 스티커를 떼었을 때 누적 최대값을 저장할 dp배열 선언
			int[][] dp = new int[2][n+1];
			
			// 첫번째 인덱스의 스티커 최대값은 기본 스티커 값이므로
			dp[0][1] = stickers[0][1];
			dp[1][1] = stickers[1][1];
			
			// 두번째 인덱스부터 최대값 탐색 시작
			for(int j=2; j<=n; j++) {
				dp[0][j] = Math.max(dp[1][j-2], dp[1][j-1]) + stickers[0][j];
				dp[1][j] = Math.max(dp[0][j-2], dp[0][j-1]) + stickers[1][j];
			}
			
			// 누적된 최대값을 저장하는 배열이 dp이므로 2~n까지 탐색했을 때 스티커를 떼는 최대값은 dp배열에서 마지막인 n번째 인덱스에 있다
			System.out.println(Math.max(dp[0][n], dp[1][n]));
		}
		br.close();
	}
	
}