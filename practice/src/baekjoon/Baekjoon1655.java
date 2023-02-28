package baekjoon;

import java.io.*;
import java.util.*;

// 가운데를 말해요
public class Baekjoon1655 {

	// 우선순위 큐(Priority Queue)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pqMax = new PriorityQueue<>(Collections.reverseOrder()); // 내림차순 정렬
		PriorityQueue<Integer> pqMin = new PriorityQueue<>(); // 오름차순 정렬
		
		StringBuilder sb = new StringBuilder();
		
		// n개의 수 입력받기
		for(int i=1; i<=n; i++) {
			int num = Integer.parseInt(br.readLine());
			
			// 두 pq의 사이즈가 같다면
			if(pqMax.size() == pqMin.size()) {
				pqMax.add(num);
			} else {
				// 두 pq의 사이즈가 다르다면(pqMax가 더 크다면)
				pqMin.add(num);
			}
			
			// 정렬 최대값은 그 다음 값은 정렬 최소값보다 크다면 정렬에 위배되므로
			if(pqMax.size() > 0 && pqMin.size() > 0 &&
				pqMax.peek() > pqMin.peek()) {
				// 두 최대, 최소값 위치 swap
				int swap = pqMax.poll();
				pqMax.add(pqMin.poll());
				pqMin.add(swap);
			}
			
			// 현재 중간값(항상 pqMax가 소지) 추가
			sb.append(pqMax.peek() + "\n");
		}
		br.close();
		
		System.out.println(sb.toString());
	}
	
}