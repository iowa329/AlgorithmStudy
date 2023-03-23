package baekjoon;

import java.io.*;
import java.util.*;

// 램프
public class Baekjoon1034 {

	// 브루트포스 알고리즘
	// 애드 혹
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(strTkr.nextToken()); // 행
		int m = Integer.parseInt(strTkr.nextToken()); // 열
		
		int[][] lamp = new int[n][m];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				lamp[i][j] = str.charAt(j) - 48;
			}
		}
		
		int k = Integer.parseInt(br.readLine());
		br.close();
		
		// 탐색시작
		boolean[] visited = new boolean[n]; // 자신과 동일한 형태가 있으면 방문처리
		int maxSamePattern = 0;
		for(int i=0; i<n; i++) {
			if(visited[i] == false) {
				
				int cnt0 = 0;
				for(int cnt=0; cnt<m; cnt++) {
					// 켜야할(0) 개수 파악
					if(lamp[i][cnt] == 0)
						cnt0++;
				}

				int cntSamePattern = 0;
				// 켜야할 개수가 k이하고 k와 개수가 일치하면
				if(cnt0 <= k &&
					k % 2 == cnt0 % 2) {
				
					cntSamePattern = 1;
					visited[i] = true; // 해당패턴 방문처리 후
					// 자신과 동일한 패턴이 있는지 확인
					for(int search=0; search<n; search++) {
						// 분류되지 않은 패턴이라면
						if(visited[search] == false) {
							// 현재 패턴과 동일한지 확인
							boolean isSame = true;
							for(int same=0; same<m; same++) {
								if(lamp[i][same] != lamp[search][same]) {
									isSame = false;
									break;
								}
							}
							
							// 현재 패턴과 동일하다면
							if(isSame) {
								visited[search] = true; // 패턴 분류처리
								cntSamePattern++;
							}
						}
					}
					
				}
				// 최대 패턴개수 값 갱신
				maxSamePattern = Math.max(maxSamePattern, cntSamePattern);
				
			}
		}
		
		// 결과
		System.out.println(maxSamePattern);
	}
	
}