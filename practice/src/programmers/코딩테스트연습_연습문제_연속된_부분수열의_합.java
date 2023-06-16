package programmers;

import java.util.*;

public class 코딩테스트연습_연습문제_연속된_부분수열의_합 {

	public static void main(String[] args) {
		int[] sequence = {1, 2, 3, 4, 5}; int k = 7;
//		int[] sequence = {1, 1, 1, 2, 3, 4, 5}; int k = 5;
//		int[] sequence = {2, 2, 2, 2, 2}; int k = 6;
		
		System.out.println(Arrays.toString(solution(sequence, k)));
	}
	
	public static int[] solution(int[] sequence, int k) {
		int left = 0;
		int right = 0;
		
		int minRange = 1_000_000+1;
		int answerLeft = 0;
		int answerRight = 0;
		
		int sum = sequence[0];
		while(right <= sequence.length-1) {
			System.out.println(String.format("left: %d, right: %d, sum: %d", left, right, sum));
			
			if(sum < k) {
				right++;
				
				if(right >= sequence.length)
					break;
				
				sum += sequence[right];
			} else if(sum == k) {
				int curRange = right - left + 1;
				if(curRange < minRange) {
					minRange = curRange;
					answerLeft = left;
					answerRight = right;
				}
				
				right++;
				
				if(right >= sequence.length)
					break;
				
				sum += sequence[right];
			} else if(sum > k) {
				left++;
				
				if(left >= sequence.length)
					break;
				
				sum -= sequence[left-1];
			}
			
			
		}
		
        int[] answer = { answerLeft, answerRight };
        return answer;
    }
	
}
