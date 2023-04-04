package baekjoon;

import java.io.*;
import java.util.*;

// 합이 0인 네 정수
public class Baekjoon7453 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 같은 배열 A, B, C, D 선언
		int[] a = new int[n];
		int[] b = new int[n];
		int[] c = new int[n];
		int[] d = new int[n];
		
		// 배열 입력받기
		for(int i=0; i<n; i++) {
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			
			a[i] = Integer.parseInt(strTkr.nextToken());
			b[i] = Integer.parseInt(strTkr.nextToken());
			c[i] = Integer.parseInt(strTkr.nextToken());
			d[i] = Integer.parseInt(strTkr.nextToken());
		}
		br.close();
		
		// 배열 a,b와 c,d 경우의 수 통합
		int[] ab = new int[n*n];
		int[] cd = new int[n*n];
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				ab[(n*i)+j] = a[i] + b[j];
				cd[(n*i)+j] = c[i] + d[j];
			}
		}
		
		// 배열ab에 대응되는 배열cd에 대해 이분탐색을 위한 정렬
		Arrays.sort(cd);
		
		// ab에 대응되는 cd의 합 0이 되는 경우의 수 찾기
		long cntSum0 = 0;
		for(int value: ab) {
            // 이분탐색
			// ab의 값 value과 같은(그래야 두 합이 0이 되기 때문에) cd의 값을 찾기위해 음수(-)로 검색
			int upper = upperBound(-value, cd);
			int lower = lowerBound(-value, cd);
			
			cntSum0 += upper - lower;
		}
		
		// 결과
		System.out.println(cntSum0);
	}
	
	private static int upperBound(int targetValue, int[] searchArr) {
		int left = 0;
		int right = searchArr.length-1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(searchArr[mid] <= targetValue) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return left;
	}
	
	private static int lowerBound(int targetValue, int[] searchArr) {
		int left = 0;
		int right = searchArr.length-1;
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			if(searchArr[mid] < targetValue) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		
		return left;
	}
	
}