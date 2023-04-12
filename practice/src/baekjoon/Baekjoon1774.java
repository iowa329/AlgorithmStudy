package baekjoon;

import java.io.*;
import java.util.*;

// 우주신과의 교감
public class Baekjoon1774 {

	static class Position {
		int num;
		int x, y;
		
		public Position(int num, int x, int y) {
			this.num = num;
			this.x = x;
			this.y = y;
		}
	}
	
	static class Edge implements Comparable<Edge> {
		int start, end;
		double distance;
		
		public Edge(int start, int end, double distance) {
			this.start = start;
			this.end = end;
			this.distance = distance;
		}
		
		@Override
		public int compareTo(Edge o) {
			// 오름차순 정렬
			return Double.compare(distance, o.distance);
//			return distance < o.distance ? -1 : 1;
		}
	}
	
	static int[] parent;
	
	// 최소 신장 트리(MST) - 크루스칼 알고리즘(Kruskal Algorithm)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(strTkr.nextToken());
		int m = Integer.parseInt(strTkr.nextToken());
		
		// 황선자씨와 우주신의 좌표위치값 입력받기
		Position[] coordinateInfo = new Position[n+1];
		for(int i=1; i<=n; ++i) {
			strTkr = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(strTkr.nextToken());
			int y = Integer.parseInt(strTkr.nextToken());
			
			coordinateInfo[i] = new Position(i, x, y);
		}
		
		// union find의 부모배열 초기화
		parent = new int[n+1];
		for(int i=1; i<=n; i++)
			parent[i] = i;
		
		// 연결된 통로 정보 입력받기
		ArrayList<Edge> channelList = new ArrayList<>();
		for(int i=1; i<=m; i++) {
			strTkr = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(strTkr.nextToken());
			int end = Integer.parseInt(strTkr.nextToken());
			
			union(start, end);
		}
		br.close();
		
		// 모든 통로 경우의 수 입력
		for(int start=1; start<=n; start++) {
			for(int end=1; end<=n; end++) {
				double distance = Math.sqrt(Math.pow(coordinateInfo[start].x - coordinateInfo[end].x, 2) + 
											Math.pow(coordinateInfo[start].y - coordinateInfo[end].y, 2));
				
				channelList.add(new Edge(start, end, distance));
			}
		}
		
		// distance값 기준 오름차순 정렬
		Collections.sort(channelList);
		
		double answer = 0.0;
		for(int i=0; i<channelList.size(); i++) {
			Edge curEdge = channelList.get(i);
			
			if(findParent(curEdge.start) != findParent(curEdge.end)) {
				union(curEdge.start, curEdge.end);
				
				answer += curEdge.distance;
			}
		}
		
		// 결과
		System.out.println(String.format("%.2f", answer));
	}
	
	// 유니온 파인드(union find)
	private static void union(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a != b)
			parent[b] = a;
	}
	
	private static int findParent(int index) {
		if(parent[index] == index)
			return parent[index];
		
		return parent[index] = findParent(parent[index]);
	}
	
}