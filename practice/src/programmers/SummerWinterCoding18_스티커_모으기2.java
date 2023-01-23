package programmers;

public class SummerWinterCoding18_스티커_모으기2 {

	public static void main(String[] args) {
		int sticker[] = {14, 6, 5, 11, 3, 9, 2, 10};
//		int sticker[] = {1, 3, 2, 5, 4};
		
		System.out.print(solution(sticker));
	}
	
	public static int solution(int sticker[]) {
		int length = sticker.length-1;
		
		// 스티커가 한 개일 경우 바로 반환
		if(length == 1)
			return sticker[0];
		
        int[] dp = new int[sticker.length];
        
        // 첫번째 스티커를 뗐을 때
        dp[0] = sticker[0];
        dp[1] = dp[0];
        
        // 마지막 인덱스(length-1)는 뗄 수 없으므로 범위에서 제외
        for(int i=2; i<length-1; i++) {
        	dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
        }
        int case0 = dp[length-2];
        
        // 첫번째 스티커를 떼지 않았을 때
        dp[0] = 0;
        dp[1] = sticker[1];
        for(int i=2; i<length; i++) {
        	dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
        }
        int case1 = dp[length-1];

        int answer = Math.max(case0, case1);
        return answer;
    }
}
