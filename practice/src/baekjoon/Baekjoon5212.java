package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon5212 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		
		int r = Integer.parseInt(strTkr.nextToken());
		int c = Integer.parseInt(strTkr.nextToken());
		char[][] map = new char[r][c];
		for(int i=0; i<r; i++) {
			String curMap = br.readLine();
			for(int j=0; j<c; j++) {
				map[i][j] = curMap.charAt(j);
			}
		}
		br.close();
		
		// 상하좌우
		int[] moveX = {-1, 1, 0, 0};
		int[] moveY = {0, 0, -1, 1};
		for(int x=0; x<r; x++) {
			for(int y=0; y<c; y++) {
				int ocean = 0;
				
				// 상하좌우 탐색
				for(int i=0; i<4; i++) {
					int movedX = x + moveX[i];
					int movedY = y + moveY[i];
					
					if(movedX < 0 || r <= movedX || 
						movedY < 0 || c <= movedY) {
						ocean++;
					} else if(map[movedX][movedY] == '.') {
						ocean++;
					}
					
					// 주변에 바다가 3개 이상이면
					if(ocean >= 3) {
						map[x][y] = '-'; // 침몰표시
						break; // 상하좌우 탐색이 필요없으므로 종료
					}
				}
			}
		}
		
		int startX = 10;
		int endX = 0;
		int startY = 10;
		int endY = 0;
		for(int x=0; x<r; x++) {
			for(int y=0; y<c; y++) {
				if(map[x][y] == 'X') {
					startX = Math.min(startX, x);
					endX = Math.max(endX, x);
					startY = Math.min(startY, y);
					endY = Math.max(endY, y);
				} else if(map[x][y] == '-'){
					map[x][y] = '.';
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int x=startX; x<=endX; x++) {
			for(int y=startY; y<=endY; y++) {
				sb.append(map[x][y]);
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
}