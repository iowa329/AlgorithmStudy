package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1765 {

	static boolean[] check;
	static ArrayList<Integer>[] friends, enemies;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		// 변수 초기화
		check = new boolean[n+1];
		friends = new ArrayList[n+1];
		for(int i=1; i<=n; i++)
			friends[i] = new ArrayList<>();
		enemies = new ArrayList[n+1];
		for(int i=1; i<=n; i++)
			enemies[i] = new ArrayList<>();
		
		// 관계입력 받기
		for(int i=1; i<=m; i++) {
			StringTokenizer strTkr = new StringTokenizer(br.readLine());
			char relation = strTkr.nextToken().charAt(0);
			int p = Integer.parseInt(strTkr.nextToken());
			int q = Integer.parseInt(strTkr.nextToken());
			
			switch (relation) {
			case 'F':
				friends[p].add(q);
				friends[q].add(p);
				break;

			case 'E':
				enemies[p].add(q);
				enemies[q].add(p);
				break;
			}
		}
		br.close();
		
		int answer = 0;
        for(int i = 1; i<= n; i++){
            if(check[i] == false){
                check[i] = true;
                dfs(i);
                answer++;
            }
        }

        System.out.println(answer);
	}
	
	private static void dfs(int idx) {
        for (int t : friends[idx]) {
            if(check[t] == false) {
                check[t] = true;
                dfs(t);
            }
        }
        for (int t : enemies[idx]) {
            for (int e : enemies[t]) {
                if(check[e] == false) {
                    check[e] = true;
                    dfs(e);
                }
            }
        }
    }
	
}
