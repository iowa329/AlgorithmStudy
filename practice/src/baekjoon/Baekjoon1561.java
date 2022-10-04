package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon1561 {

	static int n, m;
	static int[] rideTimes;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(strTkr.nextToken()); // 아이들
		m = Integer.parseInt(strTkr.nextToken()); // 놀이기구들
		
		// m개의 놀이기구 운행시간 입력받기
		strTkr = new StringTokenizer(br.readLine());
		rideTimes = new int[m+1]; // 입력순으로 놀이기구 번호이기 때문에 0 제외하기 위해 +1 배열 생성 
		for(int i=1; i<=m; i++) {
			rideTimes[i] = Integer.parseInt(strTkr.nextToken());
		}
		br.close();

		
		// 마지막 탑승기구번호 탐색시작
		long lastRideNumber = 0;
		long timeAllKidsRide = 0;
		
		if(n <= m) {
			// 만약 탑승인원이 놀이기구 수보다 같거나 적은 경우
			lastRideNumber = n;
		} else {
			// 탑승인원이 놀이기구 보다 많은 경우 전체 탑승시간 이분탐색
			timeAllKidsRide = binarySearch();
			
			// 전원 탑승 직전시간(1분 전) 아이들 수
			long leftKids = n - howManyKidsInTime(timeAllKidsRide - 1);
			
			System.out.println("마지막 시간에 탑승하는 아이들 수>> " + leftKids);
			
			// 마지막 시간에 탑승하는 인원 기준으로 최종 탑승기구 번호 탐색
			long rideKidsLastTime = 0;
			for(int i=1; i<=m; i++) {
                // 직전 탑승 시간과 마지막 탑승 시간과 비교하여 몫이 다른경우 마지막 시간일 때 탑승 행위가 일어난다는 의미이므로
				if(timeAllKidsRide / rideTimes[i] != (timeAllKidsRide - 1) / rideTimes[i]) {
					rideKidsLastTime++;
				}
				
				if(rideKidsLastTime == leftKids) {
					lastRideNumber = i;
					
					break;
				}
			}
		}
		
		// 결과
		System.out.print(lastRideNumber);
		
	}

	// 이분탐색
	private static long binarySearch() {
		long min = 0;
		long max = 2000000000L * 30L; // 최대 탑승인원 x 최대 기구운영 시간
		
		long timeAllKidsRide = 0;
		while(min <= max) {
			long mid = (min + max) / 2;
			
			System.out.println(min + " " + mid + " " + max + " ");
			
			// mid(시간) 기준 탈 수 있는 인원수
			if(howManyKidsInTime(mid) >= n) {
				// 기준 시간(mid) 동안 모두 탈 수 있다면
				timeAllKidsRide = mid;
				max = mid - 1; // 더 적은 시간(mid) 동안 모두가 탈 수 없는지 확인한다
			} else {
				// 기준 시간(mid) 동안 모두 탈 수 없다면
				min = mid + 1;
			}
		}
		
		System.out.println("전부 탑승하는데 걸린 시간 : " + timeAllKidsRide);
		
		return timeAllKidsRide;
	}
	
	private static long howManyKidsInTime(long time) {
		long kids = m; // 맨 처음에는 m개의 놀이기구에 전부 탑승
		for(int i=1; i<=m; i++) {
			// (시간 / 탑승시간)의 몫은 해당 시간(time)에 대해 탑승가능한 총 인원이다
			kids += time / rideTimes[i];
		}
		
		return kids;
	}
	
}