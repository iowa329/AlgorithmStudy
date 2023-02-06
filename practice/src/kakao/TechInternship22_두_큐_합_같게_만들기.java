package kakao;

import java.util.*;

public class TechInternship22_두_큐_합_같게_만들기 {

	public static void main(String[] args) {
//		int[] queue1 = {3, 2, 7, 2}; int[] queue2 = {4, 6, 5, 1};
//		int[] queue1 = {1, 2, 1, 2}; int[] queue2 = {1, 10, 1, 2};
		int[] queue1 = {1, 1}; int[] queue2 = {1, 5};
		
		System.out.println(solution(queue1, queue2));
	}
	
	public static int solution(int[] queue1, int[] queue2) {
		Queue<Integer> que1 = new LinkedList<>();
		Queue<Integer> que2 = new LinkedList<>();
		
		long sum1 = 0L;
		long sum2 = 0L;
		for(int i=0; i<queue1.length; i++) {
			que1.add(queue1[i]);
			sum1 += queue1[i];
			
			que2.add(queue2[i]);
			sum2 += queue2[i];
		}
		
		// 그리디(Greedy) 알고리즘
		int cnt = 0;
		while(sum1 != sum2) {
			if(cnt >= 300_000 * 2) { // queue1, queue2의 최대길이는 각각 30만
				cnt = -1;
				break;
			}
			
			if(sum1 > sum2) {
				int pop = que1.poll();
				sum1 -= pop;
				
				que2.add(pop);
				sum2 += pop;
			} else {
				int pop = que2.poll();
				sum2 -= pop;
				
				que1.add(pop);
				sum1 += pop;
			}
			
			cnt++;
		}
		
        return cnt;
    }
	
}