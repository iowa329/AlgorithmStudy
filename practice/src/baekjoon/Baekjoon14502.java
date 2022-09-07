package baekjoon;

import java.util.*;

// 연구실 한칸
class Lab {
	int x;
	int y;
	
	public Lab(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class Baekjoon14502 {
	
	static Scanner sc = new Scanner(System.in);
	
	static int n = sc.nextInt();
	static int m = sc.nextInt();
	
	static int[][] map = new int[n][m];
	
	static int maxSafeArea = 0;
	
	public static void main(String[] args) {
		// 입력값 받기
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
			map[i][j] = sc.nextInt();
			}
		}
		sc.close();
		
		// 방역 시작
		prevention();
		// 방역결과 안전영역 최대값 출력
		System.out.println(maxSafeArea);
	}
	
	private static void prevention() {
		// 벽을 세우고 내부 함수에서 바이러스를 퍼트린다
		makeWall(0);
	}
	
	// DFS 3개의 벽 세우기
	private static void makeWall(int depth) {
		// 3개의 벽을 다 세운경우
		if(depth == 3) {
			spreadVirus();
			
			return;
		}
		
		// map 전체 탐색
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 0) {
					map[i][j] = 1;
					makeWall(depth+1);
					
					map[i][j] = 0; 
				}
			}
		}
	}
	
	// BFS 세운 벽을 기준으로 바이러스 퍼트리기
	private static void spreadVirus() {
		// 바이러스가 있는 곳(2)을 찾아 큐에 추가
		Queue<Lab> que = new LinkedList<Lab>();
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 2) {
					que.add(new Lab(i, j));
				}
			}
		}

		// 기본 map배열 정보를 건드리지 않고 복사본으로 작업
        int mapCopy[][] = new int[n][m];
        // *** 2차원 배열의 x값에는 y배열의 주소가 들어있기 때문에 이런식으로 deep copy를 해야한다 *** //
        for (int i = 0; i < n; i++) {
            mapCopy[i] = map[i].clone();
        }
		
		// 현재배열(복사) 중간확인
		for(int a=0; a<n; a++) {
			for(int b=0; b<m; b++) {
				System.out.print(mapCopy[a][b] + " ");
			}
			System.out.println();
		}

		// 상하좌우 배열탐색 정의
		int[] sideX = {0, 0, 1, -1};
		int[] sideY = {-1, 1, 0, 0};
		
		// 바이러스가 있는 큐를 기준으로 바이러스를 퍼트리기 
		while(que.isEmpty() == false) {
			Lab currentLab = que.poll();
			
			// 상하좌우 바이러스 전파
			for(int i=0; i<4; i++) {
				int moveX = currentLab.x + sideX[i];
				int moveY = currentLab.y + sideY[i];
				
				// 연구실 범위 안에 있는 경우
				if( moveX >= 0 && moveX < n &&
					moveY >= 0 && moveY < m ) {
					if(mapCopy[moveX][moveY] == 0) {
						mapCopy[moveX][moveY] = 2;
						que.add(new Lab(moveX, moveY));
					}
				}
			}
		}
		
		countSafeArea(mapCopy);
	}
	
	// 안전영역 크기 구하기
	private static void countSafeArea(int[][] mapResult) {
		int safeArea = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(mapResult[i][j] == 0) {
					safeArea++;
				}
			}
		}
		
		maxSafeArea = safeArea > maxSafeArea ? safeArea : maxSafeArea;
		
		System.out.println("중간결과 : " + maxSafeArea + "\n");
	}
	
}


// 제출 코드
//import java.util.*;
//
////연구실 한칸
//class Lab {
//	int x;
//	int y;
//	
//	public Lab(int x, int y) {
//		this.x = x;
//		this.y = y;
//	}
//}
//
//public class Main {
//	
//	static Scanner sc = new Scanner(System.in);
//	
//	static int n = sc.nextInt();
//	static int m = sc.nextInt();
//	
//	static int[][] map = new int[n][m];
//	
//	static int maxSafeArea = 0;
//	
//	public static void main(String[] args) {
//		// 입력값 받기
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//			map[i][j] = sc.nextInt();
//			}
//		}
//		sc.close();
//		
//		// 방역 시작
//		prevention();
//		// 방역결과 안전영역 최대값 출력
//		System.out.println(maxSafeArea);
//	}
//	
//	private static void prevention() {
//		// 벽을 세우고 내부 함수에서 바이러스를 퍼트린다
//		makeWall(0);
//	}
//	
//	// DFS 3개의 벽 세우기
//	private static void makeWall(int depth) {
//		// 3개의 벽을 다 세운경우
//		if(depth == 3) {
//			spreadVirus();
//			
//			return;
//		}
//		
//		// map 전체 탐색
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				if(map[i][j] == 0) {
//					map[i][j] = 1;
//					makeWall(depth+1);
//					
//					map[i][j] = 0; 
//				}
//			}
//		}
//	}
//	
//	// BFS 세운 벽을 기준으로 바이러스 퍼트리기
//	private static void spreadVirus() {
//		// 바이러스가 있는 곳(2)을 찾아 큐에 추가
//		Queue<Lab> que = new LinkedList<Lab>();
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				if(map[i][j] == 2) {
//					que.add(new Lab(i, j));
//				}
//			}
//		}
//
//		// 기본 map배열 정보를 건드리지 않고 복사본으로 작업
//     int mapCopy[][] = new int[n][m];
//      // *** 2차원 배열의 x값에는 y배열의 주소가 들어있기 때문에 이런식으로 deep copy를 해야한다 *** //
//     for (int i = 0; i < n; i++) {
//         mapCopy[i] = map[i].clone();
//     }
//
//		// 상하좌우 배열탐색 정의
//		int[] sideX = {0, 0, 1, -1};
//		int[] sideY = {-1, 1, 0, 0};
//		
//		// 바이러스가 있는 큐를 기준으로 바이러스를 퍼트리기 
//		while(que.isEmpty() == false) {
//			Lab currentLab = que.poll();
//			
//			// 상하좌우 바이러스 전파
//			for(int i=0; i<4; i++) {
//				int moveX = currentLab.x + sideX[i];
//				int moveY = currentLab.y + sideY[i];
//				
//				// 연구실 범위 안에 있는 경우
//				if( moveX >= 0 && moveX < n &&
//					moveY >= 0 && moveY < m ) {
//					if(mapCopy[moveX][moveY] == 0) {
//						mapCopy[moveX][moveY] = 2;
//						que.add(new Lab(moveX, moveY));
//					}
//				}
//			}
//		}
//		
//		countSafeArea(mapCopy);
//	}
//	
//	// 안전영역 크기 구하기
//	private static void countSafeArea(int[][] mapResult) {
//		int safeArea = 0;
//		
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<m; j++) {
//				if(mapResult[i][j] == 0) {
//					safeArea++;
//				}
//			}
//		}
//		
//		maxSafeArea = safeArea > maxSafeArea ? safeArea : maxSafeArea;
//	}
//	
//}