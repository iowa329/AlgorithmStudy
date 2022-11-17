package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon20057 {

	static int[][] a;
	static int n;
	
	static int[][] spreadSandInfo = { {0, 0, 2, 0, 0},
									  {0, 10, 7, 1, 0},
									  {5, 0, 0, 0, 0},
									  {0, 10, 7, 1, 0},
									  {0, 0, 2, 0, 0} };
	
	static int outOfBoundary = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		a = new int[n+1][n+1];
		
		// 모래밭 정보 입력받기
		for(int i=1; i<=n; i++) {
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				a[i][j] = Integer.parseInt(strTkr.nextToken());
			}
		}
		br.close();
		
		// 이동범위는 1 ~ n-1까지
		int curN = 1;
		
		// 시작지점 설정
		int curR = n/2 +1;
		int curC = n/2 +1;
		
		// 좌하우상 순서로 이동
		int[] moveX = {0, 1, 0, -1};
		int[] moveY = {-1, 0, 1, 0};
		int rotationOrder = 0;
				
		// curN이 변경 될 때마다 반복
		while(curN <= n-1) {
			int maxMoveCnt = curN < n-1 ? 2 : 3; // 마지막은 세번 반복
			
			// 2번 혹은 3번 반복
			for(int repeat=1; repeat<=maxMoveCnt; repeat++) {
				// 한칸씩 이동
				for(int moveCnt=1; moveCnt<=curN; moveCnt++) {
					curR += moveX[rotationOrder];
					curC += moveY[rotationOrder];
					
					System.out.println("cur(R, C): (" + curR + ", " + curC + "), value: " + a[curR][curC]);
					
					int leftSand = spreadSand(curR, curC);
					int toSpreadX = curR+moveX[rotationOrder];
					int toSpreadY = curC+moveY[rotationOrder];

					// 모래밭 밖
					if(toSpreadX < 1 || n < toSpreadX ||
					   toSpreadY < 1 || n < toSpreadY) {
						outOfBoundary += leftSand;
					} else {
						// 모래밭 안
						a[toSpreadX][toSpreadY] += leftSand;
					}
					
					printCurSandField(curR, curC);
				}
				
				// 방향전환 (0~3 index 순환)
				rotationOrder = rotationOrder != 3 ? rotationOrder+1 : 0;
				rotateSpreadInfo();
				
				System.out.println("\nrotation");
			}
			
			curN++;
		}
		
		// 모래밭 밖으로 나간 모래의 양
		System.out.println(outOfBoundary);
	}
	
	private static int spreadSand(int curR, int curC) {
		int curSand = a[curR][curC];
		int leftSand = curSand;
		
		for(int xA=curR-2; xA<=curR+2; xA++) {
			for(int yA=curC-2; yA<=curC+2; yA++) {
				double percentage = spreadSandInfo[xA-(curR-2)][yA-(curC-2)] / 100;
				
				
				 
//				int spreadSand = curSand * (percentage / 100);
				double spreadSand = curSand * percentage;
				leftSand -= spreadSand;
				
				System.out.print(percentage + "<<percentage ");
				System.out.print(spreadSand + "<<spreadSand ");
				System.out.print(curSand + "<<curSand \n");
				
				// 모래밭 밖
				if(xA < 1 || n < xA ||
				   yA < 1 || n < yA) {
					outOfBoundary += spreadSand;
				} else {
					// 모래밭 안
					a[xA][yA] += spreadSand;
				}
			}
			
			System.out.println();
			
		}
		
		System.out.println("%%%%");
		
		a[curR][curC] = 0; // y칸에 있는 모래는 모두 날아간다
		
		return leftSand;
	}
	
	private static void rotateSpreadInfo() {
		int[][] afterRotate = new int[5][5];
		
		for(int x=0; x<5; x++) {
			for(int y=0; y<5; y++) {
				afterRotate[5-1-y][x] = spreadSandInfo[x][y];
			}
		}
		spreadSandInfo = afterRotate;
	}
	
	private static void printCurSandField(int curR, int curC) {
		for(int x=1; x<=n; x++) {
			for(int y=1; y<=n; y++) {
				if(curR == x && curC == y) {
					System.out.print("* ");			
				} else {
					System.out.print(a[x][y] + " ");					
				}
			}
			System.out.println();
		}
		
		System.out.println();
	}
	
}