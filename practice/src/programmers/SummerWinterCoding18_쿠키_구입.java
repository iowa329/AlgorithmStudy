package programmers;

public class SummerWinterCoding18_쿠키_구입 {

//	정확성  테스트
//	테스트 1 〉	통과 (0.02ms, 72.3MB)
//	테스트 2 〉	통과 (0.27ms, 75.7MB)
//	테스트 3 〉	통과 (0.39ms, 67.3MB)
//	테스트 4 〉	통과 (0.37ms, 77.1MB)
//	테스트 5 〉	통과 (0.56ms, 72.3MB)
//	테스트 6 〉	통과 (6.65ms, 70.7MB)
//	테스트 7 〉	통과 (5.60ms, 66.1MB)
//	테스트 8 〉	통과 (12.48ms, 83.5MB)
//	테스트 9 〉	통과 (17.32ms, 76.8MB)
//	테스트 10 〉	통과 (0.20ms, 73.9MB)
//	테스트 11 〉	통과 (0.16ms, 72.7MB)
//	테스트 12 〉	통과 (0.14ms, 79.5MB)
//	테스트 13 〉	통과 (0.19ms, 76MB)
//	테스트 14 〉	통과 (0.81ms, 84.4MB)
//	테스트 15 〉	통과 (1.39ms, 79.9MB)
//	테스트 16 〉	통과 (1.43ms, 72.8MB)
//	테스트 17 〉	통과 (0.81ms, 70MB)
//	테스트 18 〉	통과 (1.46ms, 79MB)
//	테스트 19 〉	통과 (1.48ms, 83.7MB)
//	테스트 20 〉	통과 (0.75ms, 73.3MB)
//	테스트 21 〉	통과 (1.52ms, 64.9MB)
//	테스트 22 〉	통과 (0.68ms, 84.8MB)
//	테스트 23 〉	통과 (13.18ms, 81.4MB)
//	테스트 24 〉	통과 (0.75ms, 77.3MB)
//	테스트 25 〉	통과 (1.13ms, 78MB)
//	테스트 26 〉	통과 (11.89ms, 67.7MB)
	
//	효율성  테스트
//	테스트 1 〉	통과 (12.79ms, 52.5MB)
//	테스트 2 〉	통과 (13.99ms, 53.3MB)
//	테스트 3 〉	통과 (13.52ms, 52.7MB)
//	테스트 4 〉	통과 (13.79ms, 52.2MB)
//	테스트 5 〉	통과 (13.95ms, 52.6MB)
//	테스트 6 〉	통과 (17.35ms, 52.9MB)
//	테스트 7 〉	통과 (13.45ms, 52.8MB)
//	테스트 8 〉	통과 (19.63ms, 52.4MB)
	
//	채점 결과
//	정확성: 66.7
//	효율성: 33.3
//	합계: 100.0 / 100.0
	
	public static void main(String[] args) {
		int[] cookie = {1,1,2,3};
//		int[] cookie = {1,2,4,5};
		
		System.out.print(solution(cookie));
	}
	
	public static int solution(int[] cookie) {
        int answer = 0;
        
        // 시간복잡도 n * n
        for(int i=0; i<cookie.length-1; i++) {
        	int indexLeft = i;
        	int indexRight = i+1;
        	
        	int sumLeft = cookie[indexLeft];
        	int sumRight= cookie[indexRight];
        	
        	while(true) {
        		try {
        			if(sumLeft < sumRight) {
            			sumLeft += cookie[--indexLeft];
            		} else if(sumLeft > sumRight) {
            			sumRight += cookie[++indexRight];
            		} else if(sumLeft == sumRight) {
            			answer = Math.max(answer, sumLeft);
            			
            			sumLeft += cookie[--indexLeft];
            			sumRight += cookie[++indexRight];
            		}
				} catch (Exception e) {
					// ArrayIndexOutOfBoundsException 처리
					break;
				}
        	}
        }
        
        return answer;
    }
	
}