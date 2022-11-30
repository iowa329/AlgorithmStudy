package baekjoon;

import java.io.*;
import java.util.*;

class Bus {
	int departure;
	int destination;
	int time;
	
	Bus (int departure, int destination, int time) {
		this.departure = departure;
		this.destination = destination;
		this.time = time;
	}
}

public class Baekjoon11657 {

	// 최소거리의 최대값의 경우의 수는 n * m * c = 500 * 6000 * -10000 = -30,000,000,000 이므로 int형으로 하면 오버플로우 발생
	static final long INF = Long.MAX_VALUE;
	
	static int n, m;
	
	static Bus[] busRoutes;
	static long[] minRoutes;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(strTkr.nextToken()); // 도시의 개수
		m = Integer.parseInt(strTkr.nextToken()); // 노선의 개수
		
		busRoutes = new Bus[m];
		for(int i=0; i<m; i++) {
			strTkr = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(strTkr.nextToken());
			int b = Integer.parseInt(strTkr.nextToken());
			int c = Integer.parseInt(strTkr.nextToken());
			
			busRoutes[i] = new Bus(a, b, c);
		}
		br.close();
		
		minRoutes = new long[n+1];
		Arrays.fill(minRoutes, INF);
		
		StringBuilder sb = new StringBuilder();
		// 벨만포드 알고리즘 시작
		if(bellmanFord()) {
			for(int i=2; i<=n; i++) {
				sb.append(minRoutes[i] != INF ? minRoutes[i] : -1);
				sb.append("\n");
			}
		} else {
			sb.append(-1);
		}
		
		// 결과
		System.out.println(sb.toString());
	}
	
	// 벨만포드(Bellman-Ford) 알고리즘
	private static boolean bellmanFord() {
		minRoutes[1] = 0; // 시작점의 최단거리
		
		int repeat=1;
		// n개 도시 사이 최소거리들(n-1)만큼 반복하면 도시 간의 최소거리 값이 나오게 된다
		while(repeat <= n-1) {
			for(Bus busRoute: busRoutes) {
				// 한번도 방문한 적이 없는 경우
				if(minRoutes[busRoute.departure] == INF)
					continue; // 넘어감
				
				if(minRoutes[busRoute.departure] + busRoute.time < minRoutes[busRoute.destination])
					minRoutes[busRoute.destination] = minRoutes[busRoute.departure] + busRoute.time;
			}
			
			repeat++;
		}
		
		// n번째 반복했을 때 최소거리(minRoutes) 값에 갱신이 일어나면 음수 사이클이 존재한다는 의미
		for(Bus busRoute: busRoutes) {
			if(minRoutes[busRoute.departure] == INF)
				continue;
			
			if(minRoutes[busRoute.departure] + busRoute.time < minRoutes[busRoute.destination])
				return false;
		}
		
		return true;
	}
	
}