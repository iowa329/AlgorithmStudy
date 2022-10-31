package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon14425 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(strTkr.nextToken());
		int m = Integer.parseInt(strTkr.nextToken());
		
		HashMap<String, Integer> hashMap = new HashMap<>();
		for(int i=0; i<n; i++) hashMap.put(br.readLine(), 0);
		
		int answer = 0;
		for(int i=0; i<m; i++) if(hashMap.get(br.readLine()) != null) answer++;
		br.close();
		
		System.out.println(answer);
	}

}