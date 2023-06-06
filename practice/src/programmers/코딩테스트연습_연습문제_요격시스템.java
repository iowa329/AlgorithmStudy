package programmers;

import java.util.*;

public class 코딩테스트연습_연습문제_요격시스템 {

	public static void main(String[] args) {
		int[][] targets = {{4,5},{4,8},{10,14},{11,13},{5,12},{3,7},{1,4}};
		
		System.out.println(solution(targets));
	}
	
	public static int solution(int[][] targets) {
		// 종료기준 오름차순 정렬
		Arrays.sort(targets, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});
		
		int last = targets[0][1] - 1;
		int answer = 1;
		for(int[] target: targets) {
			// 이전 요격 위치에 현재 미사일이 있다면 그냥 통과
			if(target[0] <= last && last <= target[1])
				continue;
			
			// 아닐 경우 미사일 요격 후 마지막 위치 갱신
			last = target[1] - 1;
			answer++;
		}
		
        return answer;
    }
	
}