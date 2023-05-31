package baekjoon;

import java.io.*;
import java.util.*;

// 코딩은 예쁘게
public class Baekjoon2879 {

	// 그리디(Greedy)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer strTkr1 = new StringTokenizer(br.readLine());
		StringTokenizer strTkr2 = new StringTokenizer(br.readLine());
		br.close();
		
		// 현재 탭 상태와 올바른 탭 상태 간의 차이 저장
		int[] cntToFixTabs = new int[n];
		for(int i=0; i<n; i++)
			cntToFixTabs[i] = Integer.parseInt(strTkr2.nextToken()) - Integer.parseInt(strTkr1.nextToken());
		
		// 명령어 작동 시작
		int cntEdit = 0;
		int index = 0;
		while(index < n) {
			if(cntToFixTabs[index] == 0) {
				index++;
				continue;
			}
			
			// 탭 그룹 탐색
			boolean beforePlus = cntToFixTabs[index] > 0 ? true : false;
			int j = index+1;
			int min = Math.abs(cntToFixTabs[index]);
			while(true) {
				// 탭의 개수가 0이거나 탐색할 인덱스(j)가 끝까지 도달하였다면
				if(j >= n ||
					cntToFixTabs[j] == 0)
					break; // 탐색종료
				
				boolean curPlus = cntToFixTabs[j] > 0 ? true : false;
				if(curPlus != beforePlus) {
					break;
				}
				
				min = Math.min(min, Math.abs(cntToFixTabs[j]));
				beforePlus = curPlus;
				
				j++;
			}
			
			// 탭 명령어 실행
			min = Math.abs(min);
			for(int range=index; range<j; range++)
				cntToFixTabs[range] += beforePlus ? (min * -1) : min;
			// 편집 횟수 업데이트
			cntEdit += min;
		}
		
		// 결과
		System.out.println(cntEdit);
	}
	
}