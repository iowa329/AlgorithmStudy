package baekjoon;

import java.io.*;

public class Baekjoon5582 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str1 = br.readLine();
		String str2 = br.readLine();
		br.close();
		
		// DP
		int[][] commonStr = new int[str1.length() + 1][str2.length() + 1];
		int maxLength = 0;
		for(int i=1; i<=str1.length(); i++) {
			for(int j=1; j<=str2.length(); j++) {
				if(str1.charAt(i-1) == str2.charAt(j-1)) {
					commonStr[i][j] = commonStr[i-1][j-1] + 1;
					maxLength = Math.max(maxLength, commonStr[i][j]);
				}
			}
		}
		
		// 가장 길이가 긴 공통 부분 문자열 결과
		System.out.println(maxLength);
	}
}