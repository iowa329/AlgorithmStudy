package baekjoon;

import java.util.*;

public class Baekjoon2138 {

	static Scanner sc = new Scanner(System.in);
	
	static int n = sc.nextInt();
	
	static int[] currentLight = new int[n];
	static int[] toBeLight = new int[n];
	
	public static void main(String[] args) {
		
		// 전구정보 입력받기
		// 현재 전구상태
		String lightInfo = sc.next();
		for(int i=0; i<n; i++) {
			currentLight[i] = Character.getNumericValue(lightInfo.charAt(i));
			System.out.print(currentLight[i]+ " " );
		}
		System.out.println();
		
		// 목표 전구상태
		lightInfo = sc.next();
		for(int i=0; i<n; i++) {
			toBeLight[i] = Character.getNumericValue(lightInfo.charAt(i));
			System.out.print(toBeLight[i]+ " " );
		}
		sc.close();
		
		
		// Greedy
		// 첫번째 전구를 켜는 경우
		int[] turnOnFirstLight = currentLight.clone();
		turnOnFirstLight[0] = toggleLight(turnOnFirstLight[0]);
		turnOnFirstLight[1] = toggleLight(turnOnFirstLight[1]);
		
		int turnOnCnt = 1;
		for(int i=1; i<n-1; i++) {
			if(turnOnFirstLight[i-1] != toBeLight[i-1]) {
				turnOnFirstLight[i-1] = toggleLight(turnOnFirstLight[i-1]);
				turnOnFirstLight[i] = toggleLight(turnOnFirstLight[i]);
				turnOnFirstLight[i+1] = toggleLight(turnOnFirstLight[i+1]);
				turnOnCnt++;
			}
		}
		// 마지막 인덱스
		int lastIndex = n-1;
		if(turnOnFirstLight[lastIndex-1] != toBeLight[lastIndex-1]) {
			turnOnFirstLight[lastIndex-1] = toggleLight(turnOnFirstLight[lastIndex-1]);
			turnOnFirstLight[lastIndex] = toggleLight(turnOnFirstLight[lastIndex]);
			turnOnCnt++;
		}
		// 전구를 켜본 결과 마지막 전구가 만들고자 하는 상태가 아닌경우
		if(turnOnFirstLight[lastIndex] != toBeLight[lastIndex]) {
			turnOnCnt = -1;
		}
		
		

		// 첫번째 전구를 켜지 않는 경우
		int[] turnOffFirstLight = currentLight.clone();
		
		int turnOffCnt = 0;
		for(int i=1; i<n-1; i++) {
			if(turnOnFirstLight[i-1] != toBeLight[i-1]) {
				turnOffFirstLight[i-1] = toggleLight(turnOffFirstLight[i-1]);
				turnOffFirstLight[i] = toggleLight(turnOffFirstLight[i]);
				turnOffFirstLight[i+1] = toggleLight(turnOffFirstLight[i+1]);
				turnOffCnt++;
			}
		}
		// 마지막 인덱스
		lastIndex = n-1;
		if(turnOffFirstLight[lastIndex-1] != toBeLight[lastIndex-1]) {
			turnOffFirstLight[lastIndex-1] = toggleLight(turnOffFirstLight[lastIndex-1]);
			turnOffFirstLight[lastIndex] = toggleLight(turnOffFirstLight[lastIndex]);
			turnOffCnt++;
		}
		// 전구를 켜본 결과 마지막 전구가 만들고자 하는 상태가 아닌경우
		if(turnOffFirstLight[lastIndex] != toBeLight[lastIndex]) {
			turnOffCnt = -1;
		}
		
		
		int answer = 0;
		if(turnOnCnt != -1 && turnOffCnt != -1) {
			if(turnOnCnt < turnOffCnt) {
				answer = turnOnCnt;
			} else {
				answer = turnOffCnt;
			}
		} else if(turnOnCnt != -1){
			answer = turnOnCnt;
		} else if(turnOffCnt != -1) {
			answer = turnOffCnt;
		} else {
			answer = -1;
		}

		
		System.out.println("\n\n" + answer);
	}
	
	private static int toggleLight(int lightInfo) {
		return lightInfo = lightInfo == 0 ? 1 : 0;
	}

}
