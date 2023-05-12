package kakao;

public class 채용연계형_인턴쉽21_숫자_문자열과_영단어 {

	public static void main(String[] args) {
//		String s = "one4seveneight";
//		String s = "23four5six7";
//		String s = "2three45sixseven";
//		String s = "123";
		String s = "2three45sixfiveeighttwoone";
		
		System.out.println(solution(s));
	}

	public static int solution(String s) {
		String[] numberStrings = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
		for(int num=0; num<=9; num++)
			s = s.replaceAll(numberStrings[num], Integer.toString(num));
		
        int answer = Integer.parseInt(s);
        return answer;
    }
	
}