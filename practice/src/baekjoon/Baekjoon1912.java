package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1912 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int[] nums = new int[n];
		
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) nums[i] = Integer.parseInt(strTkr.nextToken());
		br.close();
		
		int[] dp = new int[n];
		dp[0] = nums[0];
		int max = dp[0];
		// nums 배열의 index 1부터 n-1까지 이전 dp값 기준(연속적인 합의 max값)으로 현재값(nums)과 비교 탐색
		for(int i=1; i<n; i++) {
			dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
			max = Math.max(max, dp[i]);
		}
		
		System.out.println(max);
	}
	
}