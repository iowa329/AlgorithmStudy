package kakao;

import java.util.*;

public class BlindRecruitment18_비밀지도 {

	public static void main(String[] args) {
//		int n=5; int[] arr1 = {9, 20, 28, 18, 11}; int[] arr2 = {30, 1, 21, 17, 28};
		int n=6; int[] arr1 = {46, 33, 33 ,22, 31, 50}; int[] arr2 = {27 ,56, 19, 14, 14, 10};
		
		System.out.println(Arrays.toString(solution(n, arr1, arr2)));
	}
	
	public static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] arr1Str = new String[n];
		String[] arr2Str = new String[n];
		for(int i=0; i<n; i++) {
			arr1Str[i] = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr1[i])));
			arr2Str[i] = String.format("%0"+n+"d", Long.parseLong(Integer.toBinaryString(arr2[i])));
		}
		
		String[] answer = new String[n];
		for(int i=0; i<n; i++) {
			StringBuilder sb = new StringBuilder();
			for(int j=0; j<n; j++) {
				if(arr1Str[i].charAt(j) == '1' ||
					arr2Str[i].charAt(j) == '1') {
					sb.append("#");
				} else {
					sb.append(" ");
				}
			}
			answer[i] = sb.toString();
		}
		
        return answer;
    }
	
}
