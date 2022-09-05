package baekjoon;

import java.util.*;

public class Baekjoon16948 {

	static int n;
	static int r1, r2;
	static int c1, c2;
	
	static int[] mobilityR = {-2, -2, 0, 0, 2, 2}; 
	static int[] mobilityC = {-1, 1, -2, 2, -1, 1};
	
	static boolean[][] check;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		// 입력값 받기
		n = sc.nextInt();
		
		r1 = sc.nextInt();
		c1 = sc.nextInt();
		
		r2 = sc.nextInt();
		c2 = sc.nextInt();
		
		sc.close();
		
		
		check = new boolean[n][n];
		
		
		// 경우의 수 탐색
		int result = searchCases();
		System.out.print(result);
	}
	
	// BFS
	private static int searchCases() { 
		Queue<knight> que = new LinkedList<knight>();
		
		// 체스말 시작점 설정
		que.add(new knight(r1, c1, 0));
		check[r1][c1] = true;
		
		while(que.isEmpty() == false) {
			knight currentKnight = que.poll();
			
			for(int i=0; i<mobilityR.length; i++) {
				int destinatonR = currentKnight.currentR + mobilityR[i];
				int destinatonC = currentKnight.currentC + mobilityC[i];
				int destinatonMoveCount = currentKnight.nowMoveCount + 1;

				System.out.println("mobility : " + mobilityR[i] + " " + mobilityC[i]);
				System.out.println(destinatonR + " " + destinatonC + " " + destinatonMoveCount);
				
				// 체스판 범위를 벗어나거나 이미 방문한 경우
				if(destinatonR < 0 || destinatonR > n-1 || 
					destinatonC < 0 || destinatonC > n-1 || 
					check[destinatonR][destinatonC] == true) {
					
					continue;
				}
				
				// 목적지에 도착한 경우
				if(destinatonR == r2 && destinatonC == c2) {
					return destinatonMoveCount;
				}
				
				// 조건을 만족하지 못한 경우 현재 위치를 체크하고
				check[destinatonR][destinatonC] = true;
				// 다음 경우의 수로 넘어간다
				que.add(new knight(destinatonR, destinatonC, destinatonMoveCount));
				
				System.out.println("--->");
			}
						
		}
		
		// 만족하는 결과가 없을 경우
		return -1;
	}

}


// BFS node 개념의 체스 말 클래스 정의 
class knight {
	int currentR;
	int currentC;
	
	int nowMoveCount;
	
	knight(int r, int c, int cnt) {
		currentR = r;
		currentC = c;
		
		nowMoveCount = cnt;
	}
}


// 제출코드

//import java.util.*;
//
//public class Main {
//
//	static int n;
//	static int r1, r2;
//	static int c1, c2;
//	
//	static int[] mobilityR = {-2, -2, 0, 0, 2, 2}; 
//	static int[] mobilityC = {-1, 1, -2, 2, -1, 1};
//	
//	static boolean[][] check;
//	
//	public static void main(String[] args) {
//
//		Scanner sc = new Scanner(System.in);
//		
//		// 입력값 받기
//		n = sc.nextInt();
//		
//		r1 = sc.nextInt();
//		c1 = sc.nextInt();
//		
//		r2 = sc.nextInt();
//		c2 = sc.nextInt();
//		
//		sc.close();
//		
//		
//		check = new boolean[n+1][n+1];
//		
//		
//		// 경우의 수 탐색
//		int result = searchCases();
//		System.out.print(result);
//	}
//	
//	// BFS
//	private static int searchCases() { 
//		Queue<knight> que = new LinkedList<knight>();
//		
//		// 체스말 시작점 설정
//		que.add(new knight(r1, c1, 0));
//		check[r1][c1] = true;
//		
//		while(que.isEmpty() == false) {
//			knight currentKnight = que.poll();
//			
//			for(int i=0; i<mobilityR.length; i++) {
//				int destinatonR = currentKnight.currentR + mobilityR[i];
//				int destinatonC = currentKnight.currentC + mobilityC[i];
//				int destinatonMoveCount = currentKnight.nowMoveCount + 1;
//
//				// 체스판 범위를 벗어나거나 이미 방문한 경우
//				if(destinatonR < 0 || destinatonR > n || 
//					destinatonC < 0 || destinatonC > n || 
//					check[destinatonR][destinatonC] == true) {
//					
//					continue;
//				}
//				
//				// 목적지에 도착한 경우
//				if(destinatonR == r2 && destinatonC == c2) {
//					return destinatonMoveCount;
//				}
//				
//				// 조건을 만족하지 못한 경우 현재 위치를 체크하고
//				check[destinatonR][destinatonC] = true;
//				// 다음 경우의 수로 넘어간다
//				que.add(new knight(destinatonR, destinatonC, destinatonMoveCount));
//			}
//						
//		}
//		
//		// 만족하는 결과가 없을 경우
//		return -1;
//	}
//
//}
//
//
//// BFS node 개념의 체스 말 클래스 정의 
//class knight {
//	int currentR;
//	int currentC;
//	
//	int nowMoveCount;
//	
//	knight(int r, int c, int cnt) {
//		currentR = r;
//		currentC = c;
//		
//		nowMoveCount = cnt;
//	}
//}