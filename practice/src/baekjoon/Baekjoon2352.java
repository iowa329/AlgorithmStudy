package baekjoon;

import java.io.*;
import java.util.*;

// 반도체 설계
public class Baekjoon2352 {

	// 최장 증가 부분 수열(LIS, Longest Increasing Subsequence), DP
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 연결되어야 하는 포트 번호 입력받기
		int[] portInfo = new int[n+1];
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			portInfo[i] = Integer.parseInt(strTkr.nextToken());
		}
		br.close();
		
		// 연결할 포트 목록 배열 선언
		int[] list = new int[n+1];
		// 맨앞 값 초기화
		list[1] = portInfo[1];
		
		// 연결할 포트(list) 현재위치 index
		int curPos = 1;
		for(int i=2; i<=n; i++) {
			// 연결해야 할 포트가 연결된 포트보다 뒤로 갈 수 있다면
			if(list[curPos] < portInfo[i]) {
				list[++curPos] = portInfo[i];
			} else
				// 연결해야 할 포트가 연결된 맨 앞포트보다 앞에 갈 수 있다면
				if(portInfo[i] < list[0]) {
				list[0] = portInfo[i];
			} else {
				// 연결해야 할 포트가 list 사이로 올 수 있다면
				// 이분탐색
				// binarySearch 함수: 값이 있다면 해당 인덱스 반환, 없다면 음수처리 후 -1만큼 처리 후 인덱스 반환
				int searchIndex = Arrays.binarySearch(list, 1, curPos, portInfo[i]);
				if(searchIndex < 0) {
					int toReplaceIndex = -(searchIndex+1);
					list[toReplaceIndex] = portInfo[i];
				}
			}
		}
		
		// 결과
		System.out.println(curPos);
	}
	
}