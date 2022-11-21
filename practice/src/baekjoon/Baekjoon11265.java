package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon11265 {

	// 플로이드–워셜 알고리즘
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(strTkr.nextToken()); // 파티장 크기
		int m = Integer.parseInt(strTkr.nextToken()); // 서비스를 요청한 손님 수
		
		// 파티장 정보 입력 받기
		int[][] party = new int[n+1][n+1];
		for(int i=1; i<=n; i++) {
			strTkr = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				party[i][j] = Integer.parseInt(strTkr.nextToken());
			}
		}
		
		// 모든 경유지에 대한 최단거리를 탐색하여 직접연결된 거리보다 짧으면 값을 갱신
		for(int transferIndex=1; transferIndex<=n; transferIndex++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					int transferTime = party[i][transferIndex] + party[transferIndex][j]; 
					if(transferTime < party[i][j]) {
						party[i][j] = transferTime;
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		// 파티 정보 A, B, C 입력받기
		for(int i=0; i<m; i++) {
			strTkr = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(strTkr.nextToken()); // 현재 파티 위치
			int b = Integer.parseInt(strTkr.nextToken()); // 다음 파티 위치
			int c = Integer.parseInt(strTkr.nextToken()); // 다음 파티가 열리는데 걸리는 시간
			
			sb.append(party[a][b] <= c ? "Enjoy other party" : "Stay here");
			sb.append("\n");
		}
		br.close();
		
		// 손님 요청에 대한 응답 출력
		System.out.println(sb.toString());
	}
	
}