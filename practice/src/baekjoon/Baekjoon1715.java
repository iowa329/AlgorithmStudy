package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1715 {

	// 카드 정렬하기
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// Priority Queue sort
		PriorityQueue<Long> pq = new PriorityQueue<>();
		for(int i=0; i<n; i++)
			pq.add(Long.parseLong(br.readLine()));
		br.close();
		
		long totalCntCompare = 0;
		// 비교할 카트가 최소 2장이 남을때까지 반복
		while(pq.size() >= 2) {
			long card1 = pq.poll();
			long card2 = pq.poll();
			
			long curCntCompare = card1 + card2;
			totalCntCompare += curCntCompare;
			pq.add(curCntCompare);
		}
		
		// 카드 묶음을 합쳐서 하나로 만드는 총 개수
		System.out.println(totalCntCompare);
	}
	
}