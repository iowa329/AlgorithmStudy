package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon12865 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(strTkr.nextToken());
		int k = Integer.parseInt(strTkr.nextToken());
	
		int[] w = new int[n+1]; // 무게 w
		int[] v = new int[n+1]; // 가치 v
		for(int i=1; i<=n; i++) {
			strTkr = new StringTokenizer(br.readLine());
			w[i] = Integer.parseInt(strTkr.nextToken());
			v[i] = Integer.parseInt(strTkr.nextToken());
		}
		br.close();
		
		int[][] dp = new int[k+1][n+1]; // 넣을 수 있는 무게의 최대 가치값 dp배열 선언
		for(int searchWeight=1; searchWeight<=k; searchWeight++) { // 버틸 수 있는 최대 무게 k
			for(int searchIndex=1; searchIndex<=n; searchIndex++) { // 탐색할 물건 1~n개까지
				int curIndexWeight = w[searchIndex];
				int curIndexValue = v[searchIndex];
				int beforeIndexValue = dp[searchWeight][searchIndex-1];
				// 무게를 더 담을 수 없는 경우
				if(curIndexWeight > searchWeight) {
					dp[searchWeight][searchIndex] = beforeIndexValue;
				} else {
					// 무게를 더 담을 수 있는 경우
					dp[searchWeight][searchIndex] = Math.max(beforeIndexValue, curIndexValue + dp[searchWeight-curIndexWeight][searchIndex-1]);
				}
			}
		}
		
		// 최대 k무게를 버티는 n번째 물품까지의 탐색 결과의 최대값 출력
		System.out.println(dp[k][n]);
	}
	
}

// 구현1 DFS (시간초과)

//public class Baekjoon12865 {
//
//	static int n, k;
//	static int[][] stuff;
//	static boolean[] combi;
//	static int maxValue = 0;
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer strTkr = new StringTokenizer(br.readLine());
//		n = Integer.parseInt(strTkr.nextToken());
//		k = Integer.parseInt(strTkr.nextToken());
//	
//		stuff = new int[n][2];
//		int totalWeight = 0;
//		for(int i=0; i<n; i++) {
//			strTkr = new StringTokenizer(br.readLine());
//			stuff[i][0] = Integer.parseInt(strTkr.nextToken()); // 무게 w
//			stuff[i][1] = Integer.parseInt(strTkr.nextToken()); // 가치 v
//			
//			totalWeight += stuff[i][0];
//		}
//		br.close();
//		
//		combi = new boolean[n];
//		Arrays.fill(combi, true);
//		
//		dfs(0, totalWeight);
//		
//		System.out.println(maxValue);
//	}
//	
//	private static void dfs(int startIndex, int weight) {
//		if(weight <= k) {
//			int totalValue = 0;
//			for(int i=0; i<n; i++) {
//				if(combi[i]) {
//					totalValue += stuff[i][1];
//				}
//			}
//			maxValue = Math.max(maxValue, totalValue);
//			
//			return;
//		}
//		
//		for(int i=startIndex; i<n; i++) {
//			if(combi[i] == true) {
//				combi[i] = false;
//				dfs(i+1, weight - stuff[i][0]);
//				combi[i] = true;
//			}
//		}
//	}
//}