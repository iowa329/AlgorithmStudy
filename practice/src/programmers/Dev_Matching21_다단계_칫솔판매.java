package programmers;

import java.util.*;

public class Dev_Matching21_다단계_칫솔판매 {

	public static void main(String[] args) {
//		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
//		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
//		String[] seller = {"young", "john", "tod", "emily", "mary"};
//		int[] amout = {12, 4, 2, 5, 10};
		
		String[] enroll = {"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"};
		String[] referral = {"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"};
		String[] seller = {"sam", "emily", "jaimie", "edward"};
		int[] amout = {2, 3, 5, 4};
		
		System.out.println(Arrays.toString(solution(enroll, referral, seller, amout)));
	}
	
	static int Cost_Toothbush = 100;
	static int[] profitsList;
	static HashMap<String, Integer> enrollIndexList = new HashMap<>();
	
	public static int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
		profitsList = new int[enroll.length];
		
		// 조직원 이름별 index 위치처리
		for(int i=0; i<enroll.length; i++) {
			enrollIndexList.put(enroll[i], i);
		}
		
		for(int sellerIndex=0; sellerIndex<seller.length; sellerIndex++) {
			int enrollIndex = enrollIndexList.get(seller[sellerIndex]);
			int curEnrollProfit = amount[sellerIndex] * Cost_Toothbush;
			
			calculateProfit(curEnrollProfit, enrollIndex, referral);
		}
		
        return profitsList;
    }
	
	private static void calculateProfit(int curEnrollProfit, int enrollIndex, String[] referral) {
		int toGiveProfit = curEnrollProfit * 10 / 100;
		profitsList[enrollIndex] += curEnrollProfit - toGiveProfit;
		
		String toGiveName = referral[enrollIndex];
		
		// 재귀 (종료)조건 검사
		if(toGiveProfit < 1 || toGiveName.equals("-"))
			return;
		
		int toGiveEnrollIndex = enrollIndexList.get(toGiveName);
		calculateProfit(toGiveProfit, toGiveEnrollIndex, referral);
	}
}