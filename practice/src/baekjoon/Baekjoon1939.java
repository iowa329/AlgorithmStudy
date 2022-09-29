package baekjoon;

import java.io.*;
import java.util.*;

// 섬에 있는 다리 정보 클래스
class Bridge {
	int destination;
	int maxWeight;
	
	public Bridge(int destination, int maxWeight) {
		this.destination = destination;
		this.maxWeight = maxWeight;
	}
}

public class Baekjoon1939 {

	// 섬의 개수
	static int n;
	
	// 섬 별 다리들의 정보 값을 갖는 (섬들의) ArrayList 배열 선언
	static ArrayList<ArrayList<Bridge>> islands = new ArrayList<ArrayList<Bridge>>();
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(strTkr.nextToken()); 
		int m = Integer.parseInt(strTkr.nextToken()); // 다리 정보 개수
		
		// 다리정보 초기화
		for (int i=0; i<=n; i++) { // 섬 번호는 1 ~ n까지 있으므로 0을 제외한 n+1개의 섬 ArrayList들이 필요 
			islands.add(new ArrayList<>());
		}
		
		int min = 0;
		int max = 0;
		// 섬 간 다리정보 입력받기
		for (int i=1; i<=m; i++) {
			strTkr = new StringTokenizer(br.readLine());
			int departure = Integer.parseInt(strTkr.nextToken());
			int destination = Integer.parseInt(strTkr.nextToken());
			int maxWeight = Integer.parseInt(strTkr.nextToken());
			
			// 양방향이기 때문에 섬 별로 각각 값을 입력
			islands.get(departure).add(new Bridge(destination, maxWeight));
			islands.get(destination).add(new Bridge(departure, maxWeight));

			// 최대 다리 하중값 찾기
			max = Math.max(max, maxWeight);
		}
		
		// 공장이 위치한 섬 정보 입력받기
		strTkr = new StringTokenizer(br.readLine());
		int factoryDeparture = Integer.parseInt(strTkr.nextToken());
		int factoryDestination = Integer.parseInt(strTkr.nextToken());
		br.close();
		
		
		// 이분탐색
		// 최대 다리하중(maxHeight) 기준으로 다리를 건널 수 있는 최대 하중값 탐색
		while(min <= max) {
			int mid = (min + max) / 2;
			
			System.out.println(min + " " + mid + " " + max + " ");
			
			// mid 최대 하중값을 기준으로
			if (acrossBridge(factoryDeparture, factoryDestination, mid)) {
				// 다리를 건널 수 있는 경우
				min = mid + 1;
			} else {
				// 다리를 건널 수 없는 경우
				max = mid - 1;
			}
		}
		
		
		// 결과
		System.out.println(max);
	}
	
	
	// BFS
	// 최대 하중값을 기준으로 섬에 있는 다리 건널 수 있는지 확인 
	private static boolean acrossBridge(int departure, int destination, int mid) {
		boolean[] visited = new boolean[n+1]; // 섬 번호는 1 ~ n까지 있으므로 0을 제외한 n+1개의 방문 변수가 필요
		
		Queue<Integer> que = new LinkedList<Integer>();
		que.add(departure);
		visited[departure] = true;
		
		while(que.isEmpty() == false) {
			int curIsland = que.poll();
			
			// 목적지에 도착한 경우
			if(curIsland == destination) return true;
			
			// 도착지 섬에 있는 다리들 정보 순회
			for(Bridge bridge: islands.get(curIsland)) {
				// 해당 섬을 방문하지 않았고 mid기준 최대 하중을 통과할 수 있는 다리라면  
				if(visited[bridge.destination] == false && mid <= bridge.maxWeight) {
					que.add(bridge.destination);
					visited[bridge.destination] = true;
				}
			}
		}
		
		return false;
	}

}