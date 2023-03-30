package baekjoon;

import java.io.*;

// 공항
public class Baekjoon10775 {

	static int[] gate;
	
	// 유니온 파인드(union find), 그리디(greedy)
	public static void main(String[] args) throws IOException {
		// 도킹 가능한 게이트 범위: 1번째 ~ 주어진 게이트 번호
		// 주어진 게이트에 도킹하는게 최선, 아니면 한 칸씩 줄여가며 도킹 가능한 게이트인지 확인(findParent)
		// 도킹 가능한 게이트를 parent(여기선 gate)값의 기본으로 한다
		// 0번 게이트는 더 이상 도킹 가능한 게이트가 없음을 의미
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int g = Integer.parseInt(br.readLine()); // 게이트 수
		int p = Integer.parseInt(br.readLine()); // 비행기 수
		
		// 도킹 가능한 게이트 초기화
		gate = new int[g+1];
		for(int i=1; i<=g; i++) {
			gate[i] = i;
		}
		
		int cntDocking = 0;
		for(int i=0; i<p; i++) {
			int airplane = Integer.parseInt(br.readLine());
			int emptyGate = findEmptyGate(airplane);
			
			// 더 이상 도킹할 게이트가 남지 않은 경우
			if(emptyGate == 0)
				break; // 종료
			
			// 현재 게이트에 도킹하고 이전 게이트를 도킹 가능한 게이트로 설정
			union(emptyGate, emptyGate-1);
			cntDocking++;
		}
		br.close();
		
		// 결과
		System.out.println(cntDocking);
	}
	
	private static void union(int from, int to) {
		from = findEmptyGate(from);
		to = findEmptyGate(to);
		
		if(from != to)
			gate[from] = to;
	}
	
	private static int findEmptyGate(int index) {
		if(gate[index] == index)
			return index;
		
		return gate[index] = findEmptyGate(gate[index]);
	}
	
}