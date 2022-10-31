package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon5052 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int t = Integer.parseInt(br.readLine());
		for(int cases=1; cases<=t; cases++) {
			
			int n = Integer.parseInt(br.readLine());
			
			String[] phoneNumberList = new String[n];
			for(int i=0; i<n; i++) phoneNumberList[i] = br.readLine();
			Arrays.sort(phoneNumberList);

			boolean isHasPrefix = false;
			for(int i=0; i<n-1; i++) {
				if (phoneNumberList[i+1].startsWith(phoneNumberList[i])) {
					isHasPrefix = true;
					break;
				}
			}
			
			// 삼항연산자 사용시 틀림. 이유 파악 불가
//			sb.append(isHasPrefix ? "No" : "YES");
//			sb.append("\n");
			
			if(isHasPrefix) {
				sb.append("NO");
			} else {
				sb.append("YES");
			}
            sb.append("\n");
			
		}
		br.close();
		
		System.out.println(sb);
	}

}