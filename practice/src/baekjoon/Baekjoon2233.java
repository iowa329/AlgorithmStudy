package baekjoon;

import java.io.*;
import java.util.*;

// 사과나무
public class Baekjoon2233 {

	// 스택(Stack), (가장 가까운)최소 공통 조상 LCA(Lowest Common Ancestor) 
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String binaryRoute = br.readLine();
		
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(strTkr.nextToken());
		int y = Integer.parseInt(strTkr.nextToken());
		br.close();
		
		// 공통조상을 찾기위한 부모노드 값 저장 배열 선언
		int[] parent = new int[n+1];
		
		// DFS형식으로 구성된 이진수 목록을 트리 정보로 변환할 스택 선언
		Stack<Integer> stack = new Stack<>();
		stack.push(0); // nullPoint 방지를 위한 최상위 부모노드 값 추가
		int[] nodeNumHistory = new int[binaryRoute.length()];
		int nodeNum = 1;
		for(int i=0; i<binaryRoute.length(); i++) {
			switch (binaryRoute.charAt(i)) {
			case '0':
				stack.push(nodeNum);
				nodeNumHistory[i] = nodeNum;
				nodeNum++;
				break;
				
			case '1':
				int curNode = stack.pop();
				parent[curNode] = stack.peek();
				nodeNumHistory[i] = curNode;
				break;

			default:
				continue;
			}
		}
		
		// 공통부모를 찾기위한 노드방문 배열 선언
		boolean[] visited = new boolean[n+1];
		int node = nodeNumHistory[x-1];
		while(node > 0) {
			visited[node] = true;
			node = parent[node];
		}
		
		// 제거해야 할 사과 노드번호 값
		int toRemoveApple = 0;
		node = nodeNumHistory[y-1];
		while(node > 0) {
			// x가 방문했던 곳이면 이 곳이 가장 가까운 공통 부모노드
			if(visited[node]) {
				toRemoveApple = node; // 이 부모노드가 (최소한의 피해로)제거해야 할 사과
				break;
			}
			
			node = parent[node];
		}
		
		// 제거해야 할 사과노드 번호의 이진수 위치(0, 1)값 작성
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<nodeNumHistory.length; i++) {
			if(nodeNumHistory[i] == toRemoveApple) {
				sb.append(i + 1 + " ");
				
				if(binaryRoute.charAt(i) == '1')
					break;
			}
		}
		
		// 결과
		System.out.println(sb.toString());
	}
	
}