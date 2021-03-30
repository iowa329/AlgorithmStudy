package line;

import java.util.regex.Pattern;

public class liner21_exam_02 {
	
	public static void main(String[] args) {
		String pattern = "^[0-9a-zA-Z]*$"; //숫자만
        String val = "123456789asDd@"; //대상문자열
    
        boolean regex = Pattern.matcher(pattern, val);
        System.out.println(regex);
	}

	static String solution(String s) {
		return "";
	}
	
	static boolean rule1(String s) {
		if (s.length() >= 8 && s.length() <=15) {
			return true;
		} else {
			return false;
		}
	}
	
	static boolean rule2(String s) {
		boolean result = true;
		
		for(char c: s.toCharArray()) {
			int asciiNum = (int)c;
			if (!rule2_1(asciiNum))
				if (!rule2_2(asciiNum))
					if (!rule2_3(asciiNum))
						if (!rule2_4(asciiNum)) {
							result = false;
							break;
						}
		}
		
		return result;
	}
	
	static boolean rule2_1(int ascii) {
		if (65 >= ascii && ascii <= 90) {
			return true;
		} else {
			return false;
		}
	}
	static boolean rule2_2(int ascii) {
		if (97 >= ascii && ascii <= 122) {
			return true;
		} else {
			return false;
		}
	}
	static boolean rule2_3(int ascii) {
		if (0 >= ascii && ascii <= 9) {
			return true;
		} else {
			return false;
		}
	}
	static boolean rule2_4(int ascii) {
		boolean result = false;
		
		String checkList = "~!@#$%^&*";
		for(char check: checkList.toCharArray()) {
			if (ascii == (int)check) {
				result = true;
				break;
			}
		}
		
		return result;
	}
	
	static boolean rule3(String s) {
		int checkList = 0;
		
		for(int i=0; i<s.length(); i++) {
			boolean loop = true;
			while(true) {
				if (rule2_1((int)s.charAt(i))) break;
				if (rule2_1((int)s.charAt(i))) break;
				if (rule2_1((int)s.charAt(i))) break;
				if (rule2_1((int)s.charAt(i))) break;
				
				loop = false;
			}
			
			if (loop == true) {
				checkList += 1;
				if (checkList >= 3) {
					break;
				}
			}
		}
		
		return (checkList >= 3) ? true : false;
	}
	
	static boolean rule5(String s) {
		int count = 0;
		for(int i=0; i<s.length(); i++) {
			for(int j=0; j<s.length(); j++) {
				if (s.charAt(i) == s.charAt(j)) {
					count++;
					if (count >= 5) {
						i = s.length();
						break;
					}
				}
			}
			
		}
		
		return (count >= 5) ? false : true;
	}
}
