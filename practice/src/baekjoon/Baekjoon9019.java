package baekjoon;

import java.util.*;

public class Baekjoon9019 {

	static Scanner sc = new Scanner(System.in);
	
	// 입력값 받기
	static int commands = sc.nextInt();
	
	static String[] target = new String[commands];
	static String[] goal = new String[commands];
	
	static boolean[] visited = new boolean[10000];
	
	public static void main(String[] args) {
		
		for(int i=0; i<commands; i++) {
			target[i] = sc.next();
			goal[i] = sc.next();
		}
		sc.close();
		
		// 명령어 경우의 수 탐색
//		for(int i=0; i<commands; i++) {
			System.out.println(DSLR(0));
//		}
	}

	// BFS
	private static String DSLR(int commandIndex) {
		Queue<Register> que = new LinkedList<Register>();
		que.add(new Register(target[commandIndex], ""));
		visited[Integer.parseInt(target[commandIndex])] = true;
		
		while(que.isEmpty() == false) {
			Register register = que.poll();
			
			// 목표 값과 결과가 일치하는 경우
			if(register.n == goal[0]) {
				return register.commandHistory;
			}
			
			for(int i=0; i<4; i++) {
				
				Register result = new Register(null, null);
				
				
				switch (i) {
				case 0:
					result = D(register);
					break;
				case 1:
					result = S(register);
					break;
				case 2:
					result = L(register);
					break;
				case 3:
					result = R(register);
					break;

				default:
					System.out.print("error occured.");
					break;
				}
				
				
				
				// 이미 방문한 경우
				if(visited[Integer.parseInt(result.n)] == true) {
					System.out.println("작동===> " + result.n);
					continue;
				}
				
				visited[Integer.parseInt(result.n)] = true;
				que.add(result);
				System.out.println("add=========> " + result.n);
			}
		}
		
		return "";
	}
	
	
	// D, S, L, R 함수
	private static Register D(Register target) {
		int targetInt = Integer.parseInt(target.n);
		targetInt = (targetInt * 2) % 10000;
		
		if(targetInt < 1000) {
			target.n = "0" + Integer.toString(targetInt);			
		} else {
			target.n = Integer.toString(targetInt);	
		}
		
		target.commandHistory = target.commandHistory + "D";
		
		System.out.println("resultD : " + target.n + " / " + target.commandHistory);
		
		return target;
	}
	
	private static Register S(Register target) {
		int targetInt = Integer.parseInt(target.n);
		targetInt = targetInt-1 != 0 ? targetInt-1 : 9999;
		
		target.n = Integer.toString(targetInt);
		
		if(targetInt < 1000) {
			target.n = "0" + Integer.toString(targetInt);			
		} else {
			target.n = Integer.toString(targetInt);	
		}
		
		target.commandHistory = target.commandHistory + "S";
		
		System.out.println("resultS : " + target.n + " / " + target.commandHistory);
		
		return target;
	}
	
	private static Register L(Register target) {
		char left = target.n.charAt(0);
		String targetString = target.n.substring(1);
		target.n = targetString + left;
		
		target.commandHistory = target.commandHistory + "L";
		
		System.out.println("resultL : " + target.n + " / " + target.commandHistory);
		
		return target;
	}
	
	private static Register R(Register target) {
		char right = target.n.charAt(3);
		String targetString = target.n.substring(0, 3);
		target.n = right + targetString;
		
		target.commandHistory = target.commandHistory + "R";
		
		System.out.println("resultR : " + target.n + " / " + target.commandHistory);
		
		return target;
	}
	
}

class Register {
	String n;
	String commandHistory;
	
	Register(String n, String commandHistory) {
		this.n = n;
		this.commandHistory = commandHistory;
	}
}