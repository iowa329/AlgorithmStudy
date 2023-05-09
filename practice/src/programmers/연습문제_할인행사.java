package programmers;

import java.util.*;

public class 연습문제_할인행사 {

	public static void main(String[] args) {
//		String[] want = {"banana", "apple", "rice", "pork", "pot"};
//		int[] number = {3, 2, 2, 2, 1};
//		String[] discount = {"chicken", "apple", "apple", "banana", "rice",
//							"apple", "pork", "banana", "pork", "rice", 
//							"pot", "banana", "apple", "banana"};
		
		String[] want = {"apple"};
		int[] number = {10};
		String[] discount = {"banana", "banana", "banana", "banana", "banana",
							"banana", "banana", "banana", "banana", "banana"};
		
		System.out.println(solution(want, number, discount));
	}
	
	public static int solution(String[] want, int[] number, String[] discount) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        // 최초 열흘치 할인정보 계산
        for(int i=0; i<10; i++)
        	hashMap.put(discount[i], hashMap.getOrDefault(discount[i], 0) + 1);
        
        int answer = 0;
        
        // 최초 열흘 할인정보 구매 가능 여부 파악
        boolean isPossible = true;
        for(int i=0; i<want.length; i++) {
        	if(hashMap.getOrDefault(want[i], 0) != number[i]) {
        		isPossible = false;
        		break;
        	}
        }
        if(isPossible)
        	answer++;
        
        // 하루씩 옮겨가며 할인 항목 변경 후 조건검사
        // 슬라이딩 윈도우(Sliding Window) 알고리즘? - (투 포인트의 일종)
        for(int i=10; i<discount.length; i++) {
        	hashMap.put(discount[i], hashMap.getOrDefault(discount[i], 0) + 1);
        	hashMap.put(discount[i-10], hashMap.get(discount[i-10]) - 1);
        	
        	// 열흘간의 구매가 가능한지 구매희망 항목과 비교조건 검사
        	isPossible = true;
        	for(int j=0; j<want.length; j++) {
            	if(hashMap.getOrDefault(want[j], 0) != number[j]) {
            		isPossible = false;
            		break;
            	}
            }
        	if(isPossible)
            	answer++;
        }
        
        return answer;
    }
	
}