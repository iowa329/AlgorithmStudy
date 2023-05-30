package programmers;

import java.util.*;

public class 코딩테스트연습_완전탐색_모의고사 {

	public static void main(String[] args) {
//		int[] answers = {1,2,3,4,5};
		int[] answers = {1,3,2,4,2};
		
		System.out.println(Arrays.toString(solution(answers)));
	}
	
	public static int[] solution(int[] answers) {
		int[] pattern1 = {1, 2, 3, 4, 5};
		int[] pattern2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] pattern3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		int[] scores = new int[3];
		int maxScore = 0;
		for(int i = 0; i<answers.length; i++) {
			if(answers[i] == pattern1[i % pattern1.length])
				scores[0]++;
			if(answers[i] == pattern2[i % pattern2.length])
				scores[1]++;
			if(answers[i] == pattern3[i % pattern3.length])
				scores[2]++;
			
			maxScore = Math.max(maxScore, scores[0]);
			maxScore = Math.max(maxScore, scores[1]);
			maxScore = Math.max(maxScore, scores[2]);
		}
		
        ArrayList<Integer> answer = new ArrayList<>();
        for(int i=0; i<scores.length; i++)
        	if(scores[i] == maxScore)
        		answer.add(i+1);
        Collections.sort(answer);
        
        int[] result = new int[answer.size()];
        for(int i=0; i<answer.size(); i++)
        	result[i] = answer.get(i);
        
        return result;
    }
	
}
