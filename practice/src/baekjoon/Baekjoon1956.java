package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1956 {

	static final int MAX_ROAD_LENGTH = 10000 * 400 + 1; // c의 최대값 * V개의 마을 최대 개수
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(strTkr.nextToken()); // 마을의 개수(1 ~ V까지)
		int E = Integer.parseInt(strTkr.nextToken()); // 도로의 개수
		
		// 마을도로 변수 선언 및 최소경로 비교를 위한 최대값으로 초기화
		int[][] villageRoads = new int[V+1][V+1];
		for(int[] villageRoad: villageRoads)
			Arrays.fill(villageRoad, MAX_ROAD_LENGTH);

		// 마을 a -> b 간의 도로 길이 정보 입력받기
		for(int i=0; i<E; i++) {
			strTkr = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(strTkr.nextToken()); // 마을 a
			int b = Integer.parseInt(strTkr.nextToken()); // 마을 b
			int c = Integer.parseInt(strTkr.nextToken()); // a->b로 가는 도로의 길이
			
			// 단방향만 이동 가능
			villageRoads[a][b] = c;
		}
		br.close();

		// 플로이드–워셜 알고리즘
		// i->j로 가는 최단경로 값 갱신
		for(int transferIndex=1; transferIndex<=V; transferIndex++)
			for(int i=1; i<=V; i++)
				for(int j=1; j<=V; j++)
					villageRoads[i][j] = Math.min(villageRoads[i][j], villageRoads[i][transferIndex] + villageRoads[transferIndex][j]);
		
		int minRoute = MAX_ROAD_LENGTH;
		for(int i=1; i<=V; i++)
			// villageRoads[i][j]는 i에서 j로 가는 최단거리
			// 즉, 이미 플로이드-워셜 알고리즘을 통해 해당 마을 사이클(villageRoads[i][i])이 최단거리이다
			minRoute = Math.min(minRoute, villageRoads[i][i]); // 그 중 가장 짧은 사이클 값을 저장
		
		// 최소 사이클의 도로 길이 합을 출력
		System.out.println(minRoute == MAX_ROAD_LENGTH ? -1 : minRoute);
	}
	
}