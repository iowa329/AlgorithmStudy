package kakao;

public class blind20_01_02 {

	public static void main(String[] args) {
		String[] s = { "(()())()", ")(", "()", "()))((()", "()(())()", ")))(()(())))((((" };
		
		for(String searchString: s) {
			boolean isBalanced = balanced(searchString);
			System.out.printf("%s", searchString);
			
			if (isBalanced == true) System.out.println(" ==> " + solution(searchString));
		}
		
		
	}
	
	static String solution(String w) {
		// 1
		if (w.equals("")) return w;
		
		// 2
		int count = 0;
		for(int i=0; i<w.length(); i++) {
			count += (w.charAt(i) == '(') ? 1 : -1;
			if (count == 0) {
				count = i;
				break;
			}
		}
		
		String u = w.substring(0, count+1);
		String v = w.substring(count+1);
		
		// 3
		if (wellFormed(u)) {
			// 3-1
			return u += solution(v);
		} else {
			// 4
			StringBuilder str = new StringBuilder();
			// 4-1
			str.append('(');
			// 4-2
			str.append(solution(v));
			// 4-3
			str.append(')');
			// 4-4
			str.append(u.substring(1, u.length()-1).replace('(', '_').replace(')', '(').replace('_', ')'));
			// 4-5
			return str.toString();
		}
		
		
	}
	
	// 균형잡힌 괄호 문자열 유무 판단
	static boolean balanced(String s) {
		int count = 0;
		for(char c: s.toCharArray()) {
			count += (c == '(') ? 1 : -1;  
		}
		
		return count == 0;
	}
	
	// 올바른 괄호 문자열 판단
	static boolean wellFormed(String s) {
		int count = 0;
		for(char c: s.toCharArray()) {
			count += (c == '(') ? 1 : -1;
			if (count < 0) return false;
		}
		
		return true;
	}
	
}
