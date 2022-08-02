package kakao;

public class KakaoSummerIntern21_Exam01 {
	
	public static void main(String[] args) {
		
//		String s = "2three45sixseven";
		String s = "123";
		
		String answer = solution(s);
		System.out.println(answer);
		
	}
	
	public static String solution(String s) {
		String result = "";
		
		for(int i=0; i<s.length(); i++) {
			char target = s.charAt(i);
			
//			System.out.println(target);
			
			if (Character.isDigit(target) == false) {
				
				switch (target) {
				case 'z':
					target = '0';
					i += 3;
					
					break;
					
				case 'o':
					target = '1';
					i += 2;
					
					break;
					
				case 't':
					if (s.charAt(i+1) == 'w') {
						target = '2';				
						i += 2;
					} else {
						target = '3';	
						i += 4;
					}
					
					break;
					
				case 'f':
					if (s.charAt(i+1) == 'o') {
						target = '4';				
					} else {
						target = '5';
					}
					i += 3;
					
					break;
					
				case 's':
					if (s.charAt(i+1) == 'i') {
						target = '6';					
						i += 2;
					} else {
						target = '7';
						i += 4;
					}
					
					break;
					
				case 'e':
					target = '8';	
					i += 4;
					
					break;
					
				case 'n':
					target = '9';
					i += 3;
					
					break;
					
				default:
					break;
				}
			}
			
			result += target;
//			System.out.println("target---> " + target);
//			System.out.println("---> " + answer);
		}
		
        return result;
    }
	
}
