package baekjoon;

import java.io.*;
import java.util.*;

class Bottle {
	int a, b, c;
	
	public Bottle(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
}

public class Baekjoon2251 {

	static int a, b, c;
	static boolean[][][] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		// 물통 정보 입력받기
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		a = Integer.parseInt(strTkr.nextToken());
		b = Integer.parseInt(strTkr.nextToken());
		c = Integer.parseInt(strTkr.nextToken());
		
		br.close();
		
		
		
		
//		int result = pouringWater(a, b, c);
		
		ArrayList<Integer> answerLists = BFS();
		
		for(int answerList: answerLists) {
			System.out.print(answerList + " ");
		}
		
//		System.out.println(answerList.toString());
	}

	// BFS
	private static ArrayList<Integer> BFS() {
		ArrayList<Integer> answerList = new ArrayList<Integer>();
		
//		StringBuilder sb = new StringBuilder();
		visited = new boolean[a+1][b+1][c+1];
		
		Queue<Bottle> que = new LinkedList<>();
		que.add(new Bottle(0, 0, c));
		
		
		// 물을 부울 수 있는 경우는 총 6가지
		while(que.isEmpty() == false) {
			Bottle bottleInfo = que.poll();
			
			
			
			System.out.println("Bottle Info: " + bottleInfo.a + " " + bottleInfo.b + " " + bottleInfo.c + " ");
			
			
			
			
			// 이미 진행되었던 상황이라면
			if(visited[bottleInfo.a][bottleInfo.b][bottleInfo.c] == true) {
				continue;
			}
			
			
			// 아니라면
			visited[bottleInfo.a][bottleInfo.b][bottleInfo.c] = true;
						
			
			// 만약 a에 물이 없다면 
			if(bottleInfo.a == 0) {
//				answerList.add(curWater.c);
				System.out.println(bottleInfo.a + " " + bottleInfo.b + " " + bottleInfo.c + " ");
				
				// c의 물 정보값을 답에 추가
//				sb.append(bottleInfo.c + " ");
				answerList.add(bottleInfo.c);
			}
			
			
			
			
			
			
			// a -> b
			if(bottleInfo.a + bottleInfo.b <= b) {
				que.add(new Bottle(0, bottleInfo.a + bottleInfo.b, bottleInfo.c));
			} else {
				que.add(new Bottle(bottleInfo.a - (b - bottleInfo.b), b, bottleInfo.c));
			}
			
//			System.out.println("a>>b " + curWater.a + " " + curWater.b + " " + curWater.c + " ");
			
//			que.add(new Bottle(curWater.a, curWater.b, curWater.c));
//			visited[curWater.a][curWater.b][curWater.c] = true;
			
			// a -> c
			if(bottleInfo.a + bottleInfo.c <= c) {
				que.add(new Bottle(0, bottleInfo.b, bottleInfo.a + bottleInfo.c));
			} else {
				que.add(new Bottle(bottleInfo.a - (c - bottleInfo.c), bottleInfo.b, c));
			}
			
//			System.out.println("a>>c " + curWater.a + " " + curWater.b + " " + curWater.c + " ");
			
//			que.add(new Bottle(curWater.a, curWater.b, curWater.c));
//			visited[curWater.a][curWater.b][curWater.c] = true;
			
			// b -> c
			if(bottleInfo.b + bottleInfo.c <= c) {
				que.add(new Bottle(bottleInfo.a, 0, bottleInfo.b + bottleInfo.c));
			} else {
				que.add(new Bottle(bottleInfo.a, bottleInfo.b - (c - bottleInfo.c), c));
			}

//			System.out.println("b>>c " + curWater.a + " " + curWater.b + " " + curWater.c + " ");
			
//			que.add(new Bottle(curWater.a, curWater.b, curWater.c));
//			visited[curWater.a][curWater.b][curWater.c] = true;
			
			// b -> a
			if(bottleInfo.b + bottleInfo.a <= a) {
				que.add(new Bottle(bottleInfo.b + bottleInfo.a, 0, bottleInfo.c));
			} else {
				que.add(new Bottle(a, bottleInfo.b - (a - bottleInfo.a), bottleInfo.c));
			}

//			System.out.println("b>>a " + curWater.a + " " + curWater.b + " " + curWater.c + " ");
			
//			que.add(new Bottle(curWater.a, curWater.b, curWater.c));
//			visited[curWater.a][curWater.b][curWater.c] = true;
			
			// c -> a
			if(bottleInfo.c + bottleInfo.a <= a) {
				que.add(new Bottle(bottleInfo.c + bottleInfo.a, bottleInfo.b, 0));
			} else {
				que.add(new Bottle(a, bottleInfo.b, bottleInfo.c - (a - bottleInfo.a)));
			}

//			System.out.println("c>>a " + curWater.a + " " + curWater.b + " " + curWater.c + " ");
			
//			que.add(new Bottle(curWater.a, curWater.b, curWater.c));
//			visited[curWater.a][curWater.b][curWater.c] = true;
			
			// c -> b
			if(bottleInfo.c + bottleInfo.b <= b) {
				que.add(new Bottle(bottleInfo.a, bottleInfo.c + bottleInfo.b, 0));
			} else {
				que.add(new Bottle(bottleInfo.a, b, bottleInfo.c - (b - bottleInfo.b)));
			}

//			System.out.println("c>>b " + curWater.a + " " + curWater.b + " " + curWater.c + " ");
			
//			que.add(new Bottle(curWater.a, curWater.b, curWater.c));
//			visited[curWater.a][curWater.b][curWater.c] = true;
		}
		
		Collections.sort(answerList);
		
		return answerList;
//		return sb.toString();
	}
	
//	private static Bottle pouringWater(int from, int to) {
//		// from -> to
//		if(from > to) {
//			to = b;
//			from = from - to;
//		} else {
//			to = from;
//			from = 0;
//		}
//		
//		visited[from]
//		
//		return new Bottle(to, from, to)
//	}
	
}

































