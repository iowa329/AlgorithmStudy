package programmers;

import java.util.*;

public class 코딩테스트연습_완전탐색_전력망을_둘로_나누기 {

	public static void main(String[] args) {
//		int n = 9; int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};
//		int n = 4; int[][] wires = {{1,2},{2,3},{3,4}};
		int n = 7; int[][] wires = {{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}};
		
		System.out.println(solution(n, wires));
	}
	
	static boolean[][] powerGrid;
	
	public static int solution(int n, int[][] wires) {
        powerGrid = new boolean[n+1][n+1];
		for(int i=0; i<wires.length; i++) {
			int v1 = wires[i][0];
			int v2 = wires[i][1];
			
			powerGrid[v1][v2] = true;
			powerGrid[v2][v1] = true;
		}
		
		int minGap = n;
		for(int i=0; i<wires.length; i++) {
			int v1 = wires[i][0];
			int v2 = wires[i][1];
			
			powerGrid[v1][v2] = false;
			powerGrid[v2][v1] = false;
			
			minGap = Math.min(minGap, bfs(n, i+1));
			
			powerGrid[v1][v2] = true;
			powerGrid[v2][v1] = true;			
		}
        
        return minGap;
    }
	
	private static int bfs(int n, int start) {
		boolean[] check = new boolean[n+1];
		check[start] = true;
		
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(start);
		
		int cnt = 1;
		while(!que.isEmpty()) {
			int curPower = que.poll();
			for(int i=1; i<=n; i++) {
				if(powerGrid[curPower][i] && !check[i]) {
					que.add(i);
					check[i] = true;
					cnt++;
				}
			}
		}
		
		return Math.abs((n-cnt)-cnt);
	}
	
}