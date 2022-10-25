package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon9935 {

	public static void main(String[] args) throws IOException {
		// 문자열 및 폭발 문자열 정보 입력받기
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String bomb = br.readLine();
		br.close();
		
		// stack(replace 방식은 메모리 초과)
		Stack<Character> stack = new Stack<>();
		int lengthBomb = bomb.length();
		for(int i=0; i<str.length(); i++) {
			stack.push(str.charAt(i));
			
			if(stack.size() >= lengthBomb) {
				int startRange = stack.size() - lengthBomb; // stack 맨 뒤에서 폭발 문자열만큼의 검사범위 지정
				boolean isCorrectToRemove = true;
				
				// 폭발 문자열 일치여부 확인
				for(int searchIndex=0; searchIndex < lengthBomb; searchIndex++) {
					if(stack.get(startRange + searchIndex) != bomb.charAt(searchIndex)) { // 폭발 문자열과 일치하지 않을 경우
						isCorrectToRemove = false;
						break; // 반복문 종료
					}
				}
				
				// 해당 범위검사 결과 폭발문자열과 일치했을 경우 해당 범위 문자열 삭제(pop)
				if(isCorrectToRemove) for(int removeIndex=0; removeIndex < lengthBomb; removeIndex++) stack.pop();
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(char stackChar: stack) sb.append(stackChar);
		
		// 결과
		System.out.println(stack.isEmpty() ? "FRULA" : sb.toString());
	}

}