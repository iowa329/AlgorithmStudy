package baekjoon;

import java.io.*;
import java.util.*;

class PersonHeight {
	int tall;
	int cnt;
	
	public PersonHeight(int tall, int cnt) {
		this.tall = tall;
		this.cnt = cnt;
	}
}

public class Baekjoon3015 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 대기줄 사람들의 키 정보 입력받기
		Stack<PersonHeight> stack = new Stack<>();
		int seeEachOther = 0;
		for(int i=0; i<n; i++) {
			
			int curTall = Integer.parseInt(br.readLine());
			PersonHeight curPerson = new PersonHeight(curTall, 1);
			// 앞에 사람이 있고 나보다 작을 때
			while(!stack.isEmpty() && stack.peek().tall <= curPerson.tall) {
				PersonHeight lastPerson = stack.pop(); // 앞사람 제외
				seeEachOther += lastPerson.cnt; // 앞사람 cnt 반영
				
				// 만약 앞사람 키와 같다면 이후 사람이 들어왔을 때 그 전에 같은 키의 사람이 몇명 있었는지 모르므로 이미 제외(pop)된 앞사람(lastPerson) cnt를 현재 사람 cnt에 반영
				if(curPerson.tall == lastPerson.tall) curPerson.cnt += lastPerson.cnt;
			}
			
			// 앞에 사람이 있을 때
			if(!stack.isEmpty()) seeEachOther++;
			stack.push(curPerson); // 줄서기
			
		}
		br.close();
		
		
		// 결과
		System.out.println(seeEachOther);
	}

}

// 시간초과 (50만 x 50만)

//public static void main(String[] args) throws IOException {
//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	int n = Integer.parseInt(br.readLine());
//	
//	// 대기줄 사람들의 키 정보 입력받기
//	int[] waitingLine = new int[n];
//	for(int i=0; i<n; i++) {
//		waitingLine[i] = Integer.parseInt(br.readLine());
//	}
//	br.close();
//	
//	int seeEachOther = 0;
//	for(int a=0; a<n-1; a++) {
//		for(int b=a+1; b<n; b++) {
//			
//			int shortestTall = Math.min(waitingLine[a], waitingLine[b]);
//			boolean isCanSeeEachOther = true;
//			// a <-> b 사이 사람들 키 탐색
//			for(int person=a+1; person <= b-1; person++) {
//				if(waitingLine[person] > shortestTall) {
//					isCanSeeEachOther = false;
//					break;
//				}
//			}
//			if(isCanSeeEachOther) {
//				System.out.println("a: " + waitingLine[a] + "  b: " + waitingLine[b]);
//				seeEachOther++;
//			}
//			
//		}
//	}
//	
//	// 결과
//	System.out.println(seeEachOther);
//}