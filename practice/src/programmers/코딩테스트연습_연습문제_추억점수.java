package programmers;

import java.util.*;

public class 코딩테스트연습_연습문제_추억점수 {

	public static void main(String[] args) {
//		String[] name = {"may", "kein", "kain", "radi"}; int[] yearning = {5, 10, 1, 3};
//		String[][] photo = {{"may", "kein", "kain", "radi"},{"may", "kein", "brin", "deny"}, {"kon", "kain", "may", "coni"}};
//		String[] name = {"kali", "mari", "don"}; int[] yearning = {11, 1, 55};
//		String[][] photo = {{"kali", "mari", "don"}, {"pony", "tom", "teddy"}, {"con", "mona", "don"}};
		String[] name = {"may", "kein", "kain", "radi"}; int[] yearning = {5, 10, 1, 3};
		String[][] photo = {{"may"},{"kein", "deny", "may"}, {"kon", "coni"}};
		
		System.out.println(Arrays.toString(solution(name, yearning, photo)));
	}
	
	public static int[] solution(String[] name, int[] yearning, String[][] photo) {
		HashMap<String, Integer> hashMap = new HashMap<>();
		for(int i=0; i<name.length; i++)
			hashMap.put(name[i], yearning[i]);
		
		int[] answer = new int[photo.length];
		for(int i=0; i<photo.length; i++)
			for(int j=0; j<photo[i].length; j++)
				answer[i] += hashMap.getOrDefault(photo[i][j], 0);
		
        return answer;
    }
	
}