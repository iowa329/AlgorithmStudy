package baekjoon;

import java.io.*;
import java.util.*;

// 행렬 좌표 저장 클래스
class Matrix {
	int x;
	int y;
	
	public Matrix(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

// <--! core idea !--> //
// start ~ end의 길이가 mid인 numMin이상이고 numMax이하인 모든 구간에 대해 BFS 수행
// BFS의 조건은 배열의 값이 start ~ end 사이일 경우
// start ~ end인 값으로만 이동한다면 그 경로에 위치한 값들의 최대-최소는 무조건 mid값 이하
public class Baekjoon1981 {

	static int n;
	static int[][] arr;
	
	static int numMin = 201; // 배열의 각 수의 범위는 0 ~ 200
	static int numMax = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		arr = new int[n+2][n+2]; // 행렬 상하좌우 음수값 지정 바운더리 설정(+2)
		
		
		// 배열 입력받기
		for(int i=0; i<=n+1; i++) {
			// 행렬 상하좌우 바운더리 음수로 초기화
			Arrays.fill(arr[i], -1);
			
			// 배열 내부 값만 갱신
			if(i >= 1 && i <= n) {
				StringTokenizer strTkr = new StringTokenizer(br.readLine());
				for(int j=1; j<=n; j++) {
					arr[i][j] = Integer.parseInt(strTkr.nextToken());
					
					// 최소값, 최대값 찾기
					numMin = Math.min(numMin, arr[i][j]);
					numMax = Math.max(numMax, arr[i][j]);
				}				
			}
			
		}
		br.close();
		
		
		// 배열 입력 확인
		for(int i=0; i<=n+1; i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		
		
		// 차이값 최소 탐색 시작
		// 정답(차이값) 후보 중 최소값은 모든 행렬값이 같을 때(0), 최대값은 행렬 수 중 최대값-최소값 일 때
		int result = findMinDiff(0, numMax - numMin);
		
		// 결과
		System.out.println(result);
	}
	
	// 이분탐색
	private static int findMinDiff(int min, int max) {
		int result = 0;
		
		// 경로상의 최대값과 최소값의 차이(mid)기준
		while(min <= max) {
			int mid = (min + max) / 2;
			
			System.out.println(min + " " + mid + " " + max + " ");
			
			if(isAvailableRoute(mid)) {
				// mid(차이값)에 해당 하는 경로가 있다면 
				result = mid;
				max = mid -1; // 더 작은 차이값(mid)은 없는지 탐색한다
			} else {
				// mid(차이값)에 해당 하는 경로가 없다면
				min = mid + 1; // 현재 차이값(mid)보다 큰 차이값으로 범위를 수정
			}
		}
		
		return result;
	}
	
	// BFS
	private static boolean isAvailableRoute(int mid) {
		// start ~ end의 길이가 mid인 모든 경우의 수 탐색
		for(int i = numMin; i+mid <= numMax; i++) {
			int start = i;
			int end = i + mid;
			
			
			// <-- 시작지점 --> //
			// 범위 유효검사
			if(start > arr[1][1] || arr[1][1] > end) {
				continue;
			}
			
			Queue<Matrix> que = new LinkedList<Matrix>();
			boolean[][] visited = new boolean[n+2][n+2];
			
			// 방문처리
			que.add(new Matrix(1, 1));
			visited[1][1] = true;
			
			
			// <-- BFS 시작 --> //
			// 가능한 경로가 있으면 바로 true 반환으로 함수 종료
			while(que.isEmpty() == false) {
				Matrix curPos = que.poll();
				
				// 목적지(n, n)에 도착했으면
				if(curPos.x == n && curPos.y == n) {
					return true;
				}
				

				// 상하좌우 배열탐색 정의
				int[] sideX = {1, -1, 0, 0};
				int[] sideY = {0, 0, -1, 1};
				
				// 상하좌우 탐색
				for(int cases = 0; cases < 4; cases++) {
					int movedX = curPos.x + sideX[cases];
					int movedY = curPos.y + sideY[cases];
					
					int arrValue = arr[movedX][movedY];
					if(arrValue != -1 && // 경계밖이 아니고
							visited[movedX][movedY] == false && // 방문하지 않았고
							start <= arrValue && arrValue <= end) { // 행렬 값이 탐색 범위 안에 든다면 이동할 수 있다
						que.add(new Matrix(movedX, movedY));
						visited[movedX][movedY] = true;
					}
				}
			}
		}
		
		return false;
	}
	
}