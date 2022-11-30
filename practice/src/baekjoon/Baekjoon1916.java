package baekjoon;

import java.io.*;
import java.util.*;

class City implements Comparable<City> {
	int num;
	int distance;
	
	City (int num, int distance) {
		this.num = num;
		this.distance = distance;
	}

	// 거리 기준 오름차순 정렬
	@Override
	public int compareTo(City o) {
		return Integer.compare(this.distance, o.distance);
	}	
}

public class Baekjoon1916 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		// 해당 도시의 연결되어 있는 도시들과 그 버스비를 저장할 배열선언
		ArrayList<ArrayList<City>> cities = new ArrayList<>();
		for(int i=0; i<=n; i++)
			cities.add(new ArrayList<>());
		
		// 버스비 정보 입력
		while(m > 0) {
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(strTkr.nextToken());
			int end = Integer.parseInt(strTkr.nextToken());
			int busFare = Integer.parseInt(strTkr.nextToken());
			
			cities.get(start).add(new City(end, busFare));
			
			m--;
		}
		br.close();
		
		// 구하고자 하는 도시 출발점, 도착점 번호
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		int departure = Integer.parseInt(strTkr.nextToken());
		int destination = Integer.parseInt(strTkr.nextToken());
		br.close();
		
		// 다익스트라(Dijkstra) 알고리즘
		PriorityQueue<City> pq = new PriorityQueue<>(); // 우선순위 큐로 최단거리 도시부터 방문하여 값을 갱신
		
		// 시작점에서 해당 index 도시까지의 최단거리를 저장 할 배열
		int[] minDistances = new int[n+1];
		for(int i=0; i<n+1; i++)
			minDistances[i] = Integer.MAX_VALUE;
		
		// 최단거리 탐색 순회 시작
		pq.add(new City(departure, 0)); // 출발도시 값 입력
		minDistances[departure] = 0; // 시작지점과의 거리는 0이므로
		while (pq.isEmpty() == false) {
			City curCity = pq.poll();
			
			// 현재 갈 도시의 거리가 해당 도시의 최소거리보다 큰 경우 이미 방문했다는 의미(MAX Integer 값이 아님)이므로 다음 큐로 넘어간다
			if(curCity.distance > minDistances[curCity.num])
				continue;
			
			// 현재 도시에 연결된 다른 도시로 가는 도로들에 대해 거리가 짧은 곳으로 이동
			for(City toGoCity: cities.get(curCity.num)) {
				if(curCity.distance + toGoCity.distance < minDistances[toGoCity.num]) {
					minDistances[toGoCity.num] = curCity.distance + toGoCity.distance;
					pq.add(new City(toGoCity.num, minDistances[toGoCity.num]));
				}
			}
		}
		
		// 결과
		System.out.println(minDistances[destination]);
	}
		
}