package baekjoon;

import java.util.*;

public class Baekjoon14889 {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		System.out.println("\n\n" + n);
		
		int[][] ability = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ability[i][j] = sc.nextInt();
				System.out.print(ability[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();
		
		
		int memberCount = n/2;
		
		int teamStart = 0;
		int teamLink = 0;
		
		int min = Integer.MAX_VALUE;
		int gap = 0;
		
		// 팀이 될 수 있는 경우의 수
		for(int i=0; i<memberCount; i++) {
			for(int j=0; j<memberCount; j++) {
				teamStart += ability[i][j];
				teamLink += ability[i+memberCount][j+memberCount];
			}
			gap = Math.abs(teamStart - teamLink);
			if (gap < min) {
				min = gap;
			}
			System.out.println();
//			System.out.print(ability[i][j] + " ");
		}
		
	}
	
}