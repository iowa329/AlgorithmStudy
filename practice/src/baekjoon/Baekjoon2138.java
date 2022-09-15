package baekjoon;

import java.util.*;

public class Baekjoon2138 {

	static Scanner sc = new Scanner(System.in);
	
	static int n = sc.nextInt();
	
	static int[] currentLight = new int[n];
	static int[] toBeLight = new int[n];
	
	public static void main(String[] args) {
		System.out.println("\n");
		
		// 현재 전구상태
		String lightInfo = sc.next();
		for(int i=0; i<n; i++) {
			currentLight[i] = Character.getNumericValue(lightInfo.charAt(i));
			System.out.print(currentLight[i]+ " " );
		}
		
		// 목표 전구상태
		lightInfo = sc.next();
		for(int i=0; i<n; i++) {
			toBeLight[i] = Character.getNumericValue(lightInfo.charAt(i));
			System.out.print(toBeLight[i]+ " " );
		}
		sc.close();
		
		
		// 경우의 수 탐색
		int[] lightCase;
		
		// 첫번째 전구를 켜는 경우
		lightCase = currentLight.clone();
		
		lightCase[0] = toggleLight(lightCase[0]);
		lightCase[1] = toggleLight(lightCase[1]);
		
		int turnOnFirstCnt = light(lightCase, 1);
		
		
		// 첫번째 전구를 켜지 않는 경우
		lightCase = currentLight.clone();
		int turnOffFirstCnt = light(lightCase, 0);
		
		
		// 최소 스위치 횟수 찾기
		int answer = 0;
		if(turnOnFirstCnt == -1 && turnOffFirstCnt == -1) {
			answer = -1;
		} else if(turnOnFirstCnt != -1 && turnOffFirstCnt != -1) {
			answer = turnOnFirstCnt < turnOffFirstCnt ? turnOnFirstCnt : turnOffFirstCnt;
		} else {
			answer = turnOnFirstCnt != -1 ? turnOnFirstCnt : turnOffFirstCnt;
		}

		// 결과
		System.out.println("\n\n" + answer);
	}
	
	// Greedy
	private static int light(int[] targetCaseLight, int lightCnt) {
		int lastIndex = n-1;
		
		for(int i=1; i<n; i++) {
			// 현재 인덱스 이전 전구가 만들고자 하는 전구가 아닐경우
			if(targetCaseLight[i-1] != toBeLight[i-1]) {
				if(i != lastIndex) {
					targetCaseLight[i-1] = toggleLight(targetCaseLight[i-1]);
					targetCaseLight[i] = toggleLight(targetCaseLight[i]);
					targetCaseLight[i+1] = toggleLight(targetCaseLight[i+1]);					
				} else {
					// 마지막 인덱스
					targetCaseLight[i-1] = toggleLight(targetCaseLight[i-1]);
					targetCaseLight[i] = toggleLight(targetCaseLight[i]);
				}
				lightCnt++;
			}
		}
		
		// 마지막 전구가 만들고자 하는 상태가 아닌경우
		if(targetCaseLight[lastIndex] != toBeLight[lastIndex]) {
			lightCnt = -1;
		}
		
		return lightCnt;
	}
	
	private static int toggleLight(int lightInfo) {
		return lightInfo = lightInfo == 0 ? 1 : 0;
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
//	
//	static int[] currentLight = new int[n];
//	static int[] toBeLight = new int[n];
//	
//	public static void main(String[] args) {
//		// 현재 전구상태
//		String lightInfo = sc.next();
//		for(int i=0; i<n; i++) {
//			currentLight[i] = Character.getNumericValue(lightInfo.charAt(i));
//		}
//		
//		// 목표 전구상태
//		lightInfo = sc.next();
//		for(int i=0; i<n; i++) {
//			toBeLight[i] = Character.getNumericValue(lightInfo.charAt(i));
//		}
//		sc.close();
//		
//		
//		// 경우의 수 탐색
//		int[] lightCase;
//		
//		// 첫번째 전구를 켜는 경우
//		lightCase = currentLight.clone();
//		
//		lightCase[0] = toggleLight(lightCase[0]);
//		lightCase[1] = toggleLight(lightCase[1]);
//		
//		int turnOnFirstCnt = light(lightCase, 1);
//		
//		
//		// 첫번째 전구를 켜지 않는 경우
//		lightCase = currentLight.clone();
//		int turnOffFirstCnt = light(lightCase, 0);
//		
//		
//		// 최소 스위치 횟수 찾기
//		int answer = 0;
//		if(turnOnFirstCnt == -1 && turnOffFirstCnt == -1) {
//			answer = -1;
//		} else if(turnOnFirstCnt != -1 && turnOffFirstCnt != -1) {
//			answer = turnOnFirstCnt < turnOffFirstCnt ? turnOnFirstCnt : turnOffFirstCnt;
//		} else {
//			answer = turnOnFirstCnt != -1 ? turnOnFirstCnt : turnOffFirstCnt;
//		}
//
//		// 결과
//		System.out.println(answer);
//	}
//	
//	// Greedy
//	private static int light(int[] targetCaseLight, int lightCnt) {
//		int lastIndex = n-1;
//		
//		for(int i=1; i<n; i++) {
//			// 현재 인덱스 이전 전구가 만들고자 하는 전구가 아닐경우
//			if(targetCaseLight[i-1] != toBeLight[i-1]) {
//				if(i != lastIndex) {
//					targetCaseLight[i-1] = toggleLight(targetCaseLight[i-1]);
//					targetCaseLight[i] = toggleLight(targetCaseLight[i]);
//					targetCaseLight[i+1] = toggleLight(targetCaseLight[i+1]);					
//				} else {
//					// 마지막 인덱스
//					targetCaseLight[i-1] = toggleLight(targetCaseLight[i-1]);
//					targetCaseLight[i] = toggleLight(targetCaseLight[i]);
//				}
//				lightCnt++;
//			}
//		}
//		
//		// 마지막 전구가 만들고자 하는 상태가 아닌경우
//		if(targetCaseLight[lastIndex] != toBeLight[lastIndex]) {
//			lightCnt = -1;
//		}
//		
//		return lightCnt;
//	}
//	
//	private static int toggleLight(int lightInfo) {
//		return lightInfo = lightInfo == 0 ? 1 : 0;
//	}
//
//}