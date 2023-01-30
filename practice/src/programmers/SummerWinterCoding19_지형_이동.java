package programmers;

import java.util.*;

public class SummerWinterCoding19_지형_이동 {

	public static void main(String[] args) {
//		int[][] land = {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}}; int height = 3;
		int[][] land = {{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}}; int height = 1;
		
		System.out.print(solution(land, height));
	}
	
	static class Ladder {
		int start, end, cost;
		
		public Ladder(int start, int end, int cost) {
			this.start = start;
			this.end = end;
			this.cost = cost;
		}
	}
	
	static class Land {
		int x, y;
		
		public Land(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	static int n;
	static int[][] groups;
	
	// 상하좌우 배열 정의
	static int[] moveX = {-1, 1, 0, 0};
	static int[] moveY = {0, 0, -1, 1};
	
	static int[] parent;
	
	public static int solution(int[][] land, int height) {
		// 1. BFS로 영역 그룹짓기
		n = land.length;
        groups = new int[n][n];
        
        int groupIndex = 1;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(groups[i][j] == 0) {
					grouping(i, j, land, height, groupIndex);
					groupIndex++;
				}
			}
		}
        
		// 2. 그룹 간 놓을 수 있는 사다리 목록 구성
		ArrayList<Ladder> ladders = new ArrayList<>();
		for(int x=0; x<n; x++) {
			for(int y=0; y<n; y++) {
				for(int move=0; move<4; move++) {
					int movedX = x + moveX[move];
					int movedY = y + moveY[move];
					
					// 배열 범위 안만 검사
					if(0 <= movedX && movedX < n &&
						0 <= movedY && movedY < n) {
						int group1 = groups[x][y];
						int group2 = groups[movedX][movedY];

						// 두 land가 다른 그룹이라면
						if(group1 != group2) {
							// 사다리를 놓을 수 있다
							ladders.add(new Ladder(group1, group2, Math.abs(land[x][y] - land[movedX][movedY])));
						}
					}
				}
			}
		}
		Collections.sort(ladders, new Comparator<Ladder>() {
			@Override
			public int compare(Ladder ladder1, Ladder ladder2) {
				return ladder1.cost - ladder2.cost;
			}
		});
		
		// 3. 비용기준 오름차순 정렬된 사다리로 사다리 최소설치 비용 구하기(크루스칼, 최소스패닝트리(MST), 유니온파인드(UnionFind) 알고리즘)
		// 부모노드 저장 배열 초기화
		parent = new int[groupIndex];
		for(int i=0; i<groupIndex; i++)
			parent[i] = i;
		
		int answer = 0;
		int cntLadder = 0;
		for(Ladder ladder: ladders) {
			int rootGroupStart = findParent(ladder.start);
			int rootGroupEnd= findParent(ladder.end);
			
			// Union Find
			if(rootGroupStart != rootGroupEnd) {
				parent[rootGroupEnd] = rootGroupStart;
				answer += ladder.cost;
				
				cntLadder++;
			}
			
			// 최소비용으로 놓을 수 있는 사다리 개수는 group-1(ex. n개의 정점에 대한 간선 n-1개) 
			if(cntLadder >= groupIndex-2) // 비용(cost) 기준 오름차순 정렬이므로 사다리 개수에 도달할 경우 바로 종료
				break;
		}
		
        return answer;
    }
	
	// BFS
	private static void grouping(int x, int y, int[][] land, int height, int groupIndex) {
		Queue<Land> que = new LinkedList<>();
		que.add(new Land(x, y));
		
		while(que.isEmpty() == false) {
			Land curLand = que.poll();
			groups[curLand.x][curLand.y] = groupIndex;
			
			for(int move=0; move<4; move++) {
				int movedX = curLand.x + moveX[move];
				int movedY = curLand.y + moveY[move];
				
				// 배열 범위 안만 검사
				if(0 <= movedX && movedX < n &&
					0 <= movedY && movedY < n) {
					
					// 그룹짓지 않았고 두 사다리의 격차가 기준 height 이하라면
					if(groups[movedX][movedY] == 0 &&
						Math.abs(land[curLand.x][curLand.y] - land[movedX][movedY]) <= height) {
						
						groups[movedX][movedY] = groupIndex;
						que.add(new Land(movedX, movedY));
					}
				}
			}
		}
	}
	
	private static int findParent(int index) {
		if(parent[index] == index)
			return index;
		
		return parent[index] = findParent(parent[index]);
	}
	
}