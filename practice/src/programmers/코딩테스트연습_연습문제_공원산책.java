package programmers;

import java.util.*;

public class 코딩테스트연습_연습문제_공원산책 {

	public static void main(String[] args) {
		String[] park = {"SOO","OOO","OOO"}; String[] routes = {"E 2","S 2","W 1"};
//		String[] park = {"SOO","OXX","OOO"}; String[] routes = {"E 2","S 2","W 1"};
//		String[] park = {"OSO","OOO","OXO","OOO"}; String[] routes = {"E 2","S 3","W 1"};
		
		System.out.println(Arrays.toString(solution(park, routes)));
	}
	
	public static int[] solution(String[] park, String[] routes) {
		// 상하좌우
		// E: 3, W: 2, S: 1, N: 0
		int[] moveX = {-1, 1, 0, 0};
		int[] moveY = {0, 0, -1, 1};
		
		int curX = 0;
		int curY = 0;
		
		Loop:
		for(int i=0; i<park.length; i++) {
			for(int j=0; j<park[0].length(); j++) {
				if(park[i].charAt(j) == 'S') {
					curX = i;
					curY = j;
					break Loop;
				}
			}
		}
		
		for(String route: routes) {
			int direction = 0;
			switch (route.charAt(0)) {
			case 'E':
				direction = 3;
				break;
			case 'W':
				direction = 2;
				break;
			case 'S':
				direction = 1;
				break;
			case 'N':
				direction = 0;
				break;
			}
			
			boolean isPossible = true;
			
			int tempX = curX;
			int tempY = curY;
			for(int cnt=1; cnt<=route.charAt(2) - '0'; cnt++) {
				int movedX = tempX + moveX[direction];
				int movedY = tempY + moveY[direction];
				
				if(movedX < 0 || park.length <= movedX ||
					movedY < 0 || park[0].length() <= movedY ||
					park[movedX].charAt(movedY) == 'X') {
					isPossible = false;
					break;
				}

				tempX = movedX;
				tempY = movedY;
			}
			
			if(isPossible) {
				curX = tempX;
				curY = tempY;
			}
		}
		
        int[] answer = { curX, curY };
        return answer;
    }
	
}