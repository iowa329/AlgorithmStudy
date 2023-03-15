package baekjoon;

import java.io.*;
import java.util.*;

// 빙산
public class Baekjoon2573 {

	static class Iceberg {
		int x, y;
		
		public Iceberg(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int n, m;
	static int[][] iceberg;
	
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		n = Integer.parseInt(strTkr.nextToken());
		m = Integer.parseInt(strTkr.nextToken());

		iceberg = new int[n][m];
		for(int i=0; i<n; i++) {
			strTkr = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				iceberg[i][j] = Integer.parseInt(strTkr.nextToken());
			}
		}
		br.close();
		
		// 지구온난화 1년 단위 반복문
		int year = 0;
		loopYear:
		while(true) {
			year++;
			
			// 녹는 빙하 확인
			for(int x=0; x<n; x++) {
				for(int y=0; y<m; y++) {
					if(iceberg[x][y] == 0)
						continue;
					
					int cntMelt = 0;
					// 상하좌우 탐색
					int[] moveX = {-1, 1, 0, 0};
					int[] moveY = {0, 0, -1, 1};
					for(int direction=0; direction<4; direction++) {
						int movedX = x + moveX[direction];
						int movedY = y + moveY[direction];
						
						if(0 <= movedX && movedX < n && 
							0 <= movedY && movedY < m) {
							if(iceberg[movedX][movedY] == 0)
								cntMelt++;
						}
					}
					// 녹아서 0이 된 빙하가 이후 계산값에 영향을 주지 않기 위해 임시저장 값 -1 처리
					iceberg[x][y] = iceberg[x][y]-cntMelt <= 0 ? -1 : iceberg[x][y]-cntMelt;
				}
			}
			
			// 임시저장 값 0으로 초기화
			for(int x=0; x<n; x++)
				for(int y=0; y<m; y++)
					if(iceberg[x][y] == -1)
						iceberg[x][y] = 0;
			
			// 빙산 분리 여부 판단
			visited = new boolean[n][m];
			int cntIceberg = 0;
			for(int x=0; x<n; x++) {
				for(int y=0; y<m; y++) {
					
					// 빙하이고 탐색한 적이 없다면
					if(iceberg[x][y] != 0 &&
						visited[x][y] == false) {
						// 빙하 덩어리 탐색 시작
						cntIceberg++;
						
						// 탐색 횟수가 2 이상일 경우
						if(cntIceberg >= 2)
							break loopYear; // 빙하 녹이기 종료
						
						// BFS
						searchIceberg(new Iceberg(x, y));
					}
				}
			}
			
			// 만약 빙하가 하나인 체로 다 녹아 버렸다면 
			if(cntIceberg == 0) {
				year = 0; // 0을 출력
				break loopYear;
			}
		}
		
		// 결과
		System.out.println(year);
	}
	
	// BFS
	private static void searchIceberg(Iceberg startIce) {
		Queue<Iceberg> que = new LinkedList<>();
		que.add(startIce);
		visited[startIce.x][startIce.y] = true;
		
		while(!que.isEmpty()) {
			Iceberg curIce = que.poll();
			
			// 상하좌우 탐색
			int[] moveX = {-1, 1, 0, 0};
			int[] moveY = {0, 0, -1, 1};
			for(int direction=0; direction<4; direction++) {
				int movedX = curIce.x + moveX[direction];
				int movedY = curIce.y + moveY[direction];
				
				if(0 <= movedX && movedX < n && 
					0 <= movedY && movedY < m) {
					
					// 빙하이고 탐색한 적이 없다면
					if(iceberg[movedX][movedY] != 0 &&
						visited[movedX][movedY] == false) {
						
						que.add(new Iceberg(movedX, movedY));
						visited[movedX][movedY] = true;
					}
				}
			}
		}
	}
	
}