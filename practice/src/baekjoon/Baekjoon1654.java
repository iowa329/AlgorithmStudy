package baekjoon;

import java.io.*;

public class Baekjoon1654 {

	public static void main(String[] args) throws IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String[] lanInfo = br.readLine().split(" ");
			
			int k = Integer.parseInt(lanInfo[0]);
			int n = Integer.parseInt(lanInfo[1]);
			
			int[] lans = new int[k];
			
			long min = 1;
			long max = 0;
			// 랜선 길이 입력받기
			for (int i=0; i<k; i++) {
				lans[i] = Integer.parseInt(br.readLine());
				
				// 최대값 찾기
				if(lans[i] > max) {
					max = lans[i];
				}
			}
			br.close();
		
			// 이분탐색 시작
			while(min <= max) { // 하한이 상한을 넘어설 때 탐색을 종료
				long mid = (min + max) / 2;
				
				int cntLans = 0;
				for(int i=0; i<k; i++) {
					cntLans += lans[i] / mid;
				}
				
				System.out.println(min + " " + max + " " + mid + " "+ cntLans + " ");
				
				if(cntLans < n) { // 자른 선의 개수가 부족하면 길이를 줄여야 하므로
					max = mid - 1;
				} else {
					// 자른 선의 개수가 많으면 길이를 늘리고, 동일하면 min 크기를 하나 늘려 while문을 빠져나간다
					min = mid + 1;
				}
			}
			
			// 결과
			System.out.println(max);
	}

}