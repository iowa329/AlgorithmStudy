package baekjoon;

import java.io.*;
import java.util.*;

class Node16234 {
	int x, y;
	
	public Node16234(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Baekjoon16234 {

	static int n, l, r;
	static int[][] a;
	static ArrayList<Node16234> unionList;
	static boolean[][] visit;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		n = Integer.parseInt(strTkr.nextToken());
		l = Integer.parseInt(strTkr.nextToken());
		r = Integer.parseInt(strTkr.nextToken());
		
		a = new int[n][n];
		for(int x=0; x<n; x++) {
			strTkr = new StringTokenizer(br.readLine());
			for(int y=0; y<n; y++) {
				a[x][y] = Integer.parseInt(strTkr.nextToken());
			}
		}
		br.close();
		
		int day = 0;
		while(true) {
			visit = new boolean[n][n];
			boolean isMove = false;
			
			for(int x=0; x<n; x++) {
				for(int y=0; y<n; y++) {
					if(visit[x][y] == false) { // union이 형성된 곳은 제외
						bfs(x, y);
						
						int totalPopulation = 0;
						int cityCnt = unionList.size();
						
						if(cityCnt >= 2) { // 시작 도시는 목록에 항상 추가하고 BFS 탐색을 시작하므로 2이상이어야 한다
							for(Node16234 list: unionList)
								totalPopulation += a[list.x][list.y];
							int avgPopulation = totalPopulation / cityCnt;
							
							for(Node16234 list: unionList)
								a[list.x][list.y] = avgPopulation;
							
							isMove = true;
						}
					}
				}
			}
			
			if(isMove == false)
				break;
			
			day++;
		}
		
		// 인구이동이 발생한 기간
		System.out.println(day);
	}
	
	private static void bfs(int x, int y) {
		Queue<Node16234> que = new LinkedList<>(); // 탐색도시 목록
		unionList = new ArrayList<>(); // 연합도시 목록 초기화
		
		// 탐색 시작 도시값 입력
		que.add(new Node16234(x, y));
		unionList.add(new Node16234(x, y));
		visit[x][y] = true;
		
		// BFS
		while(que.isEmpty() == false) {
			Node16234 curCity = que.poll();
			
			// 상하좌우 배열 정의
			int[] moveX = {-1, 1, 0, 0};
			int[] moveY = {0, 0, -1, 1};
			
			// 상하좌우 탐색
			for(int i=0; i<4; i++) {
				int movedX = curCity.x + moveX[i];
				int movedY = curCity.y + moveY[i];
				
				// 배열 범위 유효검사
				if(0 <= movedX && movedX < n &&
					0 <= movedY && movedY < n) {
					
					if(visit[movedX][movedY] == false) {						
						int diff = Math.abs(a[curCity.x][curCity.y] - a[movedX][movedY]);
						if(l <= diff && diff <= r) {
							que.add(new Node16234(movedX, movedY));
							unionList.add(new Node16234(movedX, movedY));
							visit[movedX][movedY] = true;
						}
					}
				} // 배열 범위 유효검사 if문
			} // 상하좌우 탐색 for문
		}
	}
}