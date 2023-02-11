package programmers;

import java.util.*;

public class SpringCoding23_03 {

	public static void main(String[] args) {
//		int[][] queries = {{2, 0}, {3, 1}};
//		int[][] queries = {{1, 4, 3}, {1, 2, 2}};
		int[][] queries = {{0, 2, 0, 1}, {0, 1, 0, 1}};
		
		System.out.print(Arrays.toString(solution(queries)));
	}
	
	public static int[] solution(int[][] queries) {
		int[] answer = new int[queries.length];
		
		for(int i=0; i<queries.length; i++) {
			int left = 0;
			int right = queries[i].length - 1;

			int totalCnt = 0;
			while(left < right) {
				int toMakePalindromeCnt = Math.abs(queries[i][left] - queries[i][right]);
				totalCnt += toMakePalindromeCnt;
				
				left++;
				right--;
			}
			
			answer[i] = totalCnt % 2 == 1 ? 1 : 0;
		}
		
        return answer;
    }
	
}
