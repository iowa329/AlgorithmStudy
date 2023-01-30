package kakao;

import java.util.*;

public class BlindRecruitment22_양궁대회 {

	public static void main(String[] args) {
//		int n = 5; int[] info = {2,1,1,1,0,0,0,0,0,0,0};
//		int n = 1; int[] info = {1,0,0,0,0,0,0,0,0,0,0};
//		int n = 9; int[] info = {0,0,1,2,0,1,1,1,1,1,1};
		int n = 10; int[] info = {0,0,0,0,0,0,0,0,3,4,3};
		
		System.out.println("solution\n" + Arrays.toString(solution(n, info)));
	}
	
	static ArrayList<int[]> scoreList = new ArrayList<>();
	
	static int[] targetListRyan;
	static int[] targetListApeach;
	
	static int maxScoreGap = 0;
	
	public static int[] solution(int n, int[] info) {
		targetListRyan = new int[11];
		targetListApeach = info;
		
		dfs(0, 0, n);
		
		int[] answer = {};
		if(maxScoreGap == 0)
			answer = new int[] {-1};
		else {
			// 더 낮은 점수를 많이 맞춘 targetScore목록을 답으로 반환
			Collections.sort(scoreList, new Comparator<int[]>() {
				@Override
				public int compare(int[] o1, int[] o2) {
					for(int i=10; i>=0; i--) {
						if(o1[i] != o2[i]) {
							// 내림차순 정렬
							return o2[i]-o1[i];
						}
					}
					
					return 0;
				}
			});
			
			answer = scoreList.get(0);
		}
        
        return answer;
    }
	
	private static void dfs(int depth, int start, int n) {
		if(depth == n) {
			int scoreRyan = 0;
			int scoreApeach = 0;
			
			// 과녁에 따른(해당 점수의 승자독식) 점수 계산
			for(int i=0; i<10; i++) {
				// 둘다 하나도 못 맞춘 경우 점수계산x
				if(targetListRyan[i] == 0 && targetListApeach[i] == 0)
					continue;
				
				if(targetListRyan[i] > targetListApeach[i]) {
					scoreRyan += 10-i;
				} else {
					scoreApeach+= 10-i;
				}
			}
			
			int gap = scoreRyan - scoreApeach;
			if(gap > maxScoreGap) {
				maxScoreGap = gap;
				
				scoreList.clear();
				scoreList.add(targetListRyan.clone());
			} else if(gap == maxScoreGap) {
				scoreList.add(targetListRyan.clone());
			}
			
			return;
		}
		
		for(int i=start; i<11; i++) {
			targetListRyan[i]++;
			dfs(depth+1, i, n);
			targetListRyan[i]--;
		}
	}
	
}