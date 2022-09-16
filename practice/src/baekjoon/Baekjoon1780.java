package baekjoon;

import java.util.*;

public class Baekjoon1780 {

	static int cntMinus = 0;
	static int cntZero = 0;
	static int cntPlus = 0;
	
	public static void main(String[] args) {
		System.out.println("\n");

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int[][] oiginalPaper = new int[n][n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				oiginalPaper[i][j] = sc.nextInt(); 
				System.out.print(oiginalPaper[i][j]+ " " );
			}
			System.out.println();
		}
		sc.close();
		
		System.out.println();
		
		// 종이의 개수 카운트 시작
		dividePaper(oiginalPaper, n);
		
		System.out.println("\n<answer>");
		System.out.print(cntMinus + "\n" + 
						cntZero + "\n" +
						cntPlus);
		
	}

	
	// divide and conquer
	private static void dividePaper(int[][] paper, int size) {
		// 조건1
		int num = paper[0][0];
		boolean isAllSameNum = true;
		
		// 자른 종이 내부가 모두 같은 수 인지 탐색
		loop:
		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				if(paper[i][j] != num) {
					isAllSameNum = false;
					break loop;
				}
			}
		}
		// true면 재귀호출 반환, false면 조건2 검사
		System.out.print(isAllSameNum + (isAllSameNum ? "\n" : ""));
		
		// 채워진 종이 내부 숫자 확인
		if(isAllSameNum == true) {
			switch (num) {
			case -1:
				cntMinus++;
				break;
			case 0:
				cntZero++;
				break;
			case 1:
				cntPlus++;
				break;
			default:
				break;
			}
			return;
		}
		
		// 조건2
		for(int horizontal=0; horizontal<size; horizontal += size/3) {
			for(int vertical=0; vertical<size; vertical += size/3) {
			
				// 주어진 size에서 9개(3x3)로 종이를 나누어(size/3) 재귀호출
				System.out.println("\n" + horizontal + " " + vertical + ">>" + size);
				int newSize = size/3;
				int[][] newPaper = new int[newSize][newSize];
				for(int i=0; i<newSize; i++) {
					for(int j=0; j<newSize; j++) {
							newPaper[i][j] = paper[i+horizontal][j+vertical];
							System.out.print(paper[i+horizontal][j+vertical] + " ");
					}
					System.out.println("");
				}
				System.out.println(">>재귀");
				dividePaper(newPaper, newSize);
			}
			
		}
	}
	
}


// 제출코드

//import java.util.*;
//
//public class Main {
//
//	static int cntMinus = 0;
//	static int cntZero = 0;
//	static int cntPlus = 0;
//	
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int n = sc.nextInt();
//		
//		int[][] oiginalPaper = new int[n][n];
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				oiginalPaper[i][j] = sc.nextInt(); 
//			}
//		}
//		sc.close();
//		
//		// 종이의 개수 카운트 시작
//		dividePaper(oiginalPaper, n);
//		
//		System.out.println(cntMinus);
//        System.out.println(cntZero);
//        System.out.println(cntPlus);
//	}
//
//	
//	// divide and conquer
//	private static void dividePaper(int[][] paper, int size) {
//		// 조건1
//		int num = paper[0][0];
//		boolean isAllSameNum = true;
//		
//		// 자른 종이 내부가 모두 같은 수 인지 탐색
//		loop:
//		for(int i=0; i<size; i++) {
//			for(int j=0; j<size; j++) {
//				if(paper[i][j] != num) {
//					isAllSameNum = false;
//					break loop;
//				}
//			}
//		}
//		// true면 재귀호출 반환, false면 조건2 검사
//		
//		// 채워진 종이 내부 숫자 확인
//		if(isAllSameNum == true) {
//			switch (num) {
//			case -1:
//				cntMinus++;
//				break;
//			case 0:
//				cntZero++;
//				break;
//			case 1:
//				cntPlus++;
//				break;
//			default:
//				break;
//			}
//			return;
//		}
//		
//		// 조건2
//		for(int horizontal=0; horizontal<size; horizontal += size/3) {
//			for(int vertical=0; vertical<size; vertical += size/3) {
//			
//				// 주어진 size에서 9개(3x3)로 종이를 나누어(size/3) 재귀호출
//				int newSize = size/3;
//				int[][] newPaper = new int[newSize][newSize];
//				for(int i=0; i<newSize; i++) {
//					for(int j=0; j<newSize; j++) {
//							newPaper[i][j] = paper[i+horizontal][j+vertical];
//					}
//				}
//				dividePaper(newPaper, newSize);
//			}
//			
//		}
//	}
//	
//}