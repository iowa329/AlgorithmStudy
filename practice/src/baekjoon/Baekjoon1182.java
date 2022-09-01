package baekjoon;

import java.util.*;

public class Baekjoon1182 {

	static Scanner sc = new Scanner(System.in);
	
	static int n = sc.nextInt();
	static int s = sc.nextInt();
	
	static int[] arr = new int[n];
	static boolean[] checked = new boolean[n];
	
	static int cnt = 0;
	
	public static void main(String[] args) {
		
		// N개의 정수 입력 받기
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		// 부분 수열 구하기
		subset(0);
		
		// 결과
		System.out.println("\nresult: " + cnt);
	}
	
	// 부분집합 함수
	private static void subset(int depth) {
		if(depth == n) {
			int sum = 0;
			boolean isEmpty = true;
			for(int i=0; i<n; i++) {
				if (checked[i] == true) {
					isEmpty = false;
					
					sum += arr[i];
					System.out.print(arr[i] + " ");
				}
			}
			System.out.println("\nsum: " + sum);
			System.out.println("isEmpty: " + isEmpty);
			
			if (isEmpty == false && sum == s) {
				cnt++;
			}
			
			return;
		}
		
		checked[depth] = true;
		subset(depth+1);
		
		checked[depth] = false;
		subset(depth+1);
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
//	static int s = sc.nextInt();
//	
//	static int[] arr = new int[n];
//	static boolean[] checked = new boolean[n];
//	
//	static int cnt = 0;
//	
//	public static void main(String[] args) {
//		
//		// N개의 정수 입력 받기
//		for(int i=0; i<n; i++) {
//			arr[i] = sc.nextInt();
//		}
//		sc.close();
//		
//		// 부분 수열 구하기
//		subset(0);
//		
//		System.out.println(cnt);
//	}
//	
//	// 부분집합 함수
//	private static void subset(int depth) {
//		if(depth == n) {
//			int sum = 0;
//			boolean isEmpty = true;
//			for(int i=0; i<n; i++) {
//				if (checked[i] == true) {
//					isEmpty = false;
//					
//					sum += arr[i];
//				}
//			}
//			
//			if (isEmpty == false && sum == s) {
//				cnt++;
//			}
//			
//			return;
//		}
//		
//		checked[depth] = true;
//		subset(depth+1);
//		checked[depth] = false;
//		subset(depth+1);
//	}
//
//}