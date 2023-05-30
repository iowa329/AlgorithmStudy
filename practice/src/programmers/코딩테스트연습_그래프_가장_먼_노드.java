package programmers;

import java.util.*;

public class 코딩테스트연습_그래프_가장_먼_노드 {

	public static void main(String[] args) {
		int n = 6; int[][] vertex = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		
		System.out.println(solution(n, vertex));
	}
	
	static ArrayList<ArrayList<Integer>> graph;
	
	public static int solution(int n, int[][] edge) {
		graph = new ArrayList<>();
		for(int i=0; i<=n; i++)
			graph.add(new ArrayList<>());
		
		for(int i=0; i<edge.length; i++) {
			graph.get(edge[i][0]).add(edge[i][1]);
			graph.get(edge[i][1]).add(edge[i][0]);
		}
		
		// BFS
		Queue<Integer> que = new LinkedList<>();
		boolean[] visited = new boolean[n+1];
		
		que.add(1);
		visited[1] = true;
		
		int[] distances = new int[n+1];
		while(!que.isEmpty()) {
			int curNode = que.poll();
			for(int node: graph.get(curNode)) {
				if(!visited[node]) {
					que.add(node);
					visited[node] = true;
					distances[node] = distances[curNode]+1;
				}
			}
		}
		
		Arrays.sort(distances);
		int maxDistance = distances[n];
		
		int answer = 0;
		for(int distance: distances)
			if(distance == maxDistance)
				answer++;
        
        return answer;
    }
	
}