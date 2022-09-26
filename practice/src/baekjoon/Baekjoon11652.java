package baekjoon;

import java.util.*;

public class Baekjoon11652 {

	public static void main(String[] args) {
		// 값 입력받기
		Scanner sc = new Scanner(System.in);

		// Long형의 범위는 2^64 -1 (-2,147,483,648 ~ 2,147,483,647)
		long maxNum = Long.MAX_VALUE;
		long maxCnt = 0L;

		// 카드의 개수
		int n = sc.nextInt();
		// HashMap
		HashMap<Long, Long> hashMap = new HashMap<Long, Long>();
		for(int i=0; i<n; i++) { // n의 최대값은 100,000(int 범위 안)
			long key = sc.nextLong();
			long value = hashMap.getOrDefault(key, 0L) + 1L;
			hashMap.put(key, value);
			
			// 최대 중복 값에 대한 key값 업데이트
			if(value >= maxCnt) {
				if(value > maxCnt) {
					maxCnt = value;
					maxNum = key;
				} else
				// 중복 수가 같은 경우
				if(value == maxCnt) {
					if(key < maxNum) maxNum = key;		
				}
			}
			
			System.out.println(hashMap);
		}
		sc.close();

		System.out.println(maxNum);
	}

}