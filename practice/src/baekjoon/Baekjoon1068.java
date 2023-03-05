package baekjoon;

import java.io.*;
import java.util.*;

// 트리 1068번
public class Baekjoon1068 {
	
	static ArrayList<Integer>[] childList;
	static int cntLeafNodes = 0;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 트리의 노드 개수
		int n = Integer.parseInt(br.readLine());
		childList = new ArrayList[n];
		for(int i=0; i<n; i++) {
			childList[i] = new ArrayList<Integer>();
		}
		
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		
		// 각 노드의 부모정보 입력받기
		int rootNode = -1;
		for(int i=0; i<n; i++) {
			int parentNode = Integer.parseInt(strTkr.nextToken());
			if(parentNode == -1) {
				rootNode = i;
			} else {
				childList[parentNode].add(i);
			}
		}
		
		// 지울 노드 번호
		int m = Integer.parseInt(br.readLine());
		br.close();
		
		// 노드 삭제 후 남은 리프노드 개수파악 
		if(m != rootNode) {
			removeNode(m);
			findLeafNode(childList[rootNode]);
		}
		
		for(ArrayList<Integer> list: childList)
			System.out.println(list.toString());
		
		
		// 결과
		System.out.println(cntLeafNodes);
	}
	
	// 대상 노드 연결 끊기
	private static void removeNode(int targetNode) {
		for(int i=0; i<childList.length; i++) {
			for(int j=0; j<childList[i].size(); j++) {
				if(childList[i].get(j) == targetNode) {
					childList[i].remove(j);
					return;
				}
			}
		}
	}
	
	private static void findLeafNode(ArrayList<Integer> targetChildList) {
		for(int node: targetChildList) {
			if(childList[node].size() == 0) {
				cntLeafNodes++;
			} else {
				findLeafNode(childList[node]);
			}
		}
	}
	
}