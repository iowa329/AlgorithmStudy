package baekjoon;

import java.io.*;
import java.util.*;

// 두 배열의 합
public class Baekjoon2143 {

	// 누적합 (혹은 이분탐색)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// 두 부배열의 합의 기준 t
		int t = Integer.parseInt(br.readLine());
		
		// 배열 n 입력받기
		int n = Integer.parseInt(br.readLine());
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		int[] arrN = new int[n+1];
		for(int i=1; i<=n; i++) {
			arrN[i] = Integer.parseInt(strTkr.nextToken());
		}

		// 배열 m 입력받기
		int m = Integer.parseInt(br.readLine());
		strTkr = new StringTokenizer(br.readLine());
		int[] arrM = new int[m+1];
		for(int i=1; i<=m; i++) {
			arrM[i] = Integer.parseInt(strTkr.nextToken());
		}
		br.close();
		
		// 배열 n에 대한 누적합 배열 prefixSumN 선언
		int[] prefixSumN = new int[n+1];
		for(int i=1; i<=n; i++) {
			prefixSumN[i] = prefixSumN[i-1] + arrN[i];
		}
		
		// 배열 m에 대한 누적합 배열 prefixSumM 선언
		int[] prefixSumM = new int[m+1];
		for(int i=1; i<=m; i++) {
			prefixSumM[i] = prefixSumM[i-1] + arrM[i];
		}
		
		// 누적합 n에 대한 부배열 경우의 수
		HashMap<Integer, Integer> hashMap = new HashMap<>();
		for(int range=1; range<=n; range++) {
			for(int i=0; i+range<=n; i++) {
				int value = prefixSumN[i+range] - prefixSumN[i];
				hashMap.put(value, hashMap.getOrDefault(value, 0)+1);
			}
		}
		
		// 누적합 m에 대한 부배열 경우의 수
		long cntSumT = 0L;
		for(int range=1; range<=m; range++) {
			for(int i=0; i+range<=m; i++) {
				int valueM = prefixSumM[i+range] - prefixSumM[i];
				// 필요합 t = 부배열N + 부배열M
				int diff = t - valueM; // diff는 부배열N의 후보
				
				// diff가 부배열N일 때 기준합 t에 대한 정답이므로
				if(hashMap.containsKey(diff))
					cntSumT += hashMap.get(diff);
			}
		}
		
		// 결과
		System.out.println(cntSumT);
	}
	
}