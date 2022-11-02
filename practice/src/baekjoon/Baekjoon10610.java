package baekjoon;

import java.io.*;

public class Baekjoon10610 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String n = br.readLine();
		br.close();
		
		int[] cntElement = new int[10]; // 0 ~ 9 요소의 개수를 저장할 배열
		int total = 0;
		for(int i=0; i<n.length(); i++) {
			int num = n.charAt(i) - '0'; // ASCII 코드 값 보정(0은 48, 1부터 49~)
			cntElement[num]++;
			total += num;
		}
		
		// 30배수의 조건 2가지를 만족하지 못하면
		if(n.contains("0") == false || total % 3 != 0) {
			System.out.println(-1);
			return; // 종료
		}
		
		// 9부터 문자열 합산으로 최대값 구성
		StringBuilder sb = new StringBuilder();
		for(int numElement=9; numElement>=0; numElement--) {
			while(cntElement[numElement] > 0) {
				sb.append(numElement);
				cntElement[numElement]--;
			}
		}
		
		System.out.println(sb.toString());
	}

}