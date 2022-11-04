package kakao;

import java.util.*;

public class BlindRecruitment22_SecondHalf_1st_03 {

	static int[] result = new int[4];
	static int[] discount = {10, 20, 30, 40};
	
	public static void main(String[] args) {
		int[][] users =
				{{40, 10000}, {25, 10000}};
//				{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 92001}, {32, 6900}};
		
		int[] emoticons =
				{7000, 9000};
//				{1300, 1500, 1600, 4900};
		
//		int[] answer = solution(users, emoticons);
//		System.out.print(Arrays.toString(answer));
		
		combinationDiscount(0, 0);
	}

	public static int[] solution(int[][] users, int[] emoticons) {
		// 최대 이모티콘 플러스 서비스 가입자수와 이모티콘 매출액
		int[] answer = {};
//		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
//			@Override
//			public int compare(int[] o1, int[] o2) {
//				// 이모티콘 플러스 가입자가 동일할 경우, 이모티콘 매출액 기준으로 내림차순 정렬
//				if(o1[0] == o2[0]) {
//					return o2[1] - o1[1];
//				}
//				// 이모티콘 플러스 가입자 내림차순 정렬
//				return o2[0] - o1[0];
//			}
//		});
		
		int[] highSales = {0, 0, 0, 0};
		int[] highSaleByDiscount = {0, 0}; // 0: 이모티콘 플러스 가입자 수, 1: 이모티콘 매출액
		
		// 할인률 당 하나의 이모티콘이 갖는 매출액(user기준에 따른 총합)
		
		
		int[] discounts = {10, 20, 30, 40};
		for(int d=0; d<discounts.length; d++) {
			for(int u=0; u<users.length; u++) {
				int[] costSum = new int[users.length];
				
				for(int e=0; e<emoticons.length; e++) {
					int discount = discounts[d];
					
					// 해당 유저가 할인률 기준을 넘는다면
					if(users[u][0] >= discount) {
						int cost = emoticons[e];
						cost -= emoticons[e] * discount * (1/100); 
//						costSum += cost;
					}
				}
				
				// 이모티콘 구매 총합이 총액 기준을 넘는다면
//				if(costSum > users[u][1]) {
//					
//				}
			}
		}
		
        return answer;
	}
	
	// 할인률(10, 20, 30, 40) 경우의 수
	public static void combinationDiscount(int cnt, int discountIndex) {
		
		if(cnt == 4) {
			System.out.println(Arrays.toString(result));
			
			return;
		}
		
		for(int i=discountIndex; i<4; i++) {
			result[cnt] = discount[i];
			combinationDiscount(cnt+1, i);
		}
	}
	
}
