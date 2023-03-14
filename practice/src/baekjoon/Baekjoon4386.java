package baekjoon;

import java.io.*;
import java.util.*;

// 별자리 만들기
public class Baekjoon4386 {

	static class Star {
		int num;
		double x, y;
		
		public Star(int num, double x, double y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
	
	static class StarLine implements Comparable<StarLine> {
		int start, end;
		double distance;
		
		public StarLine(int start, int end, double distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}

		// 거리기준 오름차순 정렬
		@Override
		public int compareTo(StarLine o) {
			return this.distance < o.distance ? -1 : 1;
		}
		
		@Override
		public String toString() {
			return String.format("%.2f" , distance);
		}
	}
	
	static int[] parent;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// 별 정보 입력받기
		Star[] stars = new Star[n];
		for(int i=0; i<n; i++) {
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			double x = Double.parseDouble(strTkr.nextToken());
			double y = Double.parseDouble(strTkr.nextToken());
			
			stars[i] = new Star(i, x, y);
		}
		br.close();
		
		// 별 간 거리 계산
		ArrayList<StarLine> starLines = new ArrayList<>();
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				Star star1 = stars[i];
				Star star2 = stars[j];
				double distance = Math.sqrt(Math.pow(star1.x - star2.x, 2) + Math.pow(star1.y - star2.y, 2));
				
				starLines.add(new StarLine(i, j, distance));
			}
		}
		// 거리(distance) 기준 오름차순 정렬
		Collections.sort(starLines);
		
		// 루트노드 판별 배열 초기화
		parent = new int[n];
		for(int i=0; i<n; i++)
			parent[i] = i;
		
		// 최소 신장 트리(MST) 알고리즘
		double minStarLineCost = 0;
		for(int i=0; i<starLines.size(); i++) {
			StarLine starLine = starLines.get(i);
			int rootStart = findParent(starLine.start);
			int rootEnd = findParent(starLine.end);
			
			if(rootStart != rootEnd) {
				minStarLineCost += starLine.distance;
				union(starLine.start, starLine.end);
			}
		}
		
		// 별자리를 만드는 최소 비용
		System.out.println(String.format("%.2f" , minStarLineCost));
	}
	
	private static int findParent(int num) {
		if(parent[num] == num)
			return num;
		
		return parent[num] = findParent(parent[num]);
	}
	
	private static void union(int num1, int num2) {
		num1 = findParent(num1);
		num2 = findParent(num2);
		
		// 값으로 들어오는 num1은 항상 num2보다 작으므로(별 간 거리 계산 때 i는 j보다 작다)
		if(num1 != num2) {
			parent[num2] = num1; // root는 num1을 기준으로 한다
		}
	}
	
}