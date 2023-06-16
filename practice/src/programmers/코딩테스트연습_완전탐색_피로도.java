package programmers;

public class 코딩테스트연습_완전탐색_피로도 {

	public static void main(String[] args) {
		int k = 80; int[][] dungeons = {{80,20},{50,40},{30,10}};
		
		System.out.println(solution(k, dungeons));
	}
	
	static boolean[] visited;
	static int cnt = 0;
	
	public static int solution(int k, int[][] dungeons) {
		visited = new boolean[dungeons.length];
		
		dfs(0, k, dungeons);
		
        return cnt;
    }
	
	private static void dfs(int depth, int tired, int[][] dungeons) {
		for(int i=0; i<dungeons.length; i++) {
			// 방문했거나 피로도가 최소 필요도 보다 적다면
			if(visited[i] || dungeons[i][0] > tired)
				continue; // 패스
			
			visited[i] = true;
			tired -= dungeons[i][1];
			
			dfs(depth+1, tired, dungeons);
			
			visited[i] = false;
			tired += dungeons[i][1];
		}
		
		cnt = Math.max(cnt, depth);
	}
	
}