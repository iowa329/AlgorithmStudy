package programmers;

import java.util.*;

public class 코딩테스트연습_탐욕법_섬_연결하기 {

	public static void main(String[] args) {
		int n = 4; int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		
		System.out.println(solution(n, costs));
	}
	
	static int[] parent;
	
	// 유니온파인드(Union Find)
	public static int solution(int n, int[][] costs) {
		parent = new int[n];
		for(int i=0; i<n; i++)
			parent[i] = i;
		
		// 건설비용 기준 오름차순 정렬
		Arrays.sort(costs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		
		int minCost = 0;
		for(int i=0; i<costs.length; i++) {
			int a = findParent(costs[i][0]);
			int b = findParent(costs[i][1]);
			
			// 연결되어 있지 않다면
			if(a != b) {
				// 다리 건설
				union(a, b);
				// 다리 건설 비용 계산
				minCost += costs[i][2];
			}
		}
		
        return minCost;
    }
	
	private static void union(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		parent[b] = a;
	}
	
	private static int findParent(int index) {
		if(parent[index] == index)
			return index;
		
		return parent[index] = findParent(parent[index]);
	}
	
}