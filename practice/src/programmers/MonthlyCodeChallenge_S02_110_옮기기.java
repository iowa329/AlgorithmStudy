package programmers;

import java.util.*;

public class MonthlyCodeChallenge_S02_110_옮기기 {

	public static void main(String[] args) {
		String[] s = {"1110","100111100","0111111010"};
		
		System.out.print(Arrays.toString((solution(s))));
	}

//	정확성  테스트
//	테스트 1 〉	통과 (232.31ms, 106MB)
//	테스트 2 〉	통과 (575.10ms, 117MB)
//	테스트 3 〉	통과 (1468.38ms, 119MB)
//	테스트 4 〉	통과 (7515.58ms, 105MB)
//	테스트 5 〉	통과 (235.09ms, 107MB)
//	테스트 6 〉	통과 (478.13ms, 116MB)
//	테스트 7 〉	통과 (1504.29ms, 99.8MB)
//	테스트 8 〉	통과 (1421.52ms, 95.5MB)
//	테스트 9 〉	통과 (132.78ms, 154MB)
//	테스트 10 〉	통과 (158.42ms, 146MB)
//	테스트 11 〉	통과 (229.77ms, 149MB)
//	테스트 12 〉	통과 (143.91ms, 133MB)
//	테스트 13 〉	통과 (202.27ms, 151MB)
//	테스트 14 〉	통과 (159.55ms, 137MB)
//	테스트 15 〉	통과 (172.07ms, 140MB)
//	테스트 16 〉	통과 (235.89ms, 149MB)
//	테스트 17 〉	통과 (219.94ms, 125MB)
//	테스트 18 〉	통과 (786.19ms, 96.5MB)
//	테스트 19 〉	통과 (3833.45ms, 126MB)
//	테스트 20 〉	통과 (865.28ms, 109MB)
//	테스트 21 〉	통과 (3686.62ms, 97.2MB)
	
	public static String[] solution(String[] s) {
		String[] answer = new String[s.length];
		
		for(int str=0; str<s.length; str++) {
			Stack<Character> stack = new Stack<>();
			int cnt110 = 0;
			for(int i=0; i<s[str].length(); i++) {
				stack.push(s[str].charAt(i));
				
				if(stack.size() >= 3) {
					char char3 = stack.pop();
					char char2 = stack.pop();
					char char1 = stack.pop();
					
					// 110 패턴 카운트 후 제거
					if(char1 == '1' && char2 == '1' && char3 == '0') {
						cnt110++;
					} else {
						// 아니면 다시 삽입연산 수행
						stack.push(char1);
						stack.push(char2);
						stack.push(char3);
					}
				}
			}
			
			StringBuilder sb = new StringBuilder();
			
			// 110을 제거하고 남은 문자열 중 가장 뒤에 있는 0까지 탐색
			int curStackSize = stack.size();
			for(int i=0 ; i<curStackSize; i++) {
				if(stack.peek() == '0') {
					break;
				} else {
					// 가장 뒤에 있는 0 뒤에 있는 모든 문자열은 정답문자열에 뒤로 순차삽입
					sb.insert(0, stack.pop());
				}
			}
			
			// 발견된 110 패턴 개수만큼 정답배열 앞에 삽입
			for(int i=0; i<cnt110; i++)
				sb.insert(0, "110");
			
			// 가장 뒤에 있던 0 앞에 남은문자열 정답배열에 삽입
			curStackSize = stack.size();
			for(int i=0 ; i<curStackSize; i++)
				sb.insert(0, stack.pop());
			
			// 정답 입력
			answer[str] = sb.toString();
		}
		
        return answer;
    }
	
}