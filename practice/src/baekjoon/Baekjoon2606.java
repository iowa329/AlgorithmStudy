package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon2606 {

	static ArrayList<ArrayList<Integer>> computers = new ArrayList<>();
	static int computerCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		computerCnt = Integer.parseInt(br.readLine());
		
		for(int i=0; i<=computerCnt; i++) {
			computers.add(new ArrayList<>());
		}
		
		int networksInfo = Integer.parseInt(br.readLine());
		for(int i=0; i<networksInfo; i++) {
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(strTkr.nextToken());
			int b = Integer.parseInt(strTkr.nextToken());
			
			computers.get(a).add(b);
			computers.get(b).add(a);
		}
		br.close();
		
		// 입력확인
		System.out.println(Arrays.deepToString(computers.toArray()));
		
		int result = computerNetwork();
		System.out.println(result);
	}
	
	// BFS 
	private static int computerNetwork() {
		int infected = 0;
		boolean[] visited = new boolean[computerCnt+1];
		
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(1);
		visited[1] = true;
		
		while(que.isEmpty() == false) {
			int curComputer = que.poll();
			
			// 연결된 컴퓨터를 통해 웜 바이러스 전파
			for(int connectedComputer: computers.get(curComputer)) {
				if(visited[connectedComputer] == false) {
					que.add(connectedComputer);
					visited[connectedComputer] = true;
					infected++;
				}
			}
		}
		
		return infected;
	}

}