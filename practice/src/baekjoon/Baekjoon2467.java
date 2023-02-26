package baekjoon;

import java.io.*;
import java.util.*;

// 용액
public class Baekjoon2467 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		br.close();
		
		int[] pH = new int[n];
		for(int i=0; i<n; i++)
			pH[i] = Integer.parseInt(strTkr.nextToken());
		
		// 투 포인터(two pointer)
		int left = 0;
		int right = n-1;
		
		int pHLeft = 0;
		int pHRight = 0;
		
		int min = 1_000_000_000 * 2; // 최대 주어지는 값은 1,000,000,000
		while(left < right) {
			int mix = pH[left] + pH[right];
			int mixAbs = Math.abs(mix);
			
			if(mixAbs < min) {
				min = mixAbs;
				
				pHLeft = pH[left];
				pHRight = pH[right];
			}
			
			if(min == 0)
				break;
			
			if(mix < 0) {
				left++;
			} else {
				right--;
			}
		}
		
		// 결과
		System.out.println(pHLeft + " " + pHRight);
	}
	
}