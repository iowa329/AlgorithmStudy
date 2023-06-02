package programmers;

import java.util.*;

public class MonthlyCodeChallenge_S03_n제곱_배열_자르기 {

	public static void main(String[] args) {
//		int n = 3; long left = 2; long right = 5;
		int n = 4; long left = 7; long right = 14;
		
		System.out.println(Arrays.toString(solution(n, left, right)));
	}
	
	public static int[] solution(int n, long left, long right) {
		int[] answer = new int[(int)(right-left+1)];
		for(long ans=left; ans<=right; ans++) {
			long i = ans / n;
			long j = ans % n;
			
			answer[(int)(ans-left)] = (int)(j > i ? j+1L : i+1L);
		}
		
        return answer;
    }
	
}
