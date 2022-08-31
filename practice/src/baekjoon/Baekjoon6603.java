package baekjoon;

import java.util.*;

public class Baekjoon6603 {

	static int[] arr = new int[6];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 여러개의 테스트 케이스 받기
		while(true) {
			int k = sc.nextInt();
			if(k == 0) break;
			
			// 배열값 입력받기
			int[] lotto = new int[k];
			for(int i=0; i<k; i++) {
				lotto[i] = sc.nextInt();
			}
			System.out.println("\n입력받은 배열: " + Arrays.toString(lotto));
			
			// lotto 순회(DFS 재귀호출)
			arrangement(0, 0, lotto, k);
			System.out.println();
		}
		sc.close();
		
	}
	
	private static void arrangement(int startIndex, int depth, int[] lotto, int k) {
		// 탐색조건 만족(순회하여 6번째 재귀)시 출력
		if(depth == 6) {
			for(int i=0; i<6; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=startIndex; i<k; i++) {
			arr[depth] = lotto[i];
			arrangement(i+1, depth+1, lotto, k);
		}
	}

}


//제출코드

//import java.util.*;
//
//public class Main {
//
//	static int[] arr = new int[6];
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		
//		while(true) {
//			int k = sc.nextInt();
//			if(k == 0) break;
//			
//			// 배열 입력
//			int[] lotto = new int[k];
//			for(int i=0; i<k; i++) {
//				lotto[i] = sc.nextInt();
//			}
//			
//			// lotto 순회(DFS 재귀호출)
//			arrangement(0, 0, lotto, k);
//			System.out.println();
//		}
//		sc.close();
//		
//	}
//	
//	private static void arrangement(int startIndex, int depth, int[] lotto, int k) {
//		// 탐색조건 만족(순회하여 6번째 재귀)시 출력
//		if(depth == 6) {
//			for(int i=0; i<6; i++) {
//				System.out.print(arr[i] + " ");
//			}
//			System.out.println();
//			return;
//		}
//		
//		for(int i=startIndex; i<k; i++) {
//			arr[depth] = lotto[i];
//			arrangement(i+1, depth+1, lotto, k);
//		}
//	}
//
//}