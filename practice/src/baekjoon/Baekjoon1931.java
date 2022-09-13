package baekjoon;

import java.util.*;

public class Baekjoon1931 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		// 일정표 입력 받기
		int[][] meeting = new int[n][2];		
		for(int i=0; i<n; i++) {
			meeting[i][0] = sc.nextInt(); // 시작시간
			meeting[i][1] = sc.nextInt(); // 종료시간
		}
		sc.close();
		
		
		// 입력받은 일정표 종료시간 기준으로 정렬
		Arrays.sort(meeting, new Comparator<int[]>() {
			// 인터페이스인 comparator를 오버라이드 하여 구현
			@Override
			public int compare(int[] o1, int[] o2) {
				// 만약 배열의 두번쨰 원소([1] -> 종료시간)가 같다면
				if(o1[1] == o2[1]) { 
					// 첫번쨰 원소([0] -> 시작시간)을 오름차순 정렬(수식의 결과값이 음수이면 선행원소가 작다는 의미로 오름차순이다. 값을 바꾸지 않는다)
					return o1[0] - o2[0]; 
				} else {
					// 그 외의 경우에는 종료시간 기준으로 오름차순 정렬
					return o1[1] - o2[1]; 
				}
			}
		});
		
		
		// Greedy
		int cnt = 1;
		int beforeEndTime = meeting[0][1];
		for(int i=1; i<n; i++) {
			int nextStartTime = meeting[i][0];
			if(nextStartTime >= beforeEndTime) {
				cnt++;
				beforeEndTime = meeting[i][1]; // nextStartTime의 종료시간으로 갱신
			}
		}
		
		
		// 배정결과 최대 회의개수
		System.out.println(cnt);
	}

}


// 제출코드

//import java.util.*;
//
//public class Main {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		
//		// 일정표 입력 받기
//		int[][] meeting = new int[n][2];		
//		for(int i=0; i<n; i++) {
//			meeting[i][0] = sc.nextInt(); // 시작시간
//			meeting[i][1] = sc.nextInt(); // 종료시간
//		}
//		sc.close();
//		
//		
//		// 입력받은 일정표 종료시간 기준으로 정렬
//		Arrays.sort(meeting, new Comparator<int[]>() {
//			// 인터페이스인 comparator를 오버라이드 하여 구현
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				// 만약 배열의 두번쨰 원소([1] -> 종료시간)가 같다면
//				if(o1[1] == o2[1]) { 
//					// 첫번쨰 원소([0] -> 시작시간)을 오름차순 정렬(수식의 결과값이 음수이면 선행원소가 작다는 의미로 오름차순이다. 값을 바꾸지 않는다)
//					return o1[0] - o2[0]; 
//				} else {
//					// 그 외의 경우에는 종료시간 기준으로 오름차순 정렬
//					return o1[1] - o2[1]; 
//				}
//			}
//		});
//		
//		
//		// Greedy
//		int cnt = 1;
//		int beforeEndTime = meeting[0][1];
//		for(int i=1; i<n; i++) {
//			int nextStartTime = meeting[i][0];
//			if(nextStartTime >= beforeEndTime) {
//				cnt++;
//				beforeEndTime = meeting[i][1]; // nextStartTime의 종료시간으로 갱신
//			}
//		}
//		
//		
//		// 배정결과 최대 회의개수
//		System.out.println(cnt);
//	}
//
//}