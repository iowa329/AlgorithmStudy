package programmers;

import java.util.*;

public class MonthlyCodeChallenge_S02_괄호_회전하기 {

	public static void main(String[] args) {
//		String s = "[](){}";
		String s = "{([";
		
		System.out.println(solution(s));
	}
	
	public static int solution(String s) {
		int cnt = 0;
		for(int i=0; i<s.length(); i++) {
			String str = s.substring(i) + s.substring(0, i);
			if(isCorrectBracket(str))
				cnt++;
		}
		
        return cnt;
    }
	
	private static boolean isCorrectBracket(String s) {
		Stack<Character> stack = new Stack<>();
		
		for(int i=0; i<s.length(); i++) {
			char curBracket = s.charAt(i);
			
			if(curBracket == '(' ||
				curBracket == '[' ||
				curBracket == '{') {
				stack.add(curBracket);
			} else {
				if(!stack.isEmpty()) {
					char beforeBracket = stack.pop();
					
					switch (curBracket) {
					case ')':
						if(beforeBracket != '(')
						return false;
						break;
					case ']':
						if(beforeBracket != '[')
						return false;
						break;
					case '}':
						if(beforeBracket != '{')
						return false;
						break;
					}
				} else {
					return false;
				}				
			}
		}
			
		return stack.isEmpty() ? true : false;
	}
	
}