package baekjoon;

import java.util.*;

// 3개의 돌에 대한 그룹 클래스 정의
class Stone {
    int a;
    int b;
    int c;
	
    public Stone(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}

public class Baekjoon12886 {

	public static void main(String[] args) {
		
		// 입력값 받기
		Scanner sc = new Scanner(System.in);
		
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		
		sc.close();
		
		// 돌 게임 시작
		System.out.println(stoneGame(A, B, C));
	}
	
	// BFS
	private static int stoneGame(int a, int b, int c) {
		
		// 세 돌의 합이 3으로 나누어지지 않는 것은 서로를 같은 수로 만들 수 없다는 것을 의미
		if ((a+b+c) % 3 != 0) {
			return 0;
		}
		
		// 돌 A, B, C의 범위는 1<=500으로 제한되어 있다(500 * 돌 3개 +1(인덱스0))
		// 방문 배열이 2차원인 이유는 전체 돌의 개수는 변하지 않으므로(x+x, y-x -> x,y 보존) 2개의 정보값 알아도 나머지 하나의 돌의 개수를 알 수 있다
		boolean[][] visited = new boolean[1501][1501];
		
		Queue<Stone> que = new LinkedList<Stone>();
		que.add(new Stone(a, b, c));
		visited[a][b] = true;
		
		
		while(que.isEmpty() == false) {
			Stone s = que.poll();
			a = s.a;
            b = s.b;
            c = s.c;
			
			// 돌이 전부 같을 경우
			if(a == b && b == c) {
				return 1;
			}
			
			// 돌 a, b, c의 그룹 경우의 수는 'a,b / b,c / a,c' 세 가지이다
			if(a != b) {
				int newA = a < b ? a+a : a-b;
				int newB = b < a ? b+b : b-a;
				
				if(visited[newA][newB] == false) {
					que.add(new Stone(newA, newB, c));
					visited[newA][newB] = true;
				}
			}
			
			if(b != c) {
				int newB = b < c ? b+b : b-c;
				int newC = c < b ? c+c : c-b;
				
				if(visited[newB][newC] == false) {
					que.add(new Stone(a, newB, newC));
					visited[newB][newC] = true;
				}
			}
			
			if (a != c) {
                int newA = a < c ? a+a : a-c;
                int newC = c < a ? c+c : c-a;
				
                if (visited[newA][newC] == false) {
                    que.add(new Stone(newA, b, newC));
                    visited[newA][newC] = true;
                }
            }
		}
		
		return 0;
	}

}


// 제출 코드

//import java.util.*;
//
////3개의 돌에 대한 그룹 클래스 정의
//class Stone {
// int a;
// int b;
// int c;
//	
// public Stone(int a, int b, int c) {
//     this.a = a;
//     this.b = b;
//     this.c = c;
// }
//}
//
//public class Main {
//
//	public static void main(String[] args) {
//		
//		// 입력값 받기
//		Scanner sc = new Scanner(System.in);
//		
//		int A = sc.nextInt();
//		int B = sc.nextInt();
//		int C = sc.nextInt();
//		
//		sc.close();
//		
//		// 돌 게임 시작
//		System.out.println(stoneGame(A, B, C));
//	}
//	
//	// BFS
//	private static int stoneGame(int a, int b, int c) {
//		
//		// 세 돌의 합이 3으로 나누어지지 않는 것은 서로를 같은 수로 만들 수 없다는 것을 의미
//		if ((a+b+c) % 3 != 0) {
//			return 0;
//		}
//		
//		// 돌 A, B, C의 범위는 1<=500으로 제한되어 있다(500 * 돌 3개 +1(인덱스0))
//		// 방문 배열이 2차원인 이유는 전체 돌의 개수는 변하지 않으므로(x+x, y-x -> x,y 보존) 2개의 정보값 알아도 나머지 하나의 돌의 개수를 알 수 있다
//		boolean[][] visited = new boolean[1501][1501];
//		
//		Queue<Stone> que = new LinkedList<Stone>();
//		que.add(new Stone(a, b, c));
//		visited[a][b] = true;
//		
//		
//		while(que.isEmpty() == false) {
//			Stone s = que.poll();
//			a = s.a;
//         b = s.b;
//         c = s.c;
//			
//			// 돌이 전부 같을 경우
//			if(a == b && b == c) {
//				return 1;
//			}
//			
//			// 돌 a, b, c의 그룹 경우의 수는 'a,b / b,c / a,c' 세 가지이다
//			if(a != b) {
//				int newA = a < b ? a+a : a-b;
//				int newB = b < a ? b+b : b-a;
//				
//				if(visited[newA][newB] == false) {
//					que.add(new Stone(newA, newB, c));
//					visited[newA][newB] = true;
//				}
//			}
//			
//			if(b != c) {
//				int newB = b < c ? b+b : b-c;
//				int newC = c < b ? c+c : c-b;
//				
//				if(visited[newB][newC] == false) {
//					que.add(new Stone(a, newB, newC));
//					visited[newB][newC] = true;
//				}
//			}
//			
//			if (a != c) {
//             int newA = a < c ? a+a : a-c;
//             int newC = c < a ? c+c : c-a;
//				
//             if (visited[newA][newC] == false) {
//                 que.add(new Stone(newA, b, newC));
//                 visited[newA][newC] = true;
//             }
//         }
//		}
//		
//		return 0;
//	}
//
//}