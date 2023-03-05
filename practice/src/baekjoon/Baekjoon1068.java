package baekjoon;

import java.io.*;
import java.util.*;

// 트리 1068번
public class Baekjoon1068 {
	
	static ArrayList<ArrayList<Integer>> childList = new ArrayList<>();
	static int cntLeafNodes = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 트리의 노드 개수
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++)
			childList.add(new ArrayList<Integer>());
		
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		
		// 각 노드의 부모정보 입력받기
		int rootNode = -1;
		for(int i=0; i<n; i++) {
			int parentNode = Integer.parseInt(strTkr.nextToken());
			if(parentNode == -1) {
				rootNode = i;
			} else {
				childList.get(parentNode).add(i);
			}
		}
		
		// 지울 노드 번호
		int m = Integer.parseInt(br.readLine());
		br.close();
		
		// 노드 삭제 후 남은 리프노드 개수파악 
		if(m != rootNode) {
			removeNode(m);
			findLeafNode(childList.get(rootNode));
		}
		
		// 결과
		System.out.println(cntLeafNodes);
	}
	
	// 대상 노드 연결 끊기
	private static void removeNode(int targetNode) {
		for(int i=0; i<childList.size(); i++) {
			for(int j=0; j<childList.get(i).size(); j++) {
				if(childList.get(i).get(j) == targetNode) {
					childList.get(i).remove(j);
					return;
				}
			}
		}
	}
	
	private static void findLeafNode(ArrayList<Integer> targetChildList) {
		// 루투노드만 남는 경우
		if(targetChildList.size() == 0) {
			cntLeafNodes++;
			return;
		}
		
		// 하위 노드 탐색
		for(int node: targetChildList) {
			if(childList.get(node).size() == 0) {
				cntLeafNodes++;
			} else {
				findLeafNode(childList.get(node));
			}
		}
	}
	
}