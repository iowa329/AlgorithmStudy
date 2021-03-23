package kakao;

public class blind20_01_01 {
	
	public static void main(String[] args) {
		String[] list = {"aabbaccc", "ababcdcdababcdcd", "abcabcdede", "abcabcabcabcdededededede", "xababcdcdababcdcd", "ab", "aa", "a"};
		
		for(String s: list) {
			System.out.println(solution(s));
		}
	}
	
	static int solution(String s) {
		int minimumLength = s.length();
		for(int i=1; i<= s.length() / 2; i++) {
			int result = compress(s, i);
			if (result < minimumLength)
				minimumLength = result;
		}
		
		return minimumLength;
	}
	
	static int compress (String s, int n) {
		int result = 0;
		String prev = s.substring(0, 0+n);
		int count = 1;
		for(int i=n; i+n <= s.length(); i+=n) {
			String current = s.substring(i, i+n);
			if (current.equals(prev))
				count++;
			else {
				if (count >= 2) result += String.valueOf(count).length();
				result += prev.length();
				count = 1;
			}
			
			prev = current;
		}
		if (count >= 2) result += String.valueOf(count).length();
		result += prev.length();
		
		// n으로 나누어 떨어지지 않은 끝 부분 더해주기
		result += s.length() % n;
		
		
		return result;
	}
	
	
	
	// string으로 끊어서 붙여 계산하기(최종 값은 .length()로 개수 변환)
	// 위에 오직 개수만을 만드는 int형 result 보다 시간이 떨어짐 (평균 3.01ms 정도, 위 int형 result 코드는 평균 1.0ms)
//	static public int solution(String s) {
//        int minimumLength = s.length();
//		for(int i=1; i<= s.length() / 2; i++) {
//			int result = compress(s, i);
//			if (result < minimumLength)
//				minimumLength = result;
//		}
//		
//        return minimumLength;
//    }
//    
//	static int compress (String s, int n) {
//		StringBuilder result = new StringBuilder();
//		String prev = s.substring(0, 0+n);
//		int count = 1;
//		for(int i=n; i+n <= s.length(); i+=n) {
//			String current = s.substring(i, i+n);
//			if (current.equals(prev))
//				count++;
//			else {
//				if (count >= 2) result.append(count);
//				result.append(prev);
//				count = 1;
//			}
//			
//			prev = current;
//		}
//		if (count >= 2) result.append(count);
//		result.append(prev);
//		
//		// n으로 나누어 떨어지지 않은 끝 부분 더해주기
//		int tail = s.length() % n;
//		result.append(s.substring(s.length() - tail));
//		
//		
//		return result.toString().length();
//	}
	
}
