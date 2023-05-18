package baekjoon;

import java.io.*;
import java.util.*;

// 거짓말
public class Baekjoon1043 {

	static int[] parent;
	
	// 사실을 알고 있는 기준이 되는 사람의 parent 인덱스 값
	static int indexTruth;
	
	// 유니온 파인드(Union Find), 분리집합
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(strTkr.nextToken()); // 사람 수
		int m = Integer.parseInt(strTkr.nextToken()); // 파티 수
		
		// 부모 값 저장 배열 초기화
		parent = new int[n+1];
		for(int i=1; i<=n; i++)
			parent[i] = i;
		
		// 사실을 알고 있는 사람 유니온 파인드
		String[] peopleList = br.readLine().split(" ");
		int cntTruth = Integer.parseInt(peopleList[0]);
		if(cntTruth != 0) {
			indexTruth = Integer.parseInt(peopleList[1]);
		} else {
			// 진실을 알고 있는 사람이 아예 없을 경우
			System.out.println(m); // 파티 개수만큼 거짓말 가능
			return; // 더 이상 탐색이 필요 없으므로, 코드 전체 종료
		}
		
		for(int i=1; i<=cntTruth-1; i++) {
			int a = Integer.parseInt(peopleList[i]);
			int b = Integer.parseInt(peopleList[i+1]);
			union(a, b);
		}
		
		String[] partyList = new String[m];
		// 파티에서 사실을 알게되는 사람 유니온 파인드
		for(int i=0; i<m; i++) {
			partyList[i] = br.readLine();
			peopleList = partyList[i].split(" ");
			
			int cntPartyPeople = Integer.parseInt(peopleList[0]);
			for(int j=1; j<=cntPartyPeople-1; j++) {
				int a = Integer.parseInt(peopleList[j]);
				int b = Integer.parseInt(peopleList[j+1]);
				union(a, b);
			}
		}
		br.close();
		
		// 거짓말을 할 수 있는 파티 검사
		int cntToLie = 0;
		for(int i=0; i<m; i++) {
			peopleList = partyList[i].split(" ");
			
			boolean isPossibleToLie = true;
			int cntPartyPeople = Integer.parseInt(peopleList[0]);
			for(int j=1; j<=cntPartyPeople; j++) {
				int index = Integer.parseInt(peopleList[j]);
				if(findParent(index) == indexTruth) {
					isPossibleToLie = false;
					break;
				}
			}
			if(isPossibleToLie)
				cntToLie++;
		}
		
		// 결과
		System.out.println(cntToLie);
	}
	
	private static int findParent(int index) {
		if(parent[index] == index)
			return parent[index];
		
		return parent[index] = findParent(parent[index]);
	}
	
	private static void union(int a, int b) {
		a = findParent(a);
		b = findParent(b);
		
		if(a != b) {
			if(a == indexTruth ||
				b == indexTruth) {
				parent[a] = indexTruth;
				parent[b] = indexTruth;
			} else {
				parent[b] = a;
			}
		}
	}
	
}