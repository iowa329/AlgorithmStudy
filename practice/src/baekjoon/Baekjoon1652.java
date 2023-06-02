package baekjoon;

import java.io.*;

// 누울 자리를 찾아라
public class Baekjoon1652 {

	// 구현, 문자열
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 콘도 방 정보 배열 저장
		String[] infos = new String[n];
		for(int i=0; i<n; i++)
			infos[i] = br.readLine();
		br.close();
		
		boolean searchMode = true;
		
		// 가로 탐색
		int horizon = 0;
		for(int i=0; i<n; i++) {
			searchMode = true;
			for(int j=0; j<n-1; j++) {
				if(searchMode) {
					if(infos[i].charAt(j) == '.' &&
						infos[i].charAt(j+1) == '.') {
						horizon++;
						searchMode = false;
					}
				}
				
				if(infos[i].charAt(j) == 'X')
					searchMode = true;
			}
		}
		
		// 세로 탐색
		int vertical = 0;
		for(int i=0; i<n; i++) {
			searchMode = true;
			for(int j=0; j<n-1; j++) {
				if(searchMode) {
					if(infos[j].charAt(i) == '.' &&
						infos[j+1].charAt(i) == '.') {
						vertical++;
						searchMode = false;
					}
				}
				
				if(infos[j].charAt(i) == 'X')
					searchMode = true;
			}
		}
		
		// 결과
		System.out.println(horizon + " " + vertical);
	}
	
}