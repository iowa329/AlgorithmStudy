package kakao;

import java.io.*;
import java.util.*;

public class BlindRecruitment23_미로_탈출_명령어 {

	public static void main(String[] args) {
		String result = solution(3, 4, 2, 3, 3, 1, 5);
		
		System.out.println(result);
	}
	
	public static String solution(int n, int m, int x, int y, int r, int c, int k) {
		String answer = "impossible";
		
		int distance = Math.abs(x-r) + Math.abs(y-c);
		
		// 정답이 impossible인 경우 두가지
		if(k < distance) { // 1. 주어진 k가 시작점과 도착점 거리보다 짧을때
			return answer;
		} else if((distance-k) % 2 == 1) { // 2. 거리에서 k를 빼고(도착하고) 홀수 일때(왔다갔다 하면서 다시 도착점에 올 수 없으므로)
			return answer;
		}
		
		// 사전 순으로 정렬 d, l, r, u (하좌우상)
		
        
        return answer;
    }
}
