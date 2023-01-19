package programmers;

import java.util.*;

public class SummerWinterCoding18_숫자게임 {

//	정확성  테스트
//	테스트 1 〉	통과 (0.49ms, 76.5MB)
//	테스트 2 〉	통과 (0.63ms, 69.3MB)
//	테스트 3 〉	통과 (0.39ms, 64.6MB)
//	테스트 4 〉	통과 (0.50ms, 73.8MB)
//	테스트 5 〉	통과 (0.49ms, 80MB)
//	테스트 6 〉	통과 (0.52ms, 72.3MB)
//	테스트 7 〉	통과 (0.53ms, 71.7MB)
//	테스트 8 〉	통과 (0.36ms, 76.4MB)
//	테스트 9 〉	통과 (1.32ms, 81.6MB)
//	테스트 10 〉	통과 (0.67ms, 71.3MB)
//	테스트 11 〉	통과 (1.13ms, 77.9MB)
//	테스트 12 〉	통과 (0.57ms, 79.8MB)
//	테스트 13 〉	통과 (4.65ms, 84.2MB)
//	테스트 14 〉	통과 (4.82ms, 76.8MB)
//	테스트 15 〉	통과 (3.83ms, 87.1MB)
//	테스트 16 〉	통과 (4.88ms, 79.1MB)
//	테스트 17 〉	통과 (0.45ms, 72.3MB)
//	테스트 18 〉	통과 (0.51ms, 69.7MB)
	
//	효율성  테스트
//	테스트 1 〉	통과 (67.17ms, 65.8MB)
//	테스트 2 〉	통과 (57.22ms, 64.4MB)
//	테스트 3 〉	통과 (58.76ms, 66.3MB)
	
//	채점 결과
//	정확성: 85.7
//	효율성: 14.3
//	합계: 100.0 / 100.0
	
	public static void main(String[] args) {
		int[] A = {5, 1, 3, 7}; int[] B = {2, 2, 6, 8};
//		int[] A = {2, 2, 2, 2}; int[] B = {1, 1, 1, 1};
		
		System.out.print(solution(A, B));
	}
	
	public static int solution(int[] A, int[] B) {
		Arrays.sort(A);
		Arrays.sort(B);
		
		// B팀원들이 얻을 수 있는 최대 승점
        int answer = 0;
        
		int fightIndex = 0;
		for(int i=0; i<B.length; i++) {
			if(A[fightIndex] < B[i]) {
				answer++;
				fightIndex++;
			}
		}
		
        return answer;
    }
	
}