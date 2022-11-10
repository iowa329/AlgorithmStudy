package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon9465 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		for(int cases=1; cases<=t; cases++) {
			// 스티커 홀짝 합 
			int[][] sumEveneOrOdd = new int[2][2];
			
			// 스티커 정보 입력받기
			int n = Integer.parseInt(br.readLine());
			int[][] stickers = new int[2][n];
			for(int i=0; i<2; i++) {
				StringTokenizer strTkr = new StringTokenizer(br.readLine());
				for(int j=0; j<n; j++) {
					stickers[i][j] = Integer.parseInt(strTkr.nextToken());
					
					int evenOrOdd = j % 2;
					sumEveneOrOdd[i][evenOrOdd] += stickers[i][j];
				}
			}

			// 스티커를 떼는 경우의 수
			int[] sums = new int[4];
			sums[0] = sumEveneOrOdd[0][0] + sumEveneOrOdd[1][1];
			sums[1] = sumEveneOrOdd[0][1] + sumEveneOrOdd[1][0];
			
			int lastIndex = n-1;
			int evenOrOdd = lastIndex % 2;
//			sums[2] = sums[evenOrOdd] - stickers[evenOrOdd][lastIndex] - stickers[evenOrOdd][lastIndex-1] + stickers[evenOrOdd][lastIndex];
//			sums[3] = sums[evenOrOdd] - stickers[evenOrOdd][lastIndex-1] - stickers[evenOrOdd][lastIndex] + stickers[evenOrOdd][lastIndex];
			
			if(lastIndex>=2) {
				if(evenOrOdd == 0) {
					sums[2] = sums[0] - stickers[0][lastIndex] - stickers[1][lastIndex-1] + stickers[1][lastIndex];
					sums[3] = sums[1] - stickers[0][lastIndex-1] - stickers[1][lastIndex] + stickers[0][lastIndex];				
				} else {
					sums[2] = sums[0] - stickers[0][lastIndex-1] - stickers[1][lastIndex] + stickers[0][lastIndex];
					sums[3] = sums[1] - stickers[0][lastIndex] - stickers[1][lastIndex-1] + stickers[1][lastIndex];
				}
			}
			
			
			
			// 최대값 찾기
			int max = 0;
			for(int sum: sums) max = Math.max(max, sum);
			for(int sum: sums) System.out.println(sum);
			
			System.out.println(max);
		}
		br.close();
	}
	
}