package baekjoon;

import java.util.*;

public class Baekjoon16928 {

	// 편의상 0번 인덱스는 제외
	static int[] boardInfo = new int[100+1];
	static boolean[] visited = new boolean[100+1];
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
				
		int cntLadder = sc.nextInt();
		int cntSnake = sc.nextInt();

		// 입력값 받기
		for(int i=0; i<cntLadder; i++) {
			int position = sc.nextInt();
			boardInfo[position] = sc.nextInt();
		}
		for(int i=0; i<cntSnake; i++) {
			int position = sc.nextInt();
			boardInfo[position] = sc.nextInt();
		}
		
		// 보드값 입력 검사
//		for(int j=0; j<100; j=+10) {
//			for(int i=1; i<=10; i++) {
//			
//				if(boardInfo[i+j] == 0) System.out.print("0");
//				System.out.print(boardInfo[i+j] + " ");
//			}
//			System.out.println();
//			
//		}
//		for(int i=0; i<101; i++) {
//			System.out.print(boardInfo[i]+ " ");
//		}
		
		
		sc.close();

		// 보드게임 시작
		int result = playGame();
		System.out.println(result);
	}

	// BFS
	private static int playGame() {
		Queue<Player> que = new LinkedList<Player>();
		que.add(new Player(1, 0));
		visited[1] = true;
		
		while(que.isEmpty() == false) {
			Player currentPosition = que.poll();
			
			// 주사위의 경우의 수
			for(int dice = 1; dice <= 6; dice++) {
				int movePosition = currentPosition.position + dice;
				int moveCntDice = currentPosition.cntDice + 1;
				
				
				System.out.println(movePosition + " " + moveCntDice);
				
				// 보드판 범위를 넘어서거나 이미 방문한 경우 제외
				if(movePosition > 100 ||
					visited[movePosition] == true) {
					continue;
				}
				
				// 목적지에 도착한 경우
				if(movePosition == 100) {
					return moveCntDice;
				}
				
				visited[movePosition] = true;
				// 보드의 정보(사다리와 뱀)를 읽어와 위치를 계산
				if(boardInfo[movePosition] != 0) {
					movePosition = boardInfo[movePosition];
				}
				que.add(new Player(movePosition, moveCntDice));					
				
			}
			System.out.println();
		}
		
		return 0;
	}
	
}



class Player {
	int position;
	int cntDice;
	
	public Player(int position, int cntDice) {
		this.position = position;
		this.cntDice = cntDice;
	}
}
