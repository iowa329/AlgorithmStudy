package baekjoon;

import java.io.*;
import java.util.*;

// 나무 재테크
public class Baekjoon16235 {

	static class Land {
		ArrayList<Tree> trees;
		int energy;
		Queue<Tree> deadTrees;
		
		public Land(ArrayList<Tree> trees, int energy, Queue<Tree> deadTrees) {
			this.trees = trees;
			this.energy = energy;
			this.deadTrees = deadTrees;
		}
		
		@Override
		public String toString() {
			return String.format("(%d, %d) %d", this.trees.get(0).age, this.energy, this.deadTrees.size());
		}
	}
	
	static class Tree {
		int age;
		
		public Tree(int age) {
			this.age = age;
		}
		
		@Override
		public String toString() {
			return String.format("%d", this.age);
		}
	}
	
	// 구현, 자료 구조(큐 Queue, 스택 Stack, ArrayList), 시뮬레이션
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(strTkr.nextToken());
		int m = Integer.parseInt(strTkr.nextToken());
		int k = Integer.parseInt(strTkr.nextToken());
		
		// 땅 정보 초기화 및 에너지 정보 입력받기
		Land[][] a = new Land[n+1][n+1];
		int[][] energyInfo = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			strTkr = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				a[i][j] = new Land(new ArrayList<>(), 5, new LinkedList<>());
				energyInfo[i][j] = Integer.parseInt(strTkr.nextToken());
			}
		}
		
		// 상도가 심은 나무의 정보
		for(int i=1; i<=m; i++) {
			strTkr = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(strTkr.nextToken());
			int y = Integer.parseInt(strTkr.nextToken());
			int z = Integer.parseInt(strTkr.nextToken());
			
			a[x][y].trees.add(new Tree(z));
		}
		br.close();
		
		// 나무 재테크 시작
		int year = 0;
		while(year < k) {
			// 1. 봄
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					Land land = a[i][j];
					ArrayList<Tree> trees = land.trees;
					
					// 나이 어린순으로 오름차순 정렬
//					Collections.sort(trees, (o1, o2) -> o1.age - o2.age);
					
					// <-- 여기서 시간초과
					// 사실상 나무는 '입력으로 주어지는 나무의 위치는 모두 서로 다름'이라는 조건이 있기에 처음에 들어온 나무의 나이가 가장 많을 수 밖에 없다
					// 그러므로 정렬을 하는 대신 stack이나 가장 뒤에서 부터 탐색한다면 사실상 나이 어린 순으로 소비를 할 수 있게 된다
					
					// 양분 먹기(끝에서 부터 실행 = 나이 어린 순)
					for(int t=trees.size()-1; t>=0; t--) {
						Tree tree = trees.get(t);
						// 자기 나이만큼 먹을 충분한 양분이 있다면
						if(land.energy - tree.age >= 0) {
							// 양분 소모
							land.energy -= tree.age;
							tree.age++;
						} else {
							// 충분한 양분이 없다면 해당 나무는 즉시 죽는다
							trees.remove(t);
							land.deadTrees.add(tree);
						}
					}
					
					// 2. 여름
					Queue<Tree> deadTrees = land.deadTrees;
					while(!deadTrees.isEmpty())
						land.energy += deadTrees.poll().age / 2;
				}
			}
			
			// 3. 가을
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					Land land = a[i][j];
					
					for(int t=0; t<land.trees.size(); t++) {
						Tree tree = land.trees.get(t);
						// 나이가 5의 배수인 나무가 있다면 인접한 8개 칸으로 번식
						if(tree.age % 5 == 0) {
							int startX = i-1;
							int startY = j-1;
							
							// 인접한 8칸 순회
							for(int rangeX=startX; rangeX<startX+3; rangeX++) {
								for(int rangeY=startY; rangeY<startY+3; rangeY++) {
									// 자기 자신 제외
									if(rangeX == i && rangeY == j)
										continue;
									
									// 상고의 땅 범위 안에 있다면
									if(1<= rangeX && rangeX <= n &&
										1 <= rangeY && rangeY <= n) {
										// 나이가 1인 나무 번식
										a[rangeX][rangeY].trees.add(new Tree(1));
									}
								}
							}
						}
					}
					
					// 4. 겨울
					// 모든 땅에 양분 뿌리기
					land.energy += energyInfo[i][j];
				}
			}
			
			year++;
		}
		
		// k년 후 상도의 땅에 살아있는 나무의 개수
		int cntTree = 0;
		for(int i=1; i<=n; i++)
			for(int j=1; j<=n; j++)
				 cntTree += a[i][j].trees.size();
		
		// 결과
		System.out.println(cntTree);
	}
	
	private static void print(Land[][] a, int n) {
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				StringBuilder sb = new StringBuilder();
				sb.append("(");
				
				for(int t=0; t<a[i][j].trees.size(); t++) 
					sb.append(a[i][j].trees.get(t).toString() + " ");
				
				sb.append("/ ");
				
				sb.append(a[i][j].energy);
				
				sb.append("/ ");
				
				while(!a[i][j].deadTrees.isEmpty())
					sb.append(a[i][j].deadTrees.poll().toString() + " ");
				
				sb.append(")");
				
				System.out.print(sb + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}