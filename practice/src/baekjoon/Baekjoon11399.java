package baekjoon;

import java.util.*;

public class Baekjoon11399 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 인출시간 입력 받기
		int[][] waiting = new int[n+1][2];		
		for(int i=1; i<=n; i++) {
			waiting[i][0] = i; // 사람순서
			waiting[i][1] = sc.nextInt(); // 인출시간
		}
		sc.close();

		// 인출시간 기준으로 정렬
		Arrays.sort(waiting, new Comparator<int[]>() {
			// 인터페이스인 comparator를 오버라이드 하여 구현
			@Override
			public int compare(int[] o1, int[] o2) {
				// 오름차순 정렬
				return o1[1] - o2[1]; 
			}
		});
		
		
		// Greedy
		int totalTime = 0;
		int waitingTime = 0;
		for(int i=1; i<=n; i++) {
			waitingTime += waiting[i][1];
			totalTime += waitingTime;
		}
		
		
		// 최소 인출대기시간
		System.out.println(totalTime);
	}

}


// 제출코드

//import java.util.*;
//
//public class Main {
//
//	public static void main(String[] args) {
//		
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		
//		// 인출시간 입력 받기
//		int[][] waiting = new int[n+1][2];		
//		for(int i=1; i<=n; i++) {
//			waiting[i][0] = i; // 사람순서
//			waiting[i][1] = sc.nextInt(); // 인출시간
//		}
//		sc.close();
//
//		// 인출시간 기준으로 정렬
//		Arrays.sort(waiting, new Comparator<int[]>() {
//			// 인터페이스인 comparator를 오버라이드 하여 구현
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				// 오름차순 정렬
//				return o1[1] - o2[1]; 
//			}
//		});
//		
//		
//		// Greedy
//		int totalTime = 0;
//		int waitingTime = 0;
//		for(int i=1; i<=n; i++) {
//			waitingTime += waiting[i][1];
//			totalTime += waitingTime;
//		}
//		
//		
//		// 최소 인출대기시간
//		System.out.println(totalTime);
//	}
//
//}