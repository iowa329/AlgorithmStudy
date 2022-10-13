package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon16956 {

	static int r,c;
	static char[][] farm;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 울타리 정보 입력 받기
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		r = Integer.parseInt(strTkr.nextToken());
		c = Integer.parseInt(strTkr.nextToken());
	
		farm = new char[r][c];
		for(int i=0; i<r; i++) {
			String farmInfo = br.readLine();
			for(int j=0; j<c; j++) {
				farm[i][j] = farmInfo.charAt(j);
			}
		}
		br.close();
		
		
		// 상하좌우 배열 정의
		int[] moveX = {-1, 1, 0, 0};
		int[] moveY = {0, 0, -1, 1};
		
		int protectSheep = 1;
		loop:
		for(int x=0; x<r; x++) {
			for(int y=0; y<c; y++) {
				
				// 상하좌우 탐색
				for(int i=0; i<4; i++) {
					int movedX = x + moveX[i];
					int movedY = y + moveY[i];

					// 농장범위 안 유효검사
					if(0 <= movedX && movedX < r &&
						0 <= movedY && movedY < c) {
						
						if(farm[x][y] == 'W') {
							// 늑대 바로 옆에 양이 있다면
							if(farm[movedX][movedY] == 'S') {
								protectSheep = 0;
								// 울타리 치기 종료
								break loop;
							} else 
								// 주변에 울타리를 칠 수 있다면
								if(farm[movedX][movedY] == '.') {
								// 늑대 주변에 울타리 치기
								farm[movedX][movedY] = 'D';
							}
						}
					}	
				}
				
			}
		}
		
		
		// 결과출력
		System.out.println(protectSheep);
		
		// 울타리를 칠 수 있을 경우에만 결과값을 출력
		if(protectSheep == 1) {
			StringBuilder sb = new StringBuilder();
			for(int x=0; x<r; x++) {
				for(int y=0; y<c; y++) {
					sb.append(farm[x][y]);
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}
	}

}