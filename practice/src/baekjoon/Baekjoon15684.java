package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon15684 {

	static int n, m, h;
	static int[][] ladders;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		n = Integer.parseInt(strTkr.nextToken());
		m = Integer.parseInt(strTkr.nextToken());
		h = Integer.parseInt(strTkr.nextToken());
		
		// 사다리 정보 입력받기
		ladders = new int[h+1][n+1];
		for(int i=1; i<=m; i++) {
			strTkr = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(strTkr.nextToken());
			int b = Integer.parseInt(strTkr.nextToken());
			
			ladders[a][b] = b+1;
			ladders[a][b+1]= b;
		}
		br.close();
		
		
		
		
		System.out.println("<원본>");
		for(int x=0; x<h+1; x++) {
			System.out.println(Arrays.toString(ladders[x]));
		}
		System.out.println("\n");
		
		
		
		
		int result = -1;
		
		// 가로선을 놓을 수 있는 경우의 수 탐색
		for(int i=0; i<=3; i++) {
			int[][] laddersCopy = copyArr();
			
			if(makeLadder(i, 0, laddersCopy) == true) {
				result = i;
				
				break;
			}
			
			System.out.println("done " + i + "\n");
		}
		
		
		// 결과
		System.out.print(result);
	}

	// DFS
	private static boolean makeLadder(int lineCnt, int depth, int[][] laddersCopy) {
		// 가로선을 다 만든경우
		if(depth == lineCnt) {
			for(int i=1; i<=n; i++) {
				
				System.out.println("depth " + depth);
				for(int x=0; x<h+1; x++) {
					System.out.println(Arrays.toString(laddersCopy[x]));
				}
				
				
				
				if (gameLadder(i) == false) return false;
			}
			
			return true;
		}
		
		// 가로선을 놓을 수 있는 경우의 수
		for(int i=1; i<=h; i++) {
			for(int j=1; j<=n-1; j++) {
				if(laddersCopy[i][j] == 0) {
					laddersCopy[i][j] = j+1;
					laddersCopy[i][j+1]= j;
					makeLadder(lineCnt, depth+1, laddersCopy);
					
					laddersCopy[i][j] = 0;
					laddersCopy[i][j+1] = 0;
				}
			}
		}
		
		return false;
	}
	
	// 사다리 게임 진행
	private static boolean gameLadder(int startLine) {
		int downLevel = 1;
		
		int curX = downLevel;
		int curY = startLine;
		
		while(true) {
			int moveInfo = ladders[curX][curY];
			
			 System.out.println("moveInfo: " + moveInfo);
			
			// 이동정보가 있을때
			if(moveInfo != 0)
				curY = moveInfo; // 사다리 좌우로 이동
			
			
			System.out.println(curX + " " + curY);
			
			if(downLevel == h) {
				break;
			}
			
			curX++; // 아래로 이동
			downLevel++; // 사다리 탐색 위치 갱신
		}
		
		
		System.out.println("end game>> " + startLine + " " + curY);
		return curY == startLine ? true : false;
	}

	// 사다리 정보 배열 복사
	private static int[][] copyArr() {
		int[][] laddersCopy = new int[h+1][n+1];
        for (int i=0; i <h+1; i++) {
        	laddersCopy[i] = ladders[i].clone();
        }
        
        return laddersCopy;
	}
	
}