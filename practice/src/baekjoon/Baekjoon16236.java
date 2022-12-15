package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon16236 {

	// 아기 상어
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 공간의 크기
		int[][] spaces = new int[n][n];
		
		int[][] babySharkPos = new int[1][2];
		// 공간정보 입력받기
		for(int i=0; i<n; i++) {
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int status = Integer.parseInt(strTkr.nextToken());
				spaces[i][j] = status;
				if(status == 9) {
					babySharkPos[0][0] = i;
					babySharkPos[0][1] = j;
				}
			}
		}
		br.close();

		// 상하좌우
		int[] moveX = {-1, 1, 0, 0};
		int[] moveY = {0, 0, -1, 1};
		
		// 물고기 사냥 시작
		int eatingTime = 0;
		while(true) {
			
			// 상하좌우 물고기 탐색
			for(int search=0; search<4; search++) {
				int searchedX = babySharkPos[0][0] + moveX[search];
				int searchedY = babySharkPos[0][1] + moveY[search];
				
				if(searchedX < 0 || n <= searchedX ||
				   searchedY < 0 || n <= searchedY) {
					continue;
				} else {
					
				}
			}
			
			eatingTime++;
		}
	}
	
}
