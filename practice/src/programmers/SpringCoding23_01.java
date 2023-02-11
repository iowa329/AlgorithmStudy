package programmers;

public class SpringCoding23_01 {

	public static void main(String[] args) {
//		int[][] lotteries = {{100, 100, 500}, {1000, 1000, 100}};
//		int[][] lotteries = {{10, 19, 800}, {20, 39, 200}, {100, 199, 500}};
		int[][] lotteries = {{50, 1, 50}, {100, 199, 100}, {1, 1, 500}};
		
		System.out.print(solution(lotteries));
	}

	public static int solution(int[][] lotteries) {
		int toBuyLotteryNum = -1;
		
		double maxPercent = 0;
		int maxMoney = 0;
		
		// 당첨가능한 복권 탐색
		for(int i=0; i<lotteries.length; i++) {
			double curPercent = (double)lotteries[i][0] * 100L / (double)(lotteries[i][1] + 1);
			if(curPercent > 100) // 100%가 넘어갈 경우
				curPercent = 100; // 100으로 처리
			
			int curMoney = lotteries[i][2];
			
			// 당첨확률이 높다면
			if(curPercent > maxPercent) {
				toBuyLotteryNum = i+1;
				maxMoney = curMoney;
				maxPercent = curPercent;
			} else 
			// 당첨확률이 같다면 
			if(curPercent == maxPercent) {
				// 당첨금액이 높을때
				if(curMoney > maxMoney) {
					// 값 갱신
					toBuyLotteryNum = i+1;
					maxMoney = curMoney;
				}
			}
		}
		
        return toBuyLotteryNum;
    }
	
}