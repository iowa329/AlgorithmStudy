package baekjoon;

import java.io.*;
import java.util.*;

// 단어 섞기
public class Baekjoon9177 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 데이터 집합 입력받기
		StringBuilder sb = new StringBuilder();
		for(int cases=1; cases<=n; cases++) {
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			String word1 = strTkr.nextToken();
			String word2 = strTkr.nextToken();
			String word3 = strTkr.nextToken();
			
			// dp[i][j] = 첫 문자열에서 i개 만큼 사용하고, 두 번째 문자열에서 j개 만큼 사용했을 때 세 번째 문자열의 i+j까지 사용할 수 있는지 여부 저장 배열
			boolean[][] dp = new boolean[word1.length()+1][word2.length()+1]; // 인덱스의 시작은 0이지만 개념상 dp배열의 시작은 1부터
			
			if(word1.charAt(0) == word3.charAt(0))
				dp[1][0] = true;
			if(word2.charAt(0) == word3.charAt(0))
				dp[0][1] = true;
			
			for(int i=0; i<word1.length()+1; i++) {
				for(int j=0; j<word2.length()+1; j++) {
					// word1 문자열(i)을 사용하지 않고(i-1) word2 문자열(j)을 사용한 조합이 가능하고
					if(i>=1 && dp[i-1][j] &&
						// 사용하지 않은 word1 문자열(i)가 word3와 같다면
						word3.charAt((i+j)-1) == word1.charAt(i-1))
						dp[i][j] = true;

					// word1 문자열(i)을 사용하고 word2 문자열(j)을 사용하지 않은(j-1) 조합이 가능하고
					if(j>=1 && dp[i][j-1] &&
						// 사용하지 않은 word2 문자열(j-1)가 word3와 같다면
						word3.charAt((i+j)-1) == word2.charAt(j-1))
						dp[i][j] = true;
				}
			}
			
			sb.append(String.format("Data set %d: ", cases));
			sb.append(dp[word1.length()][word2.length()] ? "yes" : "no");
			sb.append("\n");
		}
		br.close();
		
		// 결과
		System.out.println(sb.toString());
	}
}