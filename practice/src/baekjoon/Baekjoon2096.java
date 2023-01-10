package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon2096 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 진행상황 누적 dp배열 선언
		int[][] dpMax = new int[n+1][3];
		int[][] dpMin = new int[n+1][3];
		for(int i=1; i<=n; i++) {
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			int[] num = new int[3];
			for(int j=0; j<3; j++)
				num[j] = Integer.parseInt(strTkr.nextToken());
			
			dpMax[i][0] = Math.max(dpMax[i-1][0], dpMax[i-1][1]) + num[0];
			dpMax[i][1] = Math.max(dpMax[i-1][0], Math.max(dpMax[i-1][1], dpMax[i-1][2])) + num[1];
			dpMax[i][2] = Math.max(dpMax[i-1][1], dpMax[i-1][2]) + num[2];
			
			dpMin[i][0] = Math.min(dpMin[i-1][0], dpMin[i-1][1]) + num[0];
			dpMin[i][1] = Math.min(dpMin[i-1][0], Math.min(dpMin[i-1][1], dpMin[i-1][2])) + num[1];
			dpMin[i][2] = Math.min(dpMin[i-1][1], dpMin[i-1][2]) + num[2];
		}
		br.close();
		
		int max = Math.max(dpMax[n][0], Math.max(dpMax[n][1], dpMax[n][2]));
		int min = Math.min(dpMin[n][0], Math.min(dpMin[n][1], dpMin[n][2]));
		
		// 최대 점수와 최소 점수를 출력
		System.out.println(max + " " + min);
	}
}