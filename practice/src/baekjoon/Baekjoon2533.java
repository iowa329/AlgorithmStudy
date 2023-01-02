package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon2533 {

	static ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
	static int[][] dp;
	static boolean[] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		for(int i=0; i<=n; i++)
			tree.add(new ArrayList<>());
		
		dp = new int[n+1][2];
		visit = new boolean[n+1];
		
		for(int i=1; i<=n-1; i++) {
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(strTkr.nextToken());
			int v = Integer.parseInt(strTkr.nextToken());
			
			tree.get(u).add(v);
			tree.get(v).add(u);
		}
		br.close();
		
		// dp 경우의 수
		// 1. 현재 노드가 얼리어답터일 때: 주변의 모든 노드가 얼리어답터여야 한다
		// 2. 현재 노드가 얼리어답터가 아닐 때: 주변의 노드에 영향을 받지 않는다
		dfs(1);
		
		// 결과
		System.out.println(Math.min(dp[1][0], dp[1][1]));
	}

	private static void dfs(int index) {
		visit[index] = true;
		
		// dp[i][0] = 내가 얼리어답터가 아닐 때 필요한 친구의 수
	    // dp[i][1] = 내가 얼리어답터일 때 필요한 친구의 수
		dp[index][0] = 0;
		dp[index][1] = 1;
		
		for(int child: tree.get(index)) {
			if(visit[child] == false) {
				dfs(child); // 제일 밑 자식(리프노드)부터 탐색한다
				
				dp[index][0] += dp[child][1]; // 자신이 얼리어답터가 아니라면 자식들은 전부 얼리어답터여야 한다
				dp[index][1] += Math.min(dp[child][0], dp[child][1]); // 자신이 얼리어답터이면 자식이 전부 얼리어답터일 필요는 없으므로 자식의 경우의 수(얼리어답터이거나 아니거나) 중 최소값을 가져온다 
			}
		}
	}
	
}