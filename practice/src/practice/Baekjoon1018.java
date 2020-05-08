package practice;

import java.util.Scanner;

public class Baekjoon1018 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int line = sc.nextInt();
		int cnt = sc.nextInt();
		
		// 줄 단위로 입력 받기
		String[] boardLines = new String[line];
		for(int i=0; i<line; i++) {
			boardLines[i] = sc.next();
			System.out.println(boardLines[i]);
		}
		sc.close();
		
		// 줄 내 문자 하나씩 쪼개기
		char[][] board = new char[line][cnt];
		for(int i=0; i<line; i++) {
			for(int j=0; j<cnt; j++) {
				board[i][j] = boardLines[i].charAt(j);
				System.out.print(board[i][j] + " ");
			}
			System.out.println("");
		}

		
		// 체스판 형태 색칠 여부 저장 값
		int[][] checkWhiteBoard = new int[line][cnt];
		int[][] checkBlackBoard = new int[line][cnt];
		
		// 1) 왼쪽 위 첫번쨰가 W 인 경우
		for(int i=0; i<line; i++) {
			
			if(i%2 == 0) {
				
				for(int j=0; j<cnt; j++) {
					if(j%2 == 0) {
						if(board[i][j] == 'W') {
							checkWhiteBoard[i][j] = 0;
						} else {
							checkWhiteBoard[i][j] = 1;
						}
					} else {
						if(board[i][j] == 'B') {
							checkWhiteBoard[i][j] += 0;
						} else {
							checkWhiteBoard[i][j] = 1;
						}
					}
				}
				
			} else {
				
				for(int j=0; j<cnt; j++) {
					if(j%2 == 0) {
						if(board[i][j] == 'B') {
							checkWhiteBoard[i][j] += 0;
						} else {
							checkWhiteBoard[i][j] = 1;
						}
					} else {
						if(board[i][j] == 'W') {
							checkWhiteBoard[i][j] = 0;
						} else {
							checkWhiteBoard[i][j] = 1;
						}
					}
				}
				
			}
		
		}
		
		// 2) 왼쪽 위 첫번쨰가 B 인 경우
		for(int i=0; i<line; i++) {
			
			if(i%2 == 0) {
				
				for(int j=0; j<cnt; j++) {
					if(j%2 == 0) {
						if(board[i][j] == 'B') {
							checkBlackBoard[i][j] = 0;
						} else {
							checkBlackBoard[i][j] = 1;
						}
					} else {
						if(board[i][j] == 'W') {
							checkBlackBoard[i][j] += 0;
						} else {
							checkBlackBoard[i][j] = 1;
						}
					}
				}
				
			} else {
				
				for(int j=0; j<cnt; j++) {
					if(j%2 == 0) {
						if(board[i][j] == 'W') {
							checkBlackBoard[i][j] += 0;
						} else {
							checkBlackBoard[i][j] = 1;
						}
					} else {
						if(board[i][j] == 'B') {
							checkBlackBoard[i][j] = 0;
						} else {
							checkBlackBoard[i][j] = 1;
						}
					}
				}
				
			}
		
		}
		
		// white 시작 기준의 보드판의 경우 보여주기
		System.out.println("");
		for(int i=0; i<line; i++) {
			for(int j=0; j<cnt; j++) {
				System.out.print(checkWhiteBoard[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
		
		// black 시작 기준의 보드판의 경우 보여주기
		for(int i=0; i<line; i++) {
			for(int j=0; j<cnt; j++) {
				System.out.print(checkBlackBoard[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("");
		
		
		
		int needColor = 0;
		int lessNeedColor = line*cnt;
		int posX = 0; int posY = 0;
		// white가 첫번째인 경우 8x8 체스판 탐색
		for(posY=0; (posY+7) < line; posY++) {
			for(posX=0; (posX+7) < cnt; posX++) {
				for(int i=posY; i < (posY+8); i++) {
					for(int j=posX; j < (posX+8); j++) {
						if (checkWhiteBoard[i][j] == 1) {
							needColor++;
						}
					}				
				}
				System.out.print(needColor + " ");
				if(needColor < lessNeedColor)
					lessNeedColor = needColor;
				needColor = 0;
			}
			System.out.println("");
		}
		// black이 첫번째인 경우 8x8 체스판 탐색
		for(posY=0; (posY+7) < line; posY++) {
			for(posX=0; (posX+7) < cnt; posX++) {
				for(int i=posY; i < (posY+8); i++) {
					for(int j=posX; j < (posX+8); j++) {
						if (checkBlackBoard[i][j] == 1) {
							needColor++;
						}
					}				
				}
				System.out.print(needColor + " ");
				if(needColor < lessNeedColor)
					lessNeedColor = needColor;
				needColor = 0;
			}
			System.out.println("");
		}
		
		
		System.out.println("");
		System.out.println("체스판 색칠에 필요한 최소 횟수 : " + lessNeedColor);
	}
	
}