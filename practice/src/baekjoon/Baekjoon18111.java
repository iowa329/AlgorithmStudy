package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon18111 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(strTkr.nextToken());
		int m = Integer.parseInt(strTkr.nextToken());
		int b = Integer.parseInt(strTkr.nextToken());
		
		int[] cnt = new int[256+1];
		int[][] land = new int[n][m];
		for(int i=0; i<n; i++) {
			strTkr = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				int block = Integer.parseInt(strTkr.nextToken());
				land[i][j] = block;
				cnt[block]++;
			}
		}
		br.close();
		
		int minTime = Integer.MAX_VALUE;
		int landHeight = 0;
		for(int baseHeight=0; baseHeight<=256; baseHeight++) {
			if(cnt[baseHeight] != 0) {
				
				int curTime = 0;
				for(int curHeight=0; curHeight<=256; curHeight++) {
					if(cnt[curHeight] != 0 && curHeight != baseHeight) {
						int gap = baseHeight - curHeight;
						int takeTime = gap < 0 ? 2 : 1;
					}
				}
				
			}
		}
	}
	
}
