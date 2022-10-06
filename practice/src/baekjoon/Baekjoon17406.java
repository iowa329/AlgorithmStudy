package baekjoon;

import java.io.*;
import java.util.*;

// 행렬 회전연산 코너 좌표값 클래스 정의
class Point {
	int x, y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// 경우의 수
// 배열(N x M) + 회전연산(k!) + 최소값 탐색(N x M)
// 최대값 (50x50) + (6!) * (50x50) = 250 + 720 * 250 = 180,250회
// 전부 탐색 가능(브루트 포스)
public class Baekjoon17406 {
	
	static int n;
	static int m;
	static int k;

	static int[][] a;
	static int[][] rcs;
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		n = Integer.parseInt(strTkr.nextToken());
		m = Integer.parseInt(strTkr.nextToken());
		k = Integer.parseInt(strTkr.nextToken());
		
		// 배열a 값 입력받기
		a = new int[n+1][m+1];
		for(int i=1; i<=n; i++) {
			strTkr = new StringTokenizer(br.readLine());
			for(int j=1; j<=m; j++) {
				a[i][j] = Integer.parseInt(strTkr.nextToken());
			}
		}
		
		// 회전연산 정보 입력받기
		rcs = new int[k][3];
		for(int i=0; i<k; i++) {
			strTkr = new StringTokenizer(br.readLine());
			rcs[i][0] = Integer.parseInt(strTkr.nextToken()); // r
			rcs[i][1] = Integer.parseInt(strTkr.nextToken()); // c
			rcs[i][2] = Integer.parseInt(strTkr.nextToken()); // s
		}
		br.close();
		
		
		// 회전연산 순서 경우의 수 조합
		permutation(new int[k], new boolean[k], 0);
		
		// 결과
		System.out.println(min);
	}
	
	// 회전연산 순열
	private static void permutation(int[] calculationOrder, boolean[] visited, int cnt) {
		// 조합 완성시
		if(cnt == k) {
			rotateArr(calculationOrder);
		}
		
		// 회전연산 rcs 값들의 순서를 calculationOrder 배열에 넣는다
		for(int i=0; i<k; i++) {
			if(visited[i] == true) continue;
			
			visited[i] = true;
			calculationOrder[cnt] = i;
			permutation(calculationOrder, visited, cnt+1);

			visited[i] = false;
		}
	}
	
	// 행렬 회전
	private static void rotateArr(int[] calculationOrder) {
		int[][] aCopy = copyArr();
		
		// 회전연산 rcs값들의 회전연산 순차 수행
		for(int i=0; i<k; i++) {
			int r = rcs[calculationOrder[i]][0];
			int c = rcs[calculationOrder[i]][1];
			int s = rcs[calculationOrder[i]][2];
			
			System.out.println("current RCS>> " + r + " " + c + " " + s);
			
			// 회전시작
			while(s > 0) {
				// 회전행렬 코너값 범위 설정
				Point cornerTopLeft = new Point(r-s, c-s);
				Point cornerTopRight = new Point(r-s, c+s);
				Point cornerBottomLeft = new Point(r+s, c-s);
				Point cornerBottomRight = new Point(r+s, c+s);
				
				// 왼쪽 위 부터 시계방향으로 행렬값 회전
				// 회전연산(for문) 방향은 반시계방향으로 진행
				int tmp = aCopy[cornerTopLeft.x][cornerTopLeft.y];
				
				// 왼쪽 변
				for(int x=cornerTopLeft.x+1; x<=cornerBottomLeft.x; x++) {
					aCopy[x-1][cornerTopLeft.y] = aCopy[x][cornerTopLeft.y];
				}
				
				// 밑 변
				for(int y=cornerBottomLeft.y+1; y<=cornerBottomRight.y; y++) {
					aCopy[cornerBottomLeft.x][y-1] = aCopy[cornerBottomLeft.x][y];
				}
				
				// 오른쪽 변
				for(int x=cornerBottomRight.x-1; x>=cornerTopRight.x; x--) {
					aCopy[x+1][cornerBottomRight.y] = aCopy[x][cornerBottomRight.y];
				}

				// 윗 변
				for(int y=cornerTopRight.y-1; y>=cornerTopLeft.y; y--) {
					aCopy[cornerTopRight.x][y+1] = aCopy[cornerTopRight.x][y];
				}
				
				aCopy[cornerTopLeft.x][cornerTopLeft.y+1] = tmp;
				
				
				// 회전연산 반경을 줄여서 행렬회전 반복
				s--;
			}
			
			// 회전확인
			System.out.print("회전확인\n");
			for (int z=1; z<=n; z++) {
				for (int j=1; j<=m; j++) {
					System.out.print(aCopy[z][j] + " ");
				}
				System.out.println();
	        }
			System.out.println();
		}
		
		// 회전완료한 행렬 값이 최소값인지 확인
		updateMin(aCopy);
	}

	// 원본수정 방지를 위한 작업용 복사배열 생성
	private static int[][] copyArr() {
		int copyArr[][] = new int[n+1][m+1];
        for (int i=0; i < n+1; i++) {
            copyArr[i] = a[i].clone();
        }
        
        return copyArr;
	}
	
	// 회전이 완료된 행렬에 대한 값이 최소값인지 판단
	private static void updateMin(int[][] rotatedArr) {
		int arrValue = Integer.MAX_VALUE;
		
		// 해당 행렬의 값은 각 행 총합 중 가장 작은값이다
		for (int i=1; i<=n; i++) {
			int sumInRow = 0;
			for (int j=1; j<=m; j++) {
				sumInRow += rotatedArr[i][j];
			}
			
			arrValue = Math.min(sumInRow, arrValue);
        }
		System.out.println("현재 행렬값: " + arrValue + "\n");
		
		min = Math.min(arrValue, min);
	}
}




































