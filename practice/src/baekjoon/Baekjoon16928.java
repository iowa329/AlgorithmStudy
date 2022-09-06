package baekjoon;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import org.graalvm.compiler.core.common.cfg.Loop;
import org.graalvm.compiler.nodes.graphbuilderconf.InvocationPlugins.InvocationPluginReceiver;

public class Baekjoon16928 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
				
		int cntLadder = sc.nextInt();
		int cntSnake = sc.nextInt();
		
		// 편의상 0번 인덱스는 제외
		int[] boardInfo = new int[100+1];
		boolean[] visited = new boolean[100+1];

		// 입력값 받기
		for(int i=0; i<cntLadder; i++) {
			int position = sc.nextInt();
			boardInfo[position] = sc.nextInt(); 
		}
		for(int i=0; i<cntSnake; i++) {
			int position = sc.nextInt();
			boardInfo[position] = -(sc.nextInt());
		}
		sc.close();

		// BFS
		int cntDice = 0;
		
		
		Queue<Player> que = new LinkedList<Player>();
		que.add(new Player(1, 0));
		visited[1] = true;
		
		while(que.isEmpty() == false) {
			Player currentPosition = que.poll();
			
			// 주사위의 경우의 수
			for(int dice = 1; dice <= 6; dice++) {
				int movePosition = currentPosition.position + dice;
				int moveCntDice = currentPosition.cntDice + 1;
				
				// 보드판 범위를 넘어서거나 이미 방문한 경우 제외
				if(movePosition > 100 ||
					visited[movePosition] == true) {
					continue;
				}
				
				// 목적지에 도착한 경우
				if(movePosition == 100) {
					System.out.println(cntDice);
					break;
				}
				
				// 보드의 정보(사다리와 뱀)를 읽어와 위치를 계산
				visited[currentPosition] = true;
				currentPosition += boardInfo[currentPosition];
				que.add(currentPosition);
			}
			
		}
	}

}

class Player {
	int position;
	int cntDice;
	
	public Player(int position, int cntDice) {
		this.position = position;
		this.cntDice = cntDice;
	}
}
