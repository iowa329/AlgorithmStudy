package kakao;

import java.util.*;

public class BlindRecruitment19_실패율 {

	public static void main(String[] args) {
//		int n = 5; int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
//		int n = 4; int[] stages = {4,4,4,4,4};
		int n = 3; int[] stages = {2,2,2,2};
		
		System.out.println("\n" + Arrays.toString(solution(n, stages)));
	}

	static class Stage implements Comparable<Stage> {
		int num;
		double failRate;
		
		public Stage(int num, double failRate) {
			this.num = num;
			this.failRate = failRate;
		}
		
		@Override
		public int compareTo(Stage o) {
			// 실패율이 동일할 경우
			if(o.failRate == this.failRate)
				return this.num - o.num; // 번호 기준 오름차순 정렬
			
			// 실패율 기준 내림차순 정렬
			return Double.compare(o.failRate, this.failRate);
		}
		
		@Override
		public String toString() {
			return String.format("\n(%d, %f)", this.num, this.failRate);
		}
	}
	
    public static int[] solution(int N, int[] stages) {
    	int leftPlayer = stages.length;
    	
    	int[] onStage = new int[N];
    	for(int i=0; i<stages.length; i++) {
    		// 마지막 스테이지까지 클리어한 경우
    		if(stages[i] == N+1)
    			continue;
    		
    		onStage[stages[i]-1]++;
    	}
    	
    	// 실패율 계산
    	Stage[] failRates = new Stage[N];
    	for(int i=0; i<N; i++) {
    		System.out.println(i+1 + " " + leftPlayer);
    		
    		double failRate = (double)onStage[i] / leftPlayer;
    		failRate = Double.isNaN(failRate) ? 0.0 : failRate; // 0으로 나눠진경우 명시적 0처리
    		
    		failRates[i] = new Stage(i+1, failRate);
    		leftPlayer -= onStage[i];
    	}
    	
    	Arrays.sort(failRates);
    	
    	System.out.println(Arrays.toString(failRates));
    	
    	// 정답 출력
        int[] answer = new int[N];
        for(int i=0; i<N; i++)
        	answer[i] = failRates[i].num;
        return answer;
    }
	
}