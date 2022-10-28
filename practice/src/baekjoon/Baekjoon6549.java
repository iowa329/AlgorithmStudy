package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon6549 {

	static int[] histogram;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		while(true) {
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(strTkr.nextToken());
			
			// 0을 만날시 종료
			if(n == 0) break;
			
			// 히스토그램 정보 입력받기
			histogram = new int[n]; 
			for(int i=0; i<n; i++) {
				histogram[i] = Integer.parseInt(strTkr.nextToken());				
			}
			
			// 가장 넓이가 큰 직사각형 찾기
			sb.append(findMaxArea(n) + "\n");
		}
		
		br.close();

		// 결과
		System.out.println(sb);
	}

	// stack
	public static long findMaxArea(int n) {
		// histogram index값을 저장할 stack 선언
		Stack<Integer> stack = new Stack<>();
		long maxArea = 0;
		
		for(int i=0; i<n; i++) {
			while(!stack.isEmpty() && histogram[i] <= histogram[stack.peek()]) { // 현재 높이가 이전 높이보다 작아질 경우 maxArea 경우의 수 반복계산
				// 이전 막대의 높이
				int beforeHieghtIndex = stack.pop();
				int height = histogram[beforeHieghtIndex]; // 현재 막대가 이전 막대의 높이보다 작을 경우(지금 while문 안으로 들어온 경우) 현재 막대로 가질 수 있는 최대 높이(height)는 현재 높이(stack.pop())다 
				long width = stack.isEmpty() ? i : beforeHieghtIndex - stack.peek(); // i-1은 이전 막대 histogram 인덱스 값
				
				maxArea = Math.max(maxArea, width*height);
			} // stack이 빌때까지 반복 후 빠져나온다
			
			stack.push(i); // 현재 막대 값 입력
		}
		
		// for문 이후 while문(모든 stack을 소진하는) 안으로 들어가지 못해 남아있는 stack들에 대해서도 maxArea 경우의 수 반복계산 수행
		while(!stack.isEmpty()) {
			int height = histogram[stack.pop()];
			long width = stack.isEmpty() ? n : (n-1) - stack.peek();

			maxArea = Math.max(maxArea, width*height);
		}
		
		return maxArea;
	}
	
}