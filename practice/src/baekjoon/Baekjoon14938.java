package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon14938 {

	// 플로이드–워셜 알고리즘
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(strTkr.nextToken()); // 지역의 개수
		int m = Integer.parseInt(strTkr.nextToken()); // 수색 범위
		int r = Integer.parseInt(strTkr.nextToken()); // 길의 개수
		
		// 각 구역의 아이템 수
		int[] fieldItems = new int[n+1];
		strTkr = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			fieldItems[i] = Integer.parseInt(strTkr.nextToken());
		}
		
		// 길 양 끝에 존재하는 지역 번호 및 길의 길이
		int[][] fieldRoads = new int[n+1][n+1];
		for(int i=0; i<r; i++) {
			strTkr = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(strTkr.nextToken()); // 지역번호 a
			int b = Integer.parseInt(strTkr.nextToken()); // 지역번호 b
			int l = Integer.parseInt(strTkr.nextToken()); // 길의 길이
			
			// 양방향 이동 가능
			fieldRoads[a][b] = l;
			fieldRoads[b][a] = l;
		}
		br.close();
		
		// 바로(i->j) 갈 수 없거나 바로 가는 것 보다 경유한 거리가 짧다면 짧은 값으로 변경
		for(int transferIndex=1; transferIndex<=n; transferIndex++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					
					if(i != j && // 출발지와 도착지가 동일 할 경우 거리는 0 이므로 조건검사에서 제외
					   fieldRoads[i][transferIndex] != 0 && fieldRoads[transferIndex][j] != 0) {
						int transferDistance = fieldRoads[i][transferIndex] + fieldRoads[transferIndex][j];
						int curField = fieldRoads[i][j];
						if(curField == 0) // 없었던 경로가 경유로 만들 수 있다면
							fieldRoads[i][j] = transferDistance; // 경유거리 입력
						else
							if(transferDistance < curField) // 기존에 바로 갈 수 있는 길보다 경유거리가 짧을 경우
								fieldRoads[i][j] = transferDistance; // 갈 수 있는 거리 값 갱신
					}
				
				}
			}
		}
		
		// 낙하지점마다 얻을 수 있는 아이템의 총합 중 최대값을 계산
		int maxItems = 0;
		for(int dropPoint=1; dropPoint<=n; dropPoint++) {
			int getItems = 0;
			for(int destination=1; destination<=n; destination++) {
				if(dropPoint == destination)
					getItems += fieldItems[destination];
				else
					if(0 < fieldRoads[dropPoint][destination] && fieldRoads[dropPoint][destination] <= m)
						getItems += fieldItems[destination];
			}
			maxItems = Math.max(maxItems, getItems);
		}
		
		// 얻을 수 있는 최대 아이템의 개수
		System.out.println(maxItems);
	}
	
}