package programmers;

import java.util.*;

public class SummerWinterCoding18_배달 {

	public static void main(String[] args) {
		int N = 
//				5;
				6;
		int[][] road = 
//				{{1,2,1},{2,3,3},{5,2,2},{1,4,2},{5,3,1},{5,4,2}};
				{{1,2,1},{1,3,2},{2,3,2},{3,4,3},{3,5,2},{3,5,3},{5,6,1}};
		int K = 
//				3;
				4;
		
		System.out.print(solution(N, road, K));
	}
	
	static final int MAX_ROAD_LENGTH = 500000 + 1; // K의 최대값은 500000
	
	public static int solution(int N, int[][] road, int K) {
		int[][] villages = new int[N+1][N+1]; // 도로 번호는 1부터 시작하므로
		// 마을도로 정보 초기화
		for(int[] village: villages)
			Arrays.fill(village, MAX_ROAD_LENGTH);
		
		// 마을도로 정보 입력받기
		for(int i=0; i<road.length; i++) {
			int a = road[i][0];
			int b = road[i][1];
			int c = road[i][2];
			
			villages[a][b] = Math.min(c, villages[a][b]);
			villages[b][a] = Math.min(c, villages[b][a]);
		}
		
		// 플로이드–워셜 알고리즘
		// i->j로 가는 최단경로 값 갱신
		for(int via=1; via<=N; via++){
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					villages[i][j] = Math.min(villages[i][j], villages[i][via] + villages[via][j]);
					
					if(i == j)
						villages[i][j] = 0;
				}
			}
		}
		
		int answer = 0;
		// 1번 마을에서 K시간 이하로 배달 가능한 마을의 개수
		for(int i=1; i<=N; i++) {
			if(villages[1][i] <= K)
				answer++;
		}
		
        return answer;
    }
	
}