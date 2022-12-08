package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1234 {

	private static int n;
	private static long[][][][] dp = new long[11][56][56][56]; // n최대 10개, rgb 최대 (한가지 색으로만 칠했을 경우) n! = 10! = 55개
	private static int[] factorial = new int[11];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		br.close();
		
		n = Integer.parseInt(strTkr.nextToken());
		int numberOfRed = Integer.parseInt(strTkr.nextToken());
		int numberOfGreen = Integer.parseInt(strTkr.nextToken());
		int numberOfBlue = Integer.parseInt(strTkr.nextToken());
		
		for(int i=1; i<11; i++)
			factorial[i] = i * factorial[i-1];
		
//		int needToDecorateToys = n * (n+1) / 2;
//		int totaltoys = numberOfRed + numberOfGreen + numberOfBlue;
		
		// 장식할 수 있는 장난감이 충분히 있을 때
//		if(totaltoys >= needToDecorateToys)
//			makeChristmasTree(1, numberOfRed, numberOfGreen, numberOfBlue);
		
		// 결과
		System.out.println(makeChristmasTree(n, numberOfRed, numberOfGreen, numberOfBlue));
	}
	
	// DP 재귀
	private static long makeChristmasTree(int level, int r, int g, int b) {
		if(r < 0 || g < 0 || b < 0)
			return 0;
		
		if(level > n)
			return 1;
		
		if(dp[level][r][g][b] != 0)
			return dp[level][r][g][b];
		
		// 3가지 색상을 칠하는 방법은 총 7가지
		// 1가지 색으로 칠할 때
		dp[level][r][g][b] += makeChristmasTree(level-1, r-level, g, b);
		dp[level][r][g][b] += makeChristmasTree(level-1, r, g-level, b);
		dp[level][r][g][b] += makeChristmasTree(level-1, r-level, g, b-level);
		
		// 같은 색에 해당하는 중복만 제외
		// -> 레벨에 장식하려는 모든 경우의 수 / (빨간색끼리 장식하는 경우의 수 * 초록색끼리 장식하는 경우의 수 * 파란색끼리 장식하는 경우의 수)
		// 2가지 색으로 칠할 때
		if(level % 2 == 0) {
			dp[level][r][g][b] += makeChristmasTree(level-1, r-(level/2), g-(level/2), b) * ( factorial[level] / (factorial[level/2] * factorial[level/2]) );
			dp[level][r][g][b] += makeChristmasTree(level-1, r, g-(level/2), b-(level/2)) * ( factorial[level] / (factorial[level/2] * factorial[level/2]) );
			dp[level][r][g][b] += makeChristmasTree(level-1, r-(level/2), g, b-(level/2)) * ( factorial[level] / (factorial[level/2] * factorial[level/2]) );
		}
		
		// 3가지 색으로 칠할 때
		if(level % 3 == 0) {
			dp[level][r][g][b] += makeChristmasTree(level-1, r-(level/3), g-(level/3), b-(level/3)) * ( factorial[level] / (factorial[level/3] * factorial[level/3] * factorial[level/3]) );
			dp[level][r][g][b] += makeChristmasTree(level-1, r-(level/3), g-(level/3), b-(level/3)) * ( factorial[level] / (factorial[level/3] * factorial[level/3] * factorial[level/3]) );
			dp[level][r][g][b] += makeChristmasTree(level-1, r-(level/3), g-(level/3), b-(level/3)) * ( factorial[level] / (factorial[level/3] * factorial[level/3] * factorial[level/3]) );
		}
		
		return dp[level][r][g][b];
	}
	
}