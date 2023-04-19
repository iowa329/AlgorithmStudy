package baekjoon;

import java.io.*;
import java.util.*;

// 파일 정리
public class Baekjoon20291 {

	// 문자열, 해시맵(HashMap)
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		// 파일 정보 입력받기
		HashMap<String, Integer> hashMap = new HashMap<>();
		for(int i=1; i<=n; i++) {
			// split 안의 값은 정규식을 입력받는다
			// 정규식에서 마침표(.)는 임의의 한 문자를 의미
			String[] file = br.readLine().split("\\."); // 이스케이프 처리 사용 필수
			hashMap.put(file[1], hashMap.getOrDefault(file[1], 0) + 1);
		}
		br.close();
		
		// 키 값 기준 오름차순 정렬
		ArrayList<String> keyList = new ArrayList<>(hashMap.keySet());
		Collections.sort(keyList);
		
		// 정답 출력
		StringBuilder sb = new StringBuilder();
		for(String key: keyList)
			sb.append(key + " " + hashMap.get(key) + "\n");
		
		// 결과
		System.out.println(sb.toString());
	}
	
}