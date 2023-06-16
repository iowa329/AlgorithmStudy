package programmers;

import java.util.*;

public class 코딩테스트연습_연습문제_바탕화면_정리 {

	public static void main(String[] args) {
		String[] wallpaper = {".#...", "..#..", "...#."};
		
		System.out.println(Arrays.toString(solution(wallpaper)));
	}
	
	public static int[] solution(String[] wallpaper) {
		int minX = wallpaper.length;
		int minY = wallpaper[0].length();
		
		int maxX = 0;
		int maxY = 0;
		
		for(int i=0; i<wallpaper.length; i++) {
			for(int j=0; j<wallpaper[0].length(); j++) {
				if(wallpaper[i].charAt(j) == '#') {
					minX = Math.min(minX, i);
					minY = Math.min(minY, j);
					
					maxX = Math.max(maxX, i);
					maxY = Math.max(maxY, j);
				}
			}
		}
		
        int[] answer = { minX, minY, maxX+1, maxY+1 };
        return answer;
    }
	
}