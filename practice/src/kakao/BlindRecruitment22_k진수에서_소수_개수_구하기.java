package kakao;

public class BlindRecruitment22_k진수에서_소수_개수_구하기 {

	public static void main(String[] args) {
//		int n = 437674; int k = 3;
//		int n = 110011; int k = 10;
		
		// 테스트케이스 1, 11번 런타임 에러 문제 중 하나
		// 소수판별 함수 자료형을 Long타입으로 해야 계산 오류가 발생하지 않는다
		int n = 797161; int k = 3; // 1111111111111(≓ 2의 40승)
		
		System.out.println("solution: " + solution(n, k));
	}
	
//	정확성  테스트
//	테스트 1 〉	통과 (48.05ms, 105MB)
//	테스트 2 〉	통과 (0.13ms, 72.3MB)
//	테스트 3 〉	통과 (0.15ms, 76.8MB)
//	테스트 4 〉	통과 (0.17ms, 76.6MB)
//	테스트 5 〉	통과 (0.14ms, 69.9MB)
//	테스트 6 〉	통과 (0.15ms, 73.4MB)
//	테스트 7 〉	통과 (0.13ms, 76.9MB)
//	테스트 8 〉	통과 (0.11ms, 77.8MB)
//	테스트 9 〉	통과 (0.15ms, 75.4MB)
//	테스트 10 〉	통과 (0.13ms, 67.4MB)
//	테스트 11 〉	통과 (0.16ms, 71MB)
//	테스트 12 〉	통과 (0.15ms, 77.7MB)
//	테스트 13 〉	통과 (0.19ms, 80.4MB)
//	테스트 14 〉	통과 (0.11ms, 77.7MB)
//	테스트 15 〉	통과 (0.11ms, 70MB)
//	테스트 16 〉	통과 (0.17ms, 77.7MB)
	
//	public static int solution(int n, int k) {
//		StringBuilder sb = new StringBuilder();
//		while(n > 0) {
//			sb.append(n%k);
//			n /= k;
//		}
//		sb.reverse();
//		sb.append(0);
//		String baseK = sb.toString();
//		sb.setLength(0);
//		
//		int answer = 0;
//		for(int i=0; i<baseK.length(); i++) {
//			if(baseK.charAt(i) != '0') {
//				sb.append(baseK.charAt(i));
//			} else {
//				if(sb.length() != 0) {
//					if(isPrimeNumber(Long.parseLong(sb.toString())))
//						answer++;
//					
//					sb.setLength(0);
//				}
//			}
//		}
//		
//        return answer;
//    }
	
	
	
//	정확성  테스트
//	테스트 1 〉	통과 (66.03ms, 94.9MB)
//	테스트 2 〉	통과 (0.25ms, 78.1MB)
//	테스트 3 〉	통과 (0.13ms, 72.7MB)
//	테스트 4 〉	통과 (0.38ms, 75.3MB)
//	테스트 5 〉	통과 (0.26ms, 73.8MB)
//	테스트 6 〉	통과 (0.24ms, 76.5MB)
//	테스트 7 〉	통과 (0.16ms, 76.4MB)
//	테스트 8 〉	통과 (0.22ms, 74.9MB)
//	테스트 9 〉	통과 (0.20ms, 70.7MB)
//	테스트 10 〉	통과 (0.17ms, 79.2MB)
//	테스트 11 〉	통과 (0.15ms, 73.2MB)
//	테스트 12 〉	통과 (0.13ms, 65.7MB)
//	테스트 13 〉	통과 (0.21ms, 88.5MB)
//	테스트 14 〉	통과 (0.22ms, 67.4MB)
//	테스트 15 〉	통과 (0.11ms, 78.1MB)
//	테스트 16 〉	통과 (0.13ms, 72.9MB)
	
	public static int solution(int n, int k) {
		StringBuilder sb = new StringBuilder();
		while(n > 0) {
			sb.append(n%k);
			n /= k;
		}
		String baseK = sb.reverse().toString();
		String[] numStrList = baseK.split("0");
		
		int answer = 0;
		for(String numStr: numStrList) {
			if(numStr.length() != 0 &&
				isPrimeNumber(Long.parseLong(numStr))) {
				answer++;
			}
		}
		
        return answer;
    }
	
	// 소수(Prime Number) 판별 함수
	private static boolean isPrimeNumber(Long num) {
		if(num < 2)
			return false;
		
		// 시간복잡도 제곱근(루트n)
		for(Long division=2L; division*division<=num; division++) {
			if(num % division == 0)
				return false;
		}
		
		return true;
	}
	
}
