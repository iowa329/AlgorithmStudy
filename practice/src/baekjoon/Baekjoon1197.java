package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1197 {

	static int[] parent;
	
	private static class Node implements Comparable<Node> {
		int start, end;
		int edge;
		
		public Node(int start, int end, int edge) {
			this.start = start;
			this.end = end;
			this.edge = edge;
		}

		// edge 기준으로 오름차순 정렬
		@Override
		public int compareTo(Node o) {
			return this.edge - o.edge;
		}
	
		@Override
		public String toString() {
			return "(" + start + "-" + end + ") " + edge;
		}
	}
	
	// 최소 신장 트리(MST)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(strTkr.nextToken());
		int e = Integer.parseInt(strTkr.nextToken());
		
		// edge기준으로 정렬된 우선순위 큐 선언
		PriorityQueue<Node> pq = new PriorityQueue<>();
		for(int i=1; i<=e; i++) {
			strTkr = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(strTkr.nextToken());
			int end = Integer.parseInt(strTkr.nextToken());
			int edge = Integer.parseInt(strTkr.nextToken());
			
			pq.add(new Node(start, end, edge));
		}
		br.close();
		
		// 부모노드 저장 배열 초기화
		parent = new int[v+1];
		for(int i=1; i<=v; i++)
			parent[i] = i;
		
		// 정렬된 큐에서 순서대로 노드 병합하여 최소 스패닝 트리 만들기
		int minTotalEdges = 0;
		for(int i=1; i<=e; i++) {
			Node node = pq.poll(); // 개선된 for문 사용대신 poll을 이용한 우선순위 큐를 사용해야 느슨한 정렬상태에서 정렬의 효과를 볼 수 있다(그냥 사용하면 완전정렬x)
			int startRoot = findParent(node.start);
			int endRoot = findParent(node.end);
			
			if(startRoot == endRoot)
				continue;
			
			parent[endRoot] = startRoot;
			minTotalEdges += node.edge;
		}
		
		// 최소 스패닝 트리 가중치 결과
		System.out.println(minTotalEdges);
	}
	
	private static int findParent(int v) {
		if(parent[v] == v)
			return v;
		
		return parent[v] = findParent(parent[v]);
	}
	
}