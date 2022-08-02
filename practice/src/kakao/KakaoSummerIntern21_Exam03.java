package kakao;

import java.util.*;

public class KakaoSummerIntern21_Exam03 {

	public static void main(String[] args) {
		String answer = "";
		
		System.out.println("i--> " + "0 1 2 3 4 5 6 7");
		System.out.println();
		
		String[] cmd1 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		answer = solution(8, 2, cmd1);
		System.out.println(answer);
		
		System.out.println();
		
		String[] cmd2 = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z","U 1","C"};
		answer = solution(8, 2, cmd2);
		System.out.println(answer);
		
	}
	
	
	public static String solution(int n, int k, String[] cmd) {
		
		int[] arr = new int[n];
		Arrays.fill(arr, 1);
		
		int currentIndex = k;
		
		Stack<Integer> history = new Stack<>();
		
		for(int i=0; i<cmd.length; i++) {
			String[] cmds = cmd[i].split(" ");
			switch (cmds[0]) {
			case "U":
//				currentIndex -= Integer.parseInt(cmds[1]);
				
				int toMove = Integer.parseInt(cmds[1]);
				for(int move = toMove; move <= 0; move--) {
					if (arr[currentIndex] == 0) {
						toMove++;
					}
				}
				currentIndex -= toMove;
				
				break;

			case "D":
//				currentIndex += Integer.parseInt(cmds[1]);
				
				int first = Integer.parseInt(cmds[1]);
				toMove = first;
				for(int move = 0; move <= first; move++) {
					if (arr[currentIndex] == 0) {
						toMove++;
					}
				}
				currentIndex += toMove;
				
				break;
				
			case "C":
				arr[currentIndex] = 0;
				history.push(currentIndex);
				
				if (currentIndex == arr.length - 1) {
					currentIndex--;					
				} else {
					currentIndex++;
				}
				
				break;
			
			case "Z":
				arr[history.pop()] = 1;
				break;
				
			default:
				break;
			}
			
			System.out.print(currentIndex + "--> ");
			for(int num : arr) {
				System.out.print(num + " ");				
			}
			System.out.println();
			
		}
		
		
        String answer = "";
        for(int i=0; i<arr.length; i++) {
        	if (arr[i] == 1) {
        		answer += "O";        		
        	} else {
        		answer += "X";
        	}
        	
        }
        return answer;
    }
	
}
