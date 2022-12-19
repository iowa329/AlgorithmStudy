package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon18111 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(strTkr.nextToken());
		int m = Integer.parseInt(strTkr.nextToken());
		int b = Integer.parseInt(strTkr.nextToken()); // 인벤토리 블록개수
		
		int[] cnt = new int[256+1];
		for(int i=0; i<n; i++) {
			strTkr = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				int stair = Integer.parseInt(strTkr.nextToken());
				cnt[stair]++;
			}
		}
		br.close();
		
		int minTime = Integer.MAX_VALUE;
		int landHeight = 0;
		BaseLoop:
		for(int baseHeight=256; baseHeight>=0; baseHeight--) {
			int curInventory = b;
			int duringTime = 0;
			
			// 1번 작업(블록을 제거하여 인토리에 넣기)
			int toAddInventory = 0;
			for(int searchHeight=256; searchHeight>baseHeight; searchHeight--) {
				// 해당 층이 존재하는 경우
				if(cnt[searchHeight] != 0) {
					int gap = searchHeight - baseHeight;
					toAddInventory += cnt[searchHeight] * gap;				
				}
			}
			curInventory += toAddInventory;
			duringTime += toAddInventory * 2; // 1번 작업은 2초 소요
			
			// 2번 작업(인벤토리에서 꺼내서 블록 위에 놓기)
			int toRemoveInventory = 0;
			for(int searchHeight=baseHeight; searchHeight>=0; searchHeight--) {
				// 해당 층이 존재하는 경우
				if(cnt[searchHeight] != 0) {
					int gap = baseHeight - searchHeight;
					toRemoveInventory += cnt[searchHeight] * gap;				
				}
			}
			
			// 인벤토리 안에서 모두 꺼낼 수 있는지 확인
			if(toRemoveInventory > curInventory) // 불가능하다면
				continue BaseLoop; // 해당 baseHeight는 안된다는 의미이므로 무시
			
			// 모두 꺼낼 수 있다면
			curInventory -= toRemoveInventory;
			duringTime += toRemoveInventory * 1; // 2번 작업은 1초 소요
			
			// 최소시간 가능성 계산
			if(duringTime < minTime) {
				minTime = duringTime;
				landHeight = baseHeight;
			}
		}
		
		// 최소시간과 해당 높이 출력
		System.out.println(minTime + " " + landHeight);
	}
	
}