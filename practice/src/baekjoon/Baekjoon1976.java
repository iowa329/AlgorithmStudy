package baekjoon;

import java.io.*;
import java.util.*;

//public class Baekjoon1976 {
//
//	static int[] parent;
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int n = Integer.parseInt(br.readLine()); // 도시의 수
//		int m = Integer.parseInt(br.readLine()); // 여행계획에 속한 도시의 수
//		
//		parent = new int[n+1];
//		for(int i=1; i<=n; i++) {
//			parent[i] = i;
//		}
//		
//		StringTokenizer strTkr;
//		for(int i=1; i<=n; i++) {
//			strTkr = new StringTokenizer(br.readLine());
//			for(int j=1; j<=n; j++) {
//				int cityConnection = Integer.parseInt(strTkr.nextToken());
//				if(cityConnection == 1) {
//					unionCity(i, j);
//				}
//			}
//		}
//		
//		String isPlanPossible = "YES";
//		
//		strTkr = new StringTokenizer(br.readLine());
//		int departureCity = Integer.parseInt(strTkr.nextToken());
//		for(int cityOrder=2; cityOrder<=m; cityOrder++) {
//			int cityTour = Integer.parseInt(strTkr.nextToken());
//			if(departureCity != findParent(cityTour)) {
//				isPlanPossible = "NO";
//				break;
//			}
//		}
//		br.close();
//		
//		// 순서대로 도시투어가 가능한지 여부 출력
//		System.out.println(isPlanPossible);
//	}
//	
//	private static int findParent(int city) {
//		if(city == parent[city])
//			return city;
//		
//		return parent[city] = findParent(parent[city]);
//	}
//	
//	private static void unionCity(int city1, int city2) {
//		city1 = findParent(city1);
//		city2 = findParent(city2);
//		
//		if(city1 != city2) {
//			if(city1 < city2) {
//				parent[city2] = city1;
//			} else {
//				parent[city1] = city2;
//			}
//		}
//	}
//}

public class Baekjoon1976 {
	
	// 플로이드 와샬
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 도시의 수
		int m = Integer.parseInt(br.readLine()); // 여행계획에 속한 도시의 수
		
		int[][] cityConnection = new int[n+1][n+1];
		StringTokenizer strTkr;
		for(int i=1; i<=n; i++) {
			strTkr = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				cityConnection[i][j] = Integer.parseInt(strTkr.nextToken());
				
				if(i == j)
					cityConnection[i][j] = 1;
			}
		}
		
		// i->j로 가는 최단경로 값 갱신
		for(int transferIndex=1; transferIndex<=n; transferIndex++)
			for(int i=1; i<=n; i++)
				for(int j=1; j<=n; j++)
					if(cityConnection[i][transferIndex] == 1 && cityConnection[transferIndex][j] == 1)
						cityConnection[i][j] = 1;
		
		String isPlanPossible = "YES";
		
		strTkr = new StringTokenizer(br.readLine());
		int departureCity = Integer.parseInt(strTkr.nextToken());
		for(int cityOrder=2; cityOrder<=m; cityOrder++) {
			int cityTour = Integer.parseInt(strTkr.nextToken());
			if(cityConnection[departureCity][cityTour] != 1) {
				isPlanPossible = "NO";
				break;
			}
		}
		br.close();
		
		// 순서대로 도시투어가 가능한지 여부 출력
		System.out.println(isPlanPossible);
	}
	
}
