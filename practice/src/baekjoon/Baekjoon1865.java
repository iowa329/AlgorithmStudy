package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1865 {

	static final int MAX_ROAD_LENGTH = 10000 * 500 + 1; // T의 최대값 * N개 지점 최대 개수

	// 1. 플로이드–워셜 알고리즘 방법
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(br.readLine()); // 테스트 케이스
		
		StringBuilder sb = new StringBuilder();
		for(int testCase=1; testCase<=TC; testCase++) {
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(strTkr.nextToken()); // 지점의 수
			int M = Integer.parseInt(strTkr.nextToken()); // 도로의 개수
			int W = Integer.parseInt(strTkr.nextToken()); // 웜홀의 개수
			
			int[][] roads = new int[N+1][N+1];
			for(int[] road: roads)
				Arrays.fill(road, MAX_ROAD_LENGTH);
			
			for(int i=1; i<=M; i++) {
				strTkr = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(strTkr.nextToken()); // 연결된 지점의 번호
				int E = Integer.parseInt(strTkr.nextToken()); // 연결된 지점의 번호
				int T = Integer.parseInt(strTkr.nextToken()); // 도로를 이동하는데 걸리는 시간
				
				roads[S][E] = Math.min(roads[S][E], T);
				roads[E][S] = Math.min(roads[E][S], T);
			}
			
			for(int i=1; i<=W; i++) {
				strTkr = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(strTkr.nextToken()); // 시작지점
				int E = Integer.parseInt(strTkr.nextToken()); // 도착지점
				int T = Integer.parseInt(strTkr.nextToken()); // 줄어드는 시간
				
				roads[S][E] = Math.min(roads[S][E], -T);
			}
			
			for(int transferIndex=1; transferIndex<=N; transferIndex++)
				for(int i=1; i<=N; i++)
					for(int j=1; j<=N; j++)
						roads[i][j] = Math.min(roads[i][j], roads[i][transferIndex] + roads[transferIndex][j]);
			
			boolean isMinus = false;
			for(int i=1; i<=N; i++) {
				if(roads[i][i] < 0) {
					isMinus = true;
					break;
				}
			}
			
			sb.append(isMinus ? "YES" : "NO");
			sb.append("\n");
		}
		br.close();
		
		System.out.println(sb.toString());
	}
	
}
