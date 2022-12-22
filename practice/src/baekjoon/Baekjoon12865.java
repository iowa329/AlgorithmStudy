package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon12865 {

	static int n, k;
	static int[][] stuff;
	static boolean[] combi;
	static int maxValue = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		n = Integer.parseInt(strTkr.nextToken());
		k = Integer.parseInt(strTkr.nextToken());
	
		stuff = new int[n][2];
		int totalWeight = 0;
		for(int i=0; i<n; i++) {
			strTkr = new StringTokenizer(br.readLine());
			stuff[i][0] = Integer.parseInt(strTkr.nextToken()); // 무게 w
			stuff[i][1] = Integer.parseInt(strTkr.nextToken()); // 가치 v
			
			totalWeight += stuff[i][0];
		}
		br.close();
		
		combi = new boolean[n];
		Arrays.fill(combi, true);
		
		dfs(0, totalWeight);
		
		System.out.println(maxValue);
	}
	
	private static void dfs(int startIndex, int weight) {
		if(weight <= k) {
			int totalValue = 0;
			for(int i=0; i<n; i++) {
				if(combi[i]) {
					totalValue += stuff[i][1];
				}
			}
			maxValue = Math.max(maxValue, totalValue);
			
			return;
		}
		
		for(int i=startIndex; i<n; i++) {
			if(combi[i] == true) {
				combi[i] = false;
				dfs(i+1, weight - stuff[i][0]);
				combi[i] = true;
			}
		}
	}
}