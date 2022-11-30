package baekjoon;

import java.io.*;
import java.util.*;

class Graph implements Comparable<Graph> {
	int v;
	int w;
	
	Graph (int v, int w) {
		this.v = v;
		this.w = w;
	}

	// 오름차순 정렬
	@Override
	public int compareTo(Graph o) {
		return Integer.compare(this.w, o.w);
	}	
}

public class Baekjoon1753 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		
		int V = Integer.parseInt(strTkr.nextToken());
		int E = Integer.parseInt(strTkr.nextToken());
		
		int k = Integer.parseInt(br.readLine());
		
		ArrayList<ArrayList<Graph>> graph = new ArrayList<>();
		for(int i=0; i<=V; i++)
			graph.add(new ArrayList<>());
		
		while(E > 0) {
			strTkr = new StringTokenizer(br.readLine());
			
			int u = Integer.parseInt(strTkr.nextToken());
			int v = Integer.parseInt(strTkr.nextToken());
			int w = Integer.parseInt(strTkr.nextToken());
			
			graph.get(u).add(new Graph(v, w));
			
			E--;
		}
		br.close();
		
		// 다익스트라(Dijkstra) 알고리즘
		PriorityQueue<Graph> pq = new PriorityQueue<>();
		
		int[] minRoutes = new int[V+1];
		for(int i=0; i<V+1; i++)
			minRoutes[i] = Integer.MAX_VALUE;
		
		// 최단거리 탐색 순회 시작
		pq.add(new Graph(k, 0));
		minRoutes[k] = 0;
		while (pq.isEmpty() == false) {
			Graph curNum = pq.poll();
			
			if(curNum.w > minRoutes[curNum.v])
				continue;
		
			for(Graph graphV: graph.get(curNum.v)) {
				if(curNum.w + graphV.w < minRoutes[graphV.v]) {
					minRoutes[graphV.v] = curNum.w + graphV.w;
					pq.add(new Graph(graphV.v, minRoutes[graphV.v]));
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=V; i++) {
			if(minRoutes[i] != Integer.MAX_VALUE) {
				sb.append(minRoutes[i]);
			} else {
				sb.append("INF");
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}
	
}