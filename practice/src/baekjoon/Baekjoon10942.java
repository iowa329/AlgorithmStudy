package baekjoon;

import java.io.*;
import java.util.*;

// 팰린드롬?
public class Baekjoon10942 {

	// 방법2-2. 다이나믹 프로그래밍(DP) with boolean
	
	// 결과
	// boolean과 int 배열 선언의 차이는 x
	// sb보다 bw를 사용했을 때 메모리 및 시간 개선 o
	// split보다 strTkr를 사용하여 정답을 작성했을 때 (매우) 개선 o
	
	// 최선>>
	// 메모리 238624 KB, 시간 860 ms
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		int[] numList = new int[n+1];
		for(int i=1; i<=n; i++)
			numList[i] = Integer.parseInt(strTkr.nextToken());
		
		// [시작s][끝e] dp배열 선언
		// 팰린드롬(palindrome)인 경우에는 1, 아닌 경우에는 0
		boolean[][] dp = new boolean[n+1][n+1];
		
		// step1. s ~ e의 길이가 1(시작과 끝이 같을)일 때
		for(int s=1; s<=n; s++) {
			int e = s;
			dp[s][e] = true;
		}
		
		// step2. s ~ e의 길이가 2(양 옆)일 때
		for(int s=1; s<=n-1; s++) {
			int e = s+1;
			if(numList[s] == numList[e])
				dp[s][e] = true;
		}
		
		// step3. s ~ e의 길이가 3 이상일 때
		for(int length=2; length<=n; length++) {
			for(int s=1; s+length<=n; s++) {
				int e = s+length;
				if(numList[s] == numList[e] && // 양 끝이 같고
					dp[s+1][e-1] == true) { // 시작과 끝 사이가 펠린드롬이라면
					dp[s][e] = true; // 펠린드롬
				}
			}
		}
		
		// 펠린드롬 판단 값 입력
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		// m개의 질문
		int m = Integer.parseInt(br.readLine());
		for(int i=0; i<m; i++) {
			strTkr = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(strTkr.nextToken());
			int e = Integer.parseInt(strTkr.nextToken());
			
			bw.append((dp[s][e] ? 1 : 0) + "\n");
		}
		br.close();
		
		// 결과
		bw.flush();
	}
	
	
//	// 방법2-1. 다이나믹 프로그래밍(DP) with int
//	// 메모리 318572 KB, 시간 1112 ms
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		StringTokenizer strTkr = new StringTokenizer(br.readLine());
//		int[] numList = new int[n+1];
//		for(int i=1; i<=n; i++)
//			numList[i] = Integer.parseInt(strTkr.nextToken());
//		
//		// [시작s][끝e] dp배열 선언
//		// 팰린드롬(palindrome)인 경우에는 1, 아닌 경우에는 0
//		int[][] dp = new int[n+1][n+1];
//		
//		// step1. s ~ e의 길이가 1(시작과 끝이 같을)일 때
//		for(int s=1; s<=n; s++) {
//			int e = s;
//			dp[s][e] = 1;
//		}
//		
//		// step2. s ~ e의 길이가 2(양 옆)일 때
//		for(int s=1; s<=n-1; s++) {
//			int e = s+1;
//			if(numList[s] == numList[e])
//				dp[s][e] = 1;
//		}
//		
//		// step3. s ~ e의 길이가 3 이상일 때
//		for(int length=2; length<=n; length++) {
//			for(int s=1; s+length<=n; s++) {
//				int e = s+length;
//				if(numList[s] == numList[e] && // 양 끝이 같고
//					dp[s+1][e-1] == 1) { // 시작과 끝 사이가 펠린드롬이라면
//					dp[s][e] = 1; // 펠린드롬
//				}
//			}
//		}
//		
//		// 펠린드롬 판단 값 입력
//		StringBuilder sb = new StringBuilder();
//		
//		// m개의 질문
//		int m = Integer.parseInt(br.readLine());
//		for(int i=0; i<m; i++) {
//			String[] info = br.readLine().split(" ");
//			int s = Integer.parseInt(info[0]);
//			int e = Integer.parseInt(info[1]);
//			
//			sb.append(dp[s][e] + "\n");
//		}
//		br.close();
//		
//		// 결과
//		System.out.println(sb.toString());
//	}
	
	
	
//	// 방법1. 완전탐색 
//	// 메모리 297836 KB, 시간 1724 ms
//		
//	static int[] numList;
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine());
//		StringTokenizer strTkr = new StringTokenizer(br.readLine());
//		numList = new int[n+1];
//		for(int i=1; i<=n; i++)
//			numList[i] = Integer.parseInt(strTkr.nextToken());
//		
//		StringBuilder sb = new StringBuilder();
//		
//		int m = Integer.parseInt(br.readLine());
//		for(int i=0; i<m; i++) {
//			String[] info = br.readLine().split(" ");
//			int s = Integer.parseInt(info[0]);
//			int e = Integer.parseInt(info[1]);
//			
//			sb.append(isPalindrome(s, e) + "\n");
//		}
//		br.close();
//		
//		System.out.println(sb.toString());
//	}
//	
//	private static int isPalindrome(int left, int right) {
//		// 팰린드롬(palindrome)인 경우에는 1, 아닌 경우에는 0
//		while(left < right) {
//			if(numList[left] != numList[right])
//				return 0;
//			
//			left++;
//			right--;
//		}
//		
//		return 1;
//	}
	
}