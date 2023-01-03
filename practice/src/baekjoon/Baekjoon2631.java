package baekjoon;

import java.io.*;

public class Baekjoon2631 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		int[] line = new int[n];
		for(int i=0; i<n; i++)
			line[i] = Integer.parseInt(br.readLine());
		br.close();

		// 최장 증가 부분 수열(LIS, Longest Increasing Subsequence) dp 선언
		int[] dp = new int[n];
		
		int maxLine = 0;
		for(int k=0; k<n; k++) {
			dp[k] = 1; // 자기 자신 혼자일 경우 줄의 길이 기본값 1
			for(int i=0; i<k; i++) {
				// 현재 서있는 아이의 번호(i)가 기준 아이의 번호(k)보다 작을 경우 순서가 맞으므로
				if(line[i] < line[k])
					dp[k] = Math.max(dp[k], dp[i] + 1);
				
				maxLine = Math.max(maxLine, dp[k]);
			}
		}
		
		// 최소로 이동할 아이의 수는 최장 증가 부분 수열(가장 길게 정렬되어 있는 부분줄의 길이)을 제외한 아이의 수
		System.out.println(n - maxLine);
	}
	
}