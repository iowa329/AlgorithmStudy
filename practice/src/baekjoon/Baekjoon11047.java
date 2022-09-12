package baekjoon;

import java.util.*;

public class Baekjoon11047 {

	static Scanner sc = new Scanner(System.in);
	
	static int n = sc.nextInt();
	static int k = sc.nextInt();

	static int[] coins = new int[n];
	
	public static void main(String[] args) {
		
		int startIndex = n-1;
		
		// 입력값 받기
		for(int i=0; i<n; i++) {
			int coin = sc.nextInt();
			if(coin > k) {
				startIndex = i-1;
				break;
			}
			coins[i] = coin;
		}
		sc.close();
		System.out.println();
		
		int result = findCoinSumMin(startIndex);
		System.out.println(result);
	}

	private static int findCoinSumMin(int startIndex) {
		int cnt = 0;
		
		// 오름차순 마지막(동전 금액이 큰 순서)부터 작은순으로 탐색
		for(int i=startIndex; i>=0; i--) {
			int coin = coins[i];
			cnt += k/coin;
			k = k%coin;
		}
		
		return cnt;
	}
	
}


// 제출코드

//import java.util.*;
//
//public class Main {
//
//	static Scanner sc = new Scanner(System.in);
//	
//	static int n = sc.nextInt();
//	static int k = sc.nextInt();
//
//	static int[] coins = new int[n];
//	
//	public static void main(String[] args) {
//		
//		int startIndex = n-1;
//		
//		// 입력값 받기
//		for(int i=0; i<n; i++) {
//			int coin = sc.nextInt();
//			if(coin > k) {
//				startIndex = i-1;
//				break;
//			}
//			coins[i] = coin;
//		}
//		sc.close();
//		
//		int result = findCoinSumMin(startIndex);
//		System.out.println(result);
//	}
//
//	private static int findCoinSumMin(int startIndex) {
//		int cnt = 0;
//		
//		for(int i=startIndex; i>=0; i--) {
//			int coin = coins[i];
//			cnt += k/coin;
//			k = k%coin;
//		}
//		
//		return cnt;
//	}
//	
//}