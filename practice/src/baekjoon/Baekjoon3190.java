package baekjoon;

import java.io.*;
import java.util.*;

class Board {
	int x, y;
	
	public Board(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Baekjoon3190 {

	// 뱀
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 보드의 크기
		
		// 사과의 위치 입력받기
		int k = Integer.parseInt(br.readLine());
		boolean[][] isHaveApple = new boolean[n+1][n+1];
		for(int i=1; i<=k; i++) {
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(strTkr.nextToken());
			int y = Integer.parseInt(strTkr.nextToken());
			isHaveApple[x][y] = true;
		}
		
		// 뱀의 방향 변환 정보 입력받기
		int l = Integer.parseInt(br.readLine());
		char[] rotationMoment = new char[10000+1];
		for(int i=1; i<=l; i++) {
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(strTkr.nextToken());
			char c = strTkr.nextToken().charAt(0);
			rotationMoment[x] = c;
		}
		br.close();

		// 상하좌우
		int[] moveX = {-1, 1, 0, 0};
		int[] moveY = {0, 0, -1, 1};
		
		// 정보(L: 좌, D: 우)에 따른 방향전환 값
		// 상하좌우 index: 0, 1, 2, 3
		int[] directionByL = {2, 3, 1, 0}; // 좌우하상
		int[] directionByD = {3, 2, 0, 1}; // 우좌상하
		
		int directionIndex = 3; // 뱀은 처음에 오른쪽을 향한다
		
		Deque<Board> snake = new LinkedList<>();
		snake.add(new Board(1, 1));
		
		// Dummy 도스게임 시작
		int playTime = 0;
		while(true) {
			playTime++;
			
			// 뱀 이동
			int toGoX = snake.peekFirst().x + moveX[directionIndex];
			int toGoY = snake.peekFirst().y + moveY[directionIndex];
			Board toGoBoard = new Board(toGoX, toGoY);
			// 벽 혹은 자기자신과 부딪힌 경우
			if(toGoX < 1 || n < toGoX ||
			   toGoY < 1 || n < toGoY ||
			   snake.contains(toGoBoard)) {
				break;
			} else {
				// 벽 안이고 자기자신이 없어 움직일 수 있는 경우
				snake.addFirst(toGoBoard);
				
				// 사과가 없는 경우
				if(isHaveApple[toGoX][toGoY] == false)
					snake.removeLast(); // 꼬리칸을 비워준다
			}
			
			// X초가 끝난뒤에 90도 방향 회전
			char changeDirection = rotationMoment[playTime]; 
			if(changeDirection != '\0') {
				if(changeDirection == 'L') {
					directionIndex = directionByL[directionIndex];
				} else if(changeDirection == 'D') {
					directionIndex = directionByD[directionIndex];
				}
	
			}

		}
		
		// 게임 플레이 시간
		System.out.println(playTime);
	}
	
}





















