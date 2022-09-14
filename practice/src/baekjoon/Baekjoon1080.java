package baekjoon;

import java.util.*;

public class Baekjoon1080 {

	static Scanner sc = new Scanner(System.in);
	
	static int n = sc.nextInt();
	static int m = sc.nextInt();
	
	static int[][] matrixA = new int[n][m];
	static int[][] matrixB = new int[n][m];
	
	public static void main(String[] args) {
		// matrixA
		for(int i=0; i<n; i++) {
			String input = sc.next();
			for(int j=0; j<m; j++) {
				matrixA[i][j] = Character.getNumericValue(input.charAt(j));
				System.out.print(matrixA[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		
		// matrixB
		for(int i=0; i<n; i++) {
			String input = sc.next();
			for(int j=0; j<m; j++) {
				matrixB[i][j] = Character.getNumericValue(input.charAt(j));
				System.out.print(matrixB[i][j] + " ");
			}
			System.out.println();
		}
		sc.close();

		
		// 최소 행렬변환 탐색
		int result = changeMatrix();
		System.out.println("\n" + result);
	}

	
	// Greedy
	private static int changeMatrix() {
		int changeCnt = 0;
		
		// 행렬 A, B가 부분행렬(3x3) 보다 작은 경우
		if(n < 3 || m < 3) {
			return isSameMatrix(changeCnt);
		}
		
		// 왼쪽 상단부터 차례대로 탐색
		for(int i=0; i<n-2; i++) {
			for(int j=0; j<m-2; j++) {
				
				// 만약 (3x3 부분행렬 왼쪽 위) A와 B가 다르다면
				if(matrixA[i][j] != matrixB[i][j]) {
					// 3x3 부분행렬 원소 전체변환
					for(int x=i; x<i+3; x++) {
						for(int y=j; y<j+3; y++) {
							matrixA[x][y] = matrixA[x][y] == 0 ? 1 : 0;
						}
					}
					changeCnt++;
				}
				
			}
		}
		
		return isSameMatrix(changeCnt);
	}
	
	
	// 같을 경우 원래 changeCnt, 틀릴경우 -1(변환할 수 없음)을 반환
	private static int isSameMatrix(int changeCnt) {
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(matrixA[i][j] != matrixB[i][j]) {
					changeCnt = -1;
					
					return changeCnt;
				}
			}
		}
		
		return changeCnt;
	}
	
}


// 제출코드

//import java.util.*;
//
//public class Main {
//
//	static Scanner sc = new Scanner(System.in);
//	
//	static int n = sc.nextInt();
//	static int m = sc.nextInt();
//	
//	static int[][] matrixA = new int[n][m];
//	static int[][] matrixB = new int[n][m];
//	
//	public static void main(String[] args) {
//		// matrixA
//		for(int i=0; i<n; i++) {
//			String input = sc.next();
//			for(int j=0; j<m; j++) {
//				matrixA[i][j] = Character.getNumericValue(input.charAt(j));
//			}
//		}
//		
//		// matrixB
//		for(int i=0; i<n; i++) {
//			String input = sc.next();
//			for(int j=0; j<m; j++) {
//				matrixB[i][j] = Character.getNumericValue(input.charAt(j));
//			}
//		}
//		sc.close();
//
//		
//		// 최소 행렬변환 탐색
//		int result = changeMatrix();
//		System.out.println(result);
//	}
//
//	
//	// Greedy
//	private static int changeMatrix() {
//		int changeCnt = 0;
//		
//		// 행렬 A, B가 부분행렬(3x3) 보다 작은 경우
//		if(n < 3 || m < 3) {
//			return isSameMatrix(changeCnt);
//		}
//		
//		// 왼쪽 상단부터 차례대로 탐색
//		for(int i=0; i<n-2; i++) {
//			for(int j=0; j<m-2; j++) {
//				
//				// 만약 (3x3 부분행렬 왼쪽 위) A와 B가 다르다면
//				if(matrixA[i][j] != matrixB[i][j]) {
//					// 3x3 부분행렬 원소변환
//					for(int x=i; x<i+3; x++) {
//						for(int y=j; y<j+3; y++) {
//							matrixA[x][y] = matrixA[x][y] == 0 ? 1 : 0;
//						}
//					}
//					changeCnt++;
//				}
//				
//			}
//		}
//		
//		return isSameMatrix(changeCnt);
//	}
//	
//	
//	// 같을 경우 원래 changeCnt, 틀릴경우 -1(변환할 수 없음)을 반환
//	private static int isSameMatrix(int changeCnt) {
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				if(matrixA[i][j] != matrixB[i][j]) {
//					changeCnt = -1;
//					
//					return changeCnt;
//				}
//			}
//		}
//		
//		return changeCnt;
//	}
//	
//}