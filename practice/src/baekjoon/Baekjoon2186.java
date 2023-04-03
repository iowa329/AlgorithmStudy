package baekjoon;

import java.io.*;
import java.util.*;

// 문자판
public class Baekjoon2186 {
	
	static int n, m, k;
	static char[][] charBoard;
	static String word;
	
	static int[][][] dp;
	
	static int[] moveX = {-1, 1, 0, 0};
	static int[] moveY = {0, 0, -1, 1};
	
	static int cntRoute;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		n = Integer.parseInt(strTkr.nextToken());
		m  = Integer.parseInt(strTkr.nextToken());
		k = Integer.parseInt(strTkr.nextToken());
		
		// 문자판 정보 입력받기
		charBoard = new char[n][m];
		for(int i=0; i<n; i++) {
			String charLine = br.readLine();
			for(int j=0; j<m; j++) {
				charBoard[i][j] = charLine.charAt(j);
			}
		}
		word = br.readLine();
		br.close();
		
		// DP (방문여부 파악을 위해 메모이제이션 필요)
		// dp[x][y][i] >> 문자판 x, y에 대하여 단어(word) 인덱스 i ~ 단어 끝이 조합(유효)한지 여부 dp배열
		// 저장된 값에 따른 의미 >> -1: 방문하지 않은 경우, 0: 유효하지 않은 경우, 1: 유효한 경우 
		dp = new int[n][m][word.length()];
		for(int i=0; i<n; i++)
			for(int j=0; j<m; j++)
				Arrays.fill(dp[i][j], -1);
		
		// DP를 이용한 DFS 탐색 시작
		cntRoute = 0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				// 단어를 시작할 수 있는 문자판만 탐색
				if(charBoard[i][j] == word.charAt(0)) {
					cntRoute += findMatchWord(i, j, 0);
				}
			}
		}
		
		// 결과
		System.out.println(cntRoute);
	}
	
	// DFS
	private static int findMatchWord(int x, int y, int curMatchIndex) {
		// 방문한 적이 있다면
		if(dp[x][y][curMatchIndex] != -1)
			return dp[x][y][curMatchIndex]; // 기존값 리턴
		
		// 탐색(주어진 단어와 일치여부)이 끝났다면 단어조합이 가능한 것이므로
		if(curMatchIndex == word.length()-1)
			return dp[x][y][curMatchIndex] = 1; // 경우의 수 추가
		
		// 기본값 설정(방문처리)
		dp[x][y][curMatchIndex] = 0;
		
		// k범위까지 상하좌우 탐색 시작
		for(int range=1; range<=k; range++) {
			for(int direction=0; direction<4; direction++) {
				int movedX = x + (moveX[direction] * range);
				int movedY = y + (moveY[direction] * range);
				
				// 범위 안에 있고
				if(0 <= movedX && movedX < n && 
					0 <= movedY && movedY < m &&
					// 이동한 문자가 찾을려는 단어 내부의 '다음'문자와 일치한다면
					charBoard[movedX][movedY] == word.charAt(curMatchIndex+1)) {
					dp[x][y][curMatchIndex] += findMatchWord(movedX, movedY, curMatchIndex+1); // 다음단계 탐색
				}
			}
		}
		
		// 탐색 결과 최종값 리턴
		return dp[x][y][curMatchIndex];
	}
	
}

// 4%에서 메모리 초과
// 방문을 기억하여 효율을 높이고 무한루프(스택오버플로우)를 방지해 메모리 초과 문제 해결 필요

//public class Baekjoon2186 {
//
//	static class Position {
//		int x, y;
//		
//		public Position(int x, int y) {
//			this.x = x;
//			this.y = y;
//		}
//		
//		@Override
//		public String toString() {
//			return String.format("(%s,%s)", this.x, this.y);
//		}
//	}
//	
//	static int n, m, k;
//	static char[][] charBoard;
//	static String word;
//	
//	static int[] moveX = {-1, 1, 0, 0};
//	static int[] moveY = {0, 0, -1, 1};
//	
//	static int cntRoute;
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer strTkr = new StringTokenizer(br.readLine());
//		n = Integer.parseInt(strTkr.nextToken());
//		m  = Integer.parseInt(strTkr.nextToken());
//		k = Integer.parseInt(strTkr.nextToken());
//		
//		charBoard = new char[n][m];
//		for(int i=0; i<n; i++) {
//			String charLine = br.readLine();
//			for(int j=0; j<m; j++) {
//				charBoard[i][j] = charLine.charAt(j);
//			}
//		}
//		word = br.readLine();
//		br.close();
//		
//		cntRoute = 0;
//		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				if(charBoard[i][j] == word.charAt(0)) {
//					findMatchWord(new Position(i, j));
//				}
//			}
//		}
//		
//		// 결과
//		System.out.println(cntRoute);
//	}
//	
//	private static void findMatchWord(Position startPos) {
//		Queue<Position> que = new LinkedList<>();
//		que.add(startPos);
//		
//		int curMatchCnt = 1;
//		for(int curMatchIndex=1; curMatchIndex<word.length(); curMatchIndex++) {
//			int matchCnt = curMatchCnt;
//			curMatchCnt = 0;
//			
//			for(int cntFind=1; cntFind<=matchCnt; cntFind++) {
//				Position curPos = que.poll();
//				
//				for(int range=1; range<=k; range++) {
//					for(int direction=0; direction<4; direction++) {
//						int movedX = curPos.x + (range * moveX[direction]);
//						int movedY = curPos.y + (range * moveY[direction]);
//						
//						// 범위 안에 있고
//						if(0 <= movedX && movedX < n && 
//							0 <= movedY && movedY < m &&
//							// 이동한 문자가 찾을려는 단어 내부의 현재문자와 일치한다면
//							charBoard[movedX][movedY] == word.charAt(curMatchIndex)) {
//							
//							if(curMatchIndex == word.length()-1) {
//								cntRoute++;
//							} else {
//								que.add(new Position(movedX, movedY));
//								curMatchCnt++;
//							}
//						}
//						
//					}
//				}
//				
//			}
//			
//		}
//	}
//	
//}