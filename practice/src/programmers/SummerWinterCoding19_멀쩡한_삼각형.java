package programmers;

import java.util.*;

public class SummerWinterCoding19_멀쩡한_삼각형 {
	
	public static void main(String[] args) {
		int w = 
				8;
		int h = 
				12;
						 
		long answer = solution(w,h);
		System.out.print(answer);
	}
	
	public static long solution(int w, int h) {
		long answer = 1;
		
		long totalSquare = (long) (w * h);
		if(w == h) {
			answer = totalSquare - w;
		} else {
			
		}
		
        return answer;
    }
	
}