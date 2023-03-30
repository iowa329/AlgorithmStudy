package baekjoon;

import java.io.*;
import java.util.*;

// 최종 순위
public class Baekjoon3665 {

	// 위상정렬(Topological Sort)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.parseInt(br.readLine());

		// 정답출력
		StringBuilder sbAnswer = new StringBuilder();
		
		// 케이스 탐색
		while(cases > 0) {
			// 팀의 수 n
			int n = Integer.parseInt(br.readLine());

			// 위상정렬(Topological Sort)
			int[] rankingLastYear = new int[n+1]; // 작년순위, index는 순위기준
			int[] indegree = new int[n+1]; // 진입차수
			boolean[][] order = new boolean[n+1][n+1]; // a, b의 관계(ex. [a][b] -> a가 b보다 앞에 있다)
			
			// 작년 순위
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			// 1등부터 ~ n등 까지 순서대로 입력
			for(int rank=1; rank<=n; rank++) {
				int teamNum = Integer.parseInt(strTkr.nextToken());
				rankingLastYear[rank] = teamNum;
			}
			
			// 진입차수 설정 및 팀간 선후관계 설정
			for(int rank=1; rank<=n-1; rank++) {
				for(int after=rank+1; after<=n; after++) {
					int teamNum = rankingLastYear[rank];
					int teamAfter = rankingLastYear[after];
					
					indegree[teamAfter]++;
					order[teamNum][teamAfter] = true;
				}
			}
			
			// 올해 순위가 바뀐 쌍의 수 개수 m
			int m = Integer.parseInt(br.readLine());
			
			// 순위가 바뀐 팀 정보
			for(int i=1; i<=m; i++) {
				strTkr = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(strTkr.nextToken());
				int b = Integer.parseInt(strTkr.nextToken());
				
				// 선후관계 뒤집기
				// a가 b보다 앞에 있다면
				if(order[a][b]) {
					indegree[a]++; // a 뒤로 보내기
					indegree[b]--;
					
					order[a][b] = false;
					order[b][a] = true; // 이젠 b가 앞에 위치
				} else {
					// b가 a보다 앞에 있다면
					indegree[b]++; // b 뒤로 보내기
					indegree[a]--;
					
					order[b][a] = false;
					order[a][b] = true; // 이젠 a가 앞에 위치
				}
			}
			
			// 위상정렬 출력 시작
			Queue<Integer> que = new LinkedList<>();
			
			// 시작지점 탐색
			for(int i=1; i<=n; i++)
				if(indegree[i] == 0)
					que.add(i);
			
			// 순위기록 시작
			StringBuilder sbCur = new StringBuilder();
			boolean isHasOrder = true;
			for(int ranking=1; ranking<=n; ranking++) {
				// 진입차수가 없으면 사이클이 발생한 것이므로
				if(que.size() == 0) {
					sbAnswer.append("IMPOSSIBLE"); // 순위계산이 불가능하다
					isHasOrder = false;
					break;
				}
				
				// 진입차수가 2개 이상이면
				if(que.size() >= 2) {
					sbAnswer.append("?"); // 정확한 순위를 알 수 없다
					isHasOrder = false;
					break;
				}
				
				int curTeam = que.poll();
				sbCur.append(curTeam + " ");
				
				// 진입차수 확인
				for(int nextTeam=1; nextTeam<=n; nextTeam++) {
					if(order[curTeam][nextTeam]) {
						if(--indegree[nextTeam] == 0) {
							que.add(nextTeam);
						}
					}
				}
			}
			if(isHasOrder)
				sbAnswer.append(sbCur);
			
			sbAnswer.append("\n");
			cases--;
		}
		br.close();
		
		// 결과
		System.out.println(sbAnswer.toString());
	}
	
}