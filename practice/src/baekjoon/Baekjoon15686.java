package baekjoon;

import java.io.*;
import java.util.*;

class Point15686 {
	int x, y;
	
	public Point15686(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Baekjoon15686 {

	static int m;
	static ArrayList<Point15686> house = new ArrayList<>();
	static ArrayList<Point15686> chicken = new ArrayList<>();
	static boolean[] open;
	static int minChickenDistance = Integer.MAX_VALUE; // 폐업시키지 않을 치킨집을 최대 M개를 골랐을 때, 도시의 치킨 거리의 최솟값
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(strTkr.nextToken());
		m = Integer.parseInt(strTkr.nextToken());
		
		int[][] city = new int[n][n];
		for(int i=0; i<n; i++) {
			strTkr = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int area = Integer.parseInt(strTkr.nextToken());
				city[i][j] = area;
				
				if(area == 1)
					house.add(new Point15686(i, j));
				if(area == 2)
					chicken.add(new Point15686(i, j));
			}
		}
		br.close();
		
		open = new boolean[chicken.size()];
		dfs(0, 0);
		
		// 결과
		System.out.println(minChickenDistance);
	}
	
	// DFS
	private static void dfs(int start, int cnt) {
		if(cnt == m) {
			int cityChickenDistance = 0; // 도시의 치킨거리
			for(int i=0; i<house.size(); i++) {
				
				int minCurChickenDistance = Integer.MAX_VALUE; // 치킨거리(집과 가장 가까운 치킨집 사이의 거리)
				for(int j=0; j<chicken.size(); j++) {
					if(open[j]) {
						int curChickenDistance = Math.abs(house.get(i).x - chicken.get(j).x) +
											Math.abs(house.get(i).y - chicken.get(j).y);
						minCurChickenDistance = Math.min(minCurChickenDistance, curChickenDistance);
					}
				}
				cityChickenDistance += minCurChickenDistance;
				
			}
			minChickenDistance = Math.min(minChickenDistance, cityChickenDistance);
			return;
		}
		
		for(int i=start; i<chicken.size(); i++) {
			open[i] = true;
			dfs(i+1, cnt+1);
			open[i] = false;
		}
	}
}