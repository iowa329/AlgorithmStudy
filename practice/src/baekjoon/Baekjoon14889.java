package baekjoon;

import java.util.*;

public class Baekjoon14889 {
	
	static Scanner sc = new Scanner(System.in);
	static int n = sc.nextInt();
	
	static int[][] ability = new int[n][n];
	
	static int min = Integer.MAX_VALUE;
	
	
	public static void main(String[] args) {
		
		System.out.println("\n\n" + n);
		
		// 전 구성원 능력치 입력 받기
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ability[i][j] = sc.nextInt();
				System.out.print(ability[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
		
		System.out.println();
		// 팀 조합 및 능력차이 계산
		teamMix(0, n/2, n, new boolean[n]);
		
		System.out.println();
		System.out.print("result : " + min);
	}
	
	private static void teamMix(int startIndex, int toChoose, int n, boolean[] isTeamStart) {
		if(toChoose == 0) { // 더 이상 선택할 팀원이 없는 경우 조합 완성
//			System.out.println("완성된 조합 : " + Arrays.toString(isTeamStart));
			
			// 완성된 조합으로 start, link 팀 간 능력치 차이 계산
			int gap = 0;
			for(int i=0; i<n; i++) {
				for(int j=i; j<n; j++) { // 앞서 i번째에서 만난 팀원을 제외하고(순열이 아닌 조합이기에 순서상관x) j=i 부터 시작한다
					if (isTeamStart[i] == isTeamStart[j]) {
						int multiplier = (isTeamStart[i] == true) ? 1 : -1;
						gap += ability[i][j] * multiplier;
						gap += ability[j][i] * multiplier;	
					}
				}
//				System.out.println("현재 갭: " + gap);
			}
			min = Math.min(min, Math.abs(gap));
//			System.out.println("갭: " + gap + " / 최소값: " + min);
			
			return;
		}
		
		// 가능한 start,link 팀 조합 구성
		for(int i=startIndex; i<n-toChoose; i++) {
			isTeamStart[i] = true;
			teamMix(i+1, toChoose-1, n, isTeamStart); // 조합 재귀호출
			isTeamStart[i] = false;
		}
	}
	
}


// 제출코드

//import java.util.Scanner;
//
//public class Main {
//
//	static Scanner sc = new Scanner(System.in);
//	static int n = sc.nextInt();
//	
//	static int[][] ability = new int[n][n];
//	
//	static int min = Integer.MAX_VALUE;
//	
//	
//	public static void main(String[] args) {
//		
//		// 전 구성원 능력치 입력 받기
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				ability[i][j] = sc.nextInt();
//			}
//		}
//		sc.close();
//		
//		// 팀 조합 및 능력차이 계산
//		teamMix(0, n/2, n, new boolean[n]);
//		
//		System.out.print(min);
//	}
//	
//	private static void teamMix(int startIndex, int toChoose, int n, boolean[] isTeamStart) {
//		if(toChoose == 0) { // 더 이상 선택할 팀원이 없는 경우 조합 완성
//			
//			// 완성된 조합으로 start, link 팀 간 능력치 차이 계산
//			int gap = 0;
//			for(int i=0; i<n; i++) {
//				for(int j=i; j<n; j++) { // 앞서 i번째에서 만난 팀원을 제외하고(순열이 아닌 조합이기에 순서상관x) j=i 부터 시작한다
//					if (isTeamStart[i] == isTeamStart[j]) {
//						int multiplier = (isTeamStart[i] == true) ? 1 : -1;
//						gap += ability[i][j] * multiplier;
//						gap += ability[j][i] * multiplier;	
//					}
//				}
//			}
//			min = Math.min(min, Math.abs(gap));
//			
//			return;
//		}
//		
//		// 가능한 start,link 팀 조합 구성
//		for(int i=startIndex; i<n-toChoose; i++) {
//			isTeamStart[i] = true;
//			teamMix(i+1, toChoose-1, n, isTeamStart); // 조합 재귀호출
//			isTeamStart[i] = false;
//		}
//	}
//
//}