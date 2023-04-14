package programmers;

import java.util.*;

public class 코딩테스트연습_DFS_BFS_네트워크 {

	public static void main(String[] args) {
//		int n = 3; int[][] computers = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
		int n = 3; int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		
		System.out.println(solution(n, computers));
	}
	
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        
        boolean[] visited = new boolean[n];
        for(int computer=0; computer<n; computer++) {
        	for(int connectedComputer=0; connectedComputer<n; connectedComputer++) {
        		
        		if(computers[computer][connectedComputer] == 1 &&
        			visited[connectedComputer] == false) {
        			answer++;
        			
        			Queue<Integer> que = new LinkedList<>();
        			que.add(connectedComputer);
        			visited[connectedComputer] = true;
        			
        			while(que.isEmpty() == false) {
        				int curComputer = que.poll();
        				
        				for(int i=0; i<n; i++) {
        					if(computers[curComputer][i] == 1 && 
        						visited[i] == false) {
        						
        						que.add(i);
        						visited[i] = true;
        					}
        				}
        			}        			
        		}
        		
        	}
        }
        
        return answer;
    }
	
}