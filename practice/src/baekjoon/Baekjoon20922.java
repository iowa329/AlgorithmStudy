package baekjoon;

import java.io.*;
import java.util.*;

// 겹치는 건 싫어
public class Baekjoon20922 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(strTkr.nextToken());
		int k = Integer.parseInt(strTkr.nextToken());
		
		strTkr = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(strTkr.nextToken());
		}
		br.close();
		
		int[] duplicate = new int[100_000+1]; // 주어지는 수의 범위는 1~10만 사이
		
		// 투 포인터(two pointer)
		int left = 0;
		int right = 0;
		int maxSubsequence = 0;
		while(left <= right) {
			// 종료조건: 주어진 수열 끝에 도착했을 때
			if(right >= n) {
				// 마지막 부분수열 길이 최대값 최종점검
				maxSubsequence = Math.max(maxSubsequence, right-left);
				break;
			}
				
			// 현 위치의 수열이 k개 이하로 반복되었을 때
			if(duplicate[arr[right]]+1 <= k) {
				duplicate[arr[right]]++;
				right++; // 다음 탐색
			} else {
				// k개 이상 중복될 때
				maxSubsequence = Math.max(maxSubsequence, right-left);
				duplicate[arr[left]]--;
				left++; // 중복되는 수열(arr[right])이 나타날 때까지 오른쪽(left++)으로 수열범위 감소
			}
		}
		
		System.out.println(maxSubsequence);
	}
	
}