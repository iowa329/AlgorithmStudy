package baekjoon;

import java.io.*;
import java.util.*;

// 2048 (Easy)
public class Baekjoon12100 {

	static int n;
	static int[][] board;
	
	static int max = 0;
	
	// 구현, 브루트포스, 시뮬레이션, 백트랙킹
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		// 보드 정보 입력받기
		board = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				board[i][j] = Integer.parseInt(strTkr.nextToken());
			}
		}
		br.close();
		
		// 2048 게임 시작
		game(board, 0);
		
		// 결과
		System.out.println(max);
	}
	
	// DFS
	private static void game(int[][] curBoard, int depth) {
		if(depth == 5) {
			int curMax = findMax(curBoard);
			max = Math.max(max, curMax);
			
			return;
		}
		
		int[][] copyBoard = new int[n][n];
		for(int i=0; i<n; i++)
			copyBoard[i] = curBoard[i].clone();
		
		for(int cases=1; cases<=4;cases++) {
			int[][] movedBoard = move(cases, copyBoard);
			game(movedBoard, depth+1);
		}
	}
	
	// 이동
	private static int[][] move(int cases, int[][] curBoard) {
		int[][] boardMove = new int[n][n];
		
		// 1: 상, 2: 하, 3: 좌, 4: 우
		switch (cases) {
		// 상
		case 1:
			for(int axis=0; axis<n; axis++) {
				
				int curPos = 0;
				boolean[] visited = new boolean[n];
				for(int i=0; i<n; i++) {
					int block = curBoard[i][axis];
					
					if(block != 0) {
						if(curPos == 0) {
							boardMove[curPos++][axis] = block;
						} else { 
							if(block == boardMove[curPos-1][axis] && 
								visited[curPos-1] == false) {
								boardMove[curPos-1][axis] *= 2;
								visited[curPos-1] = true;
							} else {
								boardMove[curPos++][axis] = block;
							}
						}
					}
				}
				
			}
			break;
			
		// 하
		case 2:
			for(int axis=0; axis<n; axis++) {
				
				int curPos = n-1;
				boolean[] visited = new boolean[n];
				for(int i=n-1; i>=0; i--) {
					int block = curBoard[i][axis];
					
					if(block != 0) {
						if(curPos == n-1) {
							boardMove[curPos--][axis] = block;
						} else { 
							if(block == boardMove[curPos+1][axis] && 
								visited[curPos+1] == false) {
								boardMove[curPos+1][axis] *= 2;
								visited[curPos+1] = true;
							} else {
								boardMove[curPos--][axis] = block;
							}
						}
					}
				}
				
			}
			break;
		
		// 좌
		case 3:
			for(int axis=0; axis<n; axis++) {
				
				int curPos = 0;
				boolean[] visited = new boolean[n];
				for(int i=0; i<n; i++) {
					int block = curBoard[axis][i];
					
					if(block != 0) {
						if(curPos == 0) {
							boardMove[axis][curPos++] = block;
						} else { 
							if(block == boardMove[axis][curPos-1] && 
								visited[curPos-1] == false) {
								boardMove[axis][curPos-1] *= 2;
								visited[curPos-1] = true;
							} else {
								boardMove[axis][curPos++] = block;
							}
						}
					}
				}
				
			}
			break;
			
			// 우
			case 4:
				for(int axis=0; axis<n; axis++) {
					
					int curPos = n-1;
					boolean[] visited = new boolean[n];
					for(int i=n-1; i>=0; i--) {
						int block = curBoard[axis][i];
						
						if(block != 0) {
							if(curPos == n-1) {
								boardMove[axis][curPos--] = block;
							} else { 
								if(block == boardMove[axis][curPos+1] && 
									visited[curPos+1] == false) {
									boardMove[axis][curPos+1] *= 2;
									visited[curPos+1] = true;
								} else {
									boardMove[axis][curPos--] = block;
								}
							}
						}
					}
					
				}
				break;
		}
		
		return boardMove;
	}
	
	// 가장 큰 블록 숫자 찾기
	private static int findMax(int[][] resultBoard) {
		int max = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				max = Math.max(max, resultBoard[i][j]);
			}
		}
		
		return max;
	}
	
	private static void printBoard(int[][] board) {
		for(int[] x: board)
			System.out.println(Arrays.toString(x));
		System.out.println();
	}
	
}