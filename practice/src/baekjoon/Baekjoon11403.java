package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon11403 {

	// 플로이드–워셜 알고리즘
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		// 그래프의 인접행렬 값 받기
		int[][] matrix = new int[n][n];
		for(int i=0; i<n; i++) {
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				matrix[i][j] = Integer.parseInt(strTkr.nextToken());
			}
		}
		br.close();
		
		// 특정 경유지에 대한 경로유무를 모두 탐색하여 있으면 값을 갱신
		for(int transferIndex=0; transferIndex<n; transferIndex++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(matrix[i][transferIndex] == 1 && matrix[transferIndex][j] == 1) {
						matrix[i][j] = 1;
					}
				}
			}
		}
		
		// 결과 값 출력
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				sb.append(matrix[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
}