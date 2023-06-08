package baekjoon;

import java.io.*;
import java.util.*;

// 아기 상어
public class Baekjoon16236 {

	static class Position {
		int x, y;
		
		public Position(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public boolean equals(Position pos) {
			if(pos.x == this.x &&
				pos.y == this.y) {
				return true;
			} else {
				return false;
			}
		}
		
		@Override
		public String toString() {
			return String.format("(%d, %d)", this.x, this.y);
		}
	}
	
	static Position MAX_POS;
	static int MAX_DISTANCE;

	// BFS, 시뮬레이션
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 공간의 크기
		int n = Integer.parseInt(br.readLine());
		int[][] sea = new int[n][n];
		
		// 현재 상어 위치
		Position sharkPos = new Position(0, 0);
		// 상어 크기
		int sharkLevel = 2;
		// (성장하기 위한) 먹은 물고기 개수
		int sharkGauge = 0;
		// 공간정보 입력받기
		for(int i=0; i<n; i++) {
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int fish = Integer.parseInt(strTkr.nextToken());
				sea[i][j] = fish;
				if(fish == 9) {
					sharkPos.x = i;
					sharkPos.y = j;
					
					sea[i][j] = 0;
				}
			}
		}
		br.close();

		// 상하좌우
		int[] moveX = {-1, 1, 0, 0};
		int[] moveY = {0, 0, -1, 1};

		// BFS 탐색 동안 탐색한 거리를 저장할 배열 선언
		int[][] distance = new int[n][n];
		
		MAX_POS = new Position(n, n);
		MAX_DISTANCE = n * n + 1;
		
		// 엄마상어에게 도움을 요청하지 않고 사냥하는 시간
		int huntingTime = 0;
		// 물고기 사냥 시작
		while(true) {
			// 최소값 정의
			Position minPos = MAX_POS;
			int minDistance = MAX_DISTANCE;
			
			// -1로 초기화(미방문 처리 <- visited 역할 수행)
			for(int i=0; i<n; i++)
				for(int j=0; j<n; j++)
					distance[i][j] = -1;
			
			// 최소 상어 시작 위치 지정
			Queue<Position> que = new LinkedList<>();
			que.add(sharkPos);
			distance[sharkPos.x][sharkPos.y] = 0;
			while(!que.isEmpty()) {
				Position curPos = que.poll();
				
				// 상하좌우 물고기 탐색
				for(int direction=0; direction<4; direction++) {
					Position movedPos = new Position(curPos.x + moveX[direction], curPos.y + moveY[direction]);
					
					// 범위 밖이라면
					if(movedPos.x < 0 || n <= movedPos.x ||
						movedPos.y < 0 || n <= movedPos.y)
						continue;
					// 방문한 적이 있거나 현재 상어 크기보다 큰 물고기라면
					if(distance[movedPos.x][movedPos.y] != -1 ||
						sea[movedPos.x][movedPos.y] > sharkLevel)
						continue;
					
					// 거리 값 갱신
					distance[movedPos.x][movedPos.y] = distance[curPos.x][curPos.y] + 1;
					
					// 현재 바다 위치
					int movedSea = sea[movedPos.x][movedPos.y];
					// 먹을 수 있는 물고기가 있고
					if(0 < movedSea && movedSea < sharkLevel) {
						// 현재 탐색한 거리
						int movedDistance = distance[movedPos.x][movedPos.y];
						
						// 현재 거리가 최소 거리값 보다 작다면
						if(movedDistance < minDistance) {
							
							// 최소값 갱신
							minPos = movedPos;
							minDistance = movedDistance;
							
						} else
						// 현재 거리가 최소 거리값과 동일하다면
						if(movedDistance == minDistance) {
							
							// 1. 가장 위에 있는 물고기일 때
							if(movedPos.x < minPos.x) {
								// 최소 위치 값 갱신
								minPos = movedPos;
							} else
							// 1-1. 가장 위에 있는 물고기 위치가 같을 때
							if(movedPos.x == minPos.x) {
								// 2. 가장 왼쪽에 있는 물고기일 때
								if(movedPos.y < minPos.y) {
									minPos = movedPos;
								}
							}
						}
					}
					
					que.add(movedPos);
				}
			} // BFS 탐색 while문 종료
			
			// 최소 위치가 갱신된 적이 없다면 먹을 물고기가 없다는 소리이므로
			if(minPos.equals(MAX_POS))
				break; // 믈고기 사냥 while문 종료

			// BFS 탐색으로 얻은 최소값으로 상어 먹이 계산
			sharkPos = minPos; // 상어 이동
			huntingTime += minDistance; // 상어 이동시간 추가
			sharkGauge++; // 물고기 먹음
			sea[minPos.x][minPos.y] = 0; // 먹은 물고기 자리 사라짐
			
			// 먹은 물고기 수와 상어 레벨이 동일하면
			if(sharkGauge == sharkLevel) {
				sharkLevel++; // 레벨업
				sharkGauge = 0; // 게이지 0부터 다시 시작
			}
		}
		// 사냥 종료
		
		// 결과
		System.out.println(huntingTime);
	}
	
}