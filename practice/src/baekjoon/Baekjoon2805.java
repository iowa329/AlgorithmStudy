package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon2805 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(strTkr.nextToken());
		int m = Integer.parseInt(strTkr.nextToken()); // m의 범위 유의
		
		int[] trees = new int[n];
		
		long min = 1;
		long max = 0;
		// 나무 길이 입력받기
		strTkr = new StringTokenizer(br.readLine());
		for (int i=0; i<n; i++) {
			trees[i] = Integer.parseInt(strTkr.nextToken());
			
			// 최대값 찾기
			if(trees[i] > max) {
				max = trees[i];
			}
		}
		br.close();

		
		// 이분탐색
		while(min <= max) { // 최소 길이가 최대 길이를 넘어설 경우 종료
			long totalLength = 0;
			int mid = (int)((min + max) / 2);
			
			for(int i=0; i<n; i++) {
				long afterCut = trees[i] - mid;
				totalLength += afterCut < 0 ? 0 : afterCut; // 절단기 높이가 나무보다 높으면 (잘린게 없으므로) 음수 대신 0을 반환
			}
			
			System.out.println(min + " " + mid + " " + max + " "+ totalLength + " ");
			
			if(totalLength < m) { // 필요한 길이보다 부족한 경우
				max = mid - 1; // 절단기 최대 높이를 줄여 잘린 나무를 길게 한다
			} else {
				// 필요길이 이상일 경우
				min = mid + 1; // 절단기 최소 높이를 올려 잘린 나무를 짧게 한다
			}
		}
		
		// 결과
		System.out.println(max);
	}

}