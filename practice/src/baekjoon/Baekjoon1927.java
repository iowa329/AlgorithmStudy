package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1927 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=1; i<=n; i++) {
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) {
				int print = 0;
				if(pq.isEmpty() == false) print = pq.poll();
				System.out.println(print);
			} else {
				pq.add(x);
			}
			
			System.out.println(Arrays.deepToString(pq.toArray()) + "\n");
		}
		br.close();
	}
	
}