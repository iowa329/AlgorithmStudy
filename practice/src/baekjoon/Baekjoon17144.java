package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon17144 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		
		// 방 크기와 소요시간 입력받기
		int r = Integer.parseInt(strTkr.nextToken());
		int c = Integer.parseInt(strTkr.nextToken());
		int t = Integer.parseInt(strTkr.nextToken());
		
		int airCleanerPosX = 0;
		
		// 미세먼지 정보 입력받기
		int[][] room = new int[r][c];
		for(int i=0; i<r; i++) {
			strTkr = new StringTokenizer(br.readLine());
			for(int j=0; j<c; j++) {
				int roomInfo = Integer.parseInt(strTkr.nextToken());
				room[i][j] = roomInfo;
				
				// 공기청정기 위치 파악(두칸 중 아래쪽)
				if(roomInfo == -1)
					airCleanerPosX = i;
			}
		}
		br.close();
		
		int time=1;
		while(time <= t) {			
			// 1. 미세먼지 확산
			
			// 퍼질 미세먼지 정보값 저장 배열
			int[][] tmpRoom = new int[r][c];
			
			// 미세먼지 퍼지는 정보 계산(tmpRoom)
			for(int x=0; x<r; x++) {
				for(int y=0; y<c; y++) {
					int spreadDust = room[x][y] / 5;
					int spreadCnt = 0;
					
					// 상하좌우 탐색
					int[] moveX = {-1, 1, 0, 0};
					int[] moveY = {0, 0, -1, 1};
					for(int i=0; i<4; i++) {
						int movedX = x + moveX[i];
						int movedY = y + moveY[i];
						
						// 칸이 없거나, 공기청정기가 있는 경우
						if(movedX < 0 || r <= movedX || 
							movedY < 0 || c <= movedY ||
							room[movedX][movedY] == -1) {
							continue;
						} else {
							// 미세먼지 퍼짐
							tmpRoom[movedX][movedY] += spreadDust; // 퍼지고
							spreadCnt++; // 퍼진만큼 카운트
						}
					}
					
					room[x][y] -= spreadDust * spreadCnt; // 퍼진만큼 없어진다
				}
			}
			
			// 퍼질 미세먼지 정보 반영 tmpRoom -> room
			for(int x=0; x<r; x++)
				for(int y=0; y<c; y++)
					room[x][y] += tmpRoom[x][y];
			
			// 2. 공기청정기 작동
			
			// a. 아래쪽 시계 방향
			int x = airCleanerPosX;
			int y = 0;

			// 시계방향 계산 탐색방향 - 하우상좌 순
			int[] clockDirectionX = {1, 0, -1, 0};
			int[] clockDirectionY = {0, 1, 0, -1};
			for(int i=0; i<4; i++) {
				while(true) {
					int movedX = x + clockDirectionX[i];
					int movedY = y + clockDirectionY[i];
					
					// 시계방향 바람 밖으로 벗어난 경우
					if(movedX < airCleanerPosX || r <= movedX || 
						movedY < 0 || c <= movedY) {
						break;
					} else {
						// 바람으로 이동되는 경우
						room[x][y] = room[movedX][movedY];
						
						x = movedX;
						y = movedY;
					}
				}
			}
			// 회전 후 작업
			room[airCleanerPosX][0] = -1; // 공기청정기 위치 표시 
			room[airCleanerPosX][1] = 0; // 정화된 바람이 나온 곳 표시
			
			// b. 위쪽 반시계 방향
			x = airCleanerPosX - 1;
			y = 0;

			// 반시계방향 계산 탐색방향 - 상우하좌 순
			int[] antiClockDirectionX = {-1, 0, 1, 0};
			int[] antiClockDirectionY = {0, 1, 0, -1};
			for(int i=0; i<4; i++) {
				while(true) {
					int movedX = x + antiClockDirectionX[i];
					int movedY = y + antiClockDirectionY[i];
					
					// 반시계방향 바람 밖으로 벗어난 경우
					if(movedX < 0 || airCleanerPosX - 1 < movedX || 
						movedY < 0 || c <= movedY) {
						break;
					} else {
						// 바람으로 이동되는 경우
						room[x][y] = room[movedX][movedY];
						
						x = movedX;
						y = movedY;
					}
				}
			}
			// 회전 후 작업
			room[airCleanerPosX-1][0] = -1; // 공기청정기 위치 표시 
			room[airCleanerPosX-1][1] = 0; // 정화된 바람이 나온 곳 표시
			
			time++;
		}
		
		// 미세먼지 총 양
		int sum = 0;
		for(int x=0; x<r; x++) {
			for(int y=0; y<c; y++) {
				if(room[x][y] == -1) continue;
				sum += room[x][y];
			}
		}
		System.out.println(sum);
	}
	
}