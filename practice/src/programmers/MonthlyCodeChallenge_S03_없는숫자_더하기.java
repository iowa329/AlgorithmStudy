package programmers;

public class MonthlyCodeChallenge_S03_없는숫자_더하기 {

	public static void main(String[] args) {
		int[] numbers = {1,2,3,4,6,7,8,0};
//		int[] numbers = {5,8,4,0,6,7,9};
		
		System.out.println(solution(numbers));
	}
	
	public static int solution(int[] numbers) {
		boolean[] isContains = new boolean[10];
		for(int number: numbers)
			isContains[number] = true;
		
		int answer = 0;
		for(int i=0; i<10; i++)
			if(isContains[i] == false)
				answer += i;
		
        return answer;
    }
	
}