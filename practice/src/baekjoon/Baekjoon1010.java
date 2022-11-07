package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1010 {
	
	static int[][] combi = new int[31][31]; // m의 최댓값은 30이므로
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int cases=1; cases<=t; cases++) {
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(strTkr.nextToken());
			int m = Integer.parseInt(strTkr.nextToken());
			
			System.out.println(buildBridges(m, n));
		}
		br.close();
	}
	
	// combination
	private static int buildBridges(int n, int r) {
		// 이미 계산한 조합이라면
		if(combi[n][r] != 0)
			return combi[n][r];
		
		// nCr에서 하나도 뽑지 않거나 전부 뽑는 경우는 하나이므로
		if(r == 0 || r == n)
			return combi[n][r] = 1;
		
		// 조합공식에 의해 파스칼 삼격형에 의한 이항 계수의 공식은 nCr = n-1Cr-1 + n-1Cr
		return combi[n][r] = buildBridges(n-1, r-1) + buildBridges(n-1, r);
	}
	
}