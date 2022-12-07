package baekjoon;

import java.io.*;

class Node5639 {
	int num;
	Node5639 left, right;
	
	Node5639(int num) {
		this.num = num;
	}
	
	// 이진 트리 삽입 함수 구현
	void addChild(int num) {
		if(num < this.num) {
			if(this.left != null)
				this.left.addChild(num);
			else
				this.left = new Node5639(num);
		} else {
			if(this.right != null)
				this.right.addChild(num);
			else
				this.right = new Node5639(num);
		}
	}
}

public class Baekjoon5639 {

	static StringBuilder sb = new StringBuilder();
	
	// 이진트리
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Node5639 root = new Node5639(Integer.parseInt(br.readLine()));
		
		while(true) {
			String input = br.readLine();
			
			// 입력값이 없는 경우 while문 종료
			if(input == null || input.equals(""))
				break;
			
			// 이진트리 삽입 실행
			int num = Integer.parseInt(input);
			root.addChild(num);
		}
		br.close();
		
		// root부터 리프노드까지 재귀적으로 탐색
		postOrder(root);
		
		// 결과
		System.out.println(sb.toString());
	}
	
	// 후위 순회
	private static void postOrder(Node5639 node) {
		if(node == null)
			return;
		
		postOrder(node.left);
		postOrder(node.right);
		
		sb.append(node.num + "\n");
	}
	
}