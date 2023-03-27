package baekjoon;

import java.io.*;
import java.util.*;

// 게리맨더링
public class Baekjoon17471 {

	static int n;
	
	static int[] populations;
	static ArrayList<ArrayList<Integer>> map;
	
	static int MAX_GAP = 10 * 100 + 1;
	static int minGap = MAX_GAP; // 최대 구역 개수 n = 10, 최대 구역의 인구수 100 
	
	// 조합(Combination), BFS
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		
		// 각 구역별 인구 정보 입력받기
		populations = new int[n+1];
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			populations[i] = Integer.parseInt(strTkr.nextToken());
		}
		
		// 각 구역별 인접 구역번호 저장 배열 선언
		map = new ArrayList<>();
		for(int i=0; i<=n; i++) {
			map.add(new ArrayList<>());
		}
		
		// 각 구역별 인접한 구역번호 입력받기
		for(int i=1; i<=n; i++) {
			strTkr = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(strTkr.nextToken());
			for(int near=1; near<=cnt; near++) {
				int nearNum = Integer.parseInt(strTkr.nextToken());
				map.get(i).add(nearNum);
			}
		}
		br.close();
		
		// 선거구 획정(게리멘터링) 시작
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=1; i<=n; i++) {
			System.out.println("\n<<<<<<<<<start " + i);
			combination(1, i, list);
		}
		
		
		// 결과
		System.out.println(minGap == MAX_GAP ? -1 : minGap);
	}
	
	// 조합 nCr
	private static void combination(int startIndex, int r, ArrayList<Integer> districtA) {
		System.out.println("called: " + startIndex);
		
		if(r == 0) {
			System.out.println(districtA);
			
			ArrayList<Integer> districtB = getDistrictB(districtA);
			if(isAvailable(districtA) && isAvailable(districtB)) {
				int gap = calculateGap(districtA, districtB);
				minGap = Math.min(minGap, gap);
			}
			
			return;
		}
		
		for(int i=startIndex; i<=n; i++) {
			districtA.add(i);
			combination(i+1, r-1, districtA);
			districtA.remove(districtA.size()-1);
		}
	}
	
	// 선거구 유효성 검사
	private static boolean isAvailable(ArrayList<Integer> result) {
		if(result.isEmpty())
			return true;
		
		// BFS
		boolean[] visited = new boolean[n+1];
		Queue<Integer> que = new LinkedList<>();
		int cnt = 0; // result 선거구의 인근 구역 총 개수
		
		int startDistrict = result.get(0);
		que.add(startDistrict);
		visited[startDistrict] = true;
		cnt++;
		
		while(!que.isEmpty()) {
			int curDistrict = que.poll();
			
			for(int near: map.get(curDistrict)) {
				if(result.contains(near) && visited[near] == false) {
					que.add(near);
					visited[near] = true;
					cnt++;
				}
			}
		}
		
		// result 선거구 내 모든 구역이 연결되어 있는지 확인
		return result.size() == cnt ? true : false;
	}
	
	private static ArrayList<Integer> getDistrictB(ArrayList<Integer> districtA) {
		boolean[] district = new boolean[n+1];
		for(int num: districtA)
			district[num] = true;
		
		ArrayList<Integer> districtB = new ArrayList<>();
		for(int i=1; i<=n; i++)
			if(district[i] == false)
				districtB.add(i);
		
		return districtB;
	}
	
	private static int calculateGap(ArrayList<Integer> districtA, ArrayList<Integer> districtB) {
		int sumA = 0;
		for(int num: districtA)
			sumA += populations[num];
		
		int sumB = 0;
		for(int num: districtB)
			sumB += populations[num];
		
		return Math.abs(sumA - sumB);
	}
	
}