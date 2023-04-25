package baekjoon;

import java.io.*;
import java.util.*;

// 가르침
public class Baekjoon1062 {

	final static String COMMON_LETTERS = "antic";
	
	static int n, k;
	
	static int max = 0;
	static String[] words;
	static boolean[] visited = new boolean[26];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		n = Integer.parseInt(strTkr.nextToken());
		k = Integer.parseInt(strTkr.nextToken());
		
		// 가르칠 수 있는 글자 개수 k가 공통 글자수 보다 많다면
		if(k >= COMMON_LETTERS.length()) {
			// 알파벳 총 개수보다 많은 경우
			if(k >= 26) {
				max = n; // 전 단어 읽기 가능
			} else {
				// 공통 글자개수 이상 ~ 알파벳 26개 미만일 경우
				words = new String[n];
				for(int i=0; i<n; i++) {
					String str = br.readLine();
					words[i] = str.substring(4, str.length()-4);
				}
				br.close();
				
				// 공통 문자 방문처리
				for(int i=0; i<COMMON_LETTERS.length(); i++)
					visited[COMMON_LETTERS.charAt(i) - 'a'] = true;
				// 조합 계산
				combination(0, 0);
			}
		}
		
		// 결과
		System.out.println(max);
	}
	
	// DFS
	private static void combination(int start, int depth) {
		// 조합완성
		if(depth == k - COMMON_LETTERS.length()) {
			int cntReadable = 0;
			
			for(String word: words) {
				boolean isReadable = true;
				for(int i=0; i<word.length(); i++) {
					// 조합가능한 글자가 아닐 경우
					if(visited[word.charAt(i) - 'a'] == false) {
						isReadable = false; // 탐색 종료
						break;
					}
				}
				if(isReadable)
					cntReadable++;
			}
			
			max = Math.max(max, cntReadable);
			return;
		}
		
		for(int i=start; i<26; i++) {
			if(visited[i] == false) {
				visited[i] = true;
				combination(i+1, depth+1);
				visited[i] = false;
			}
		}
	}
	
}