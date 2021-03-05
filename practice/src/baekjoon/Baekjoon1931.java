package baekjoon;

import java.util.Scanner;

public class Baekjoon1931 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cnt = sc.nextInt();
		
		// 일정표 입력 받기
		int[][] meeting = new int[cnt][2];		
		for(int i=0; i<cnt; i++) {
			meeting[i][0] = sc.nextInt();
			meeting[i][1] = sc.nextInt();
		}
		sc.close();
		
//		for(int i=0; i<cnt; i++) {
//			timeTable = meeting[i][1];
//			System.out.print("일정" + (i+1) + ": " + meeting[i][0] + " " + meeting[i][1]);
//			for(int j=i; j<cnt; j++){
//				if(meeting[j][0] >= timeTable) {
//					timeTable = meeting[j][1];
//					System.out.print(" --> " + meeting[j][0] + " " + meeting[j][1]);
//					meets++;
//				}
//			}
//			schedule[i] = meets;
//			System.out.println(" // 잡은 일정 개수 : " + schedule[i] + " ");
//			meets = 1;
//			if(schedule[i] > bestSchedule)
//				bestSchedule = schedule[i];
//		}
		
		
		int hours = 0;
		int pos = 0;
		// 입력받은 일정표 정렬하기
		while(hours<24) {

			while(pos<cnt) {
				for(int i=0; i<cnt; i++) {
					if(meeting[i][0] == hours) {
						int tmp = meeting[pos][0];
						meeting[pos][0] = meeting[i][0];
						meeting[i][0] = tmp;
						System.out.print(meeting[i][0] + " ");
						i = cnt;
					}
				}
				pos++;
			}
			
			hours++;
		}
		
		
		for(int i=0; i<cnt; i++) {
			System.out.print(meeting[i][0] + " ");
			System.out.println(meeting[i][1]);
		}
		
//		int bestSchedule = 0;
//		int timeTable = 0;
//		int meets = 0;
//		
//		hours = 0;
//		while(hours<24) {
//			
//			for(int i=0; i<cnt; i++) {
//				if(hours == meeting[i][0]) {
//					timeTable = meeting[i][1];
//					meets++;
//					System.out.print(hours + "hours: " + meeting[i][0] + " " + meeting[i][1]);
//					
//					for(int j=0; j<cnt; j++){
//						if(meeting[j][0] >= timeTable) {
//							timeTable = meeting[j][1];
//							System.out.print(" --> " + meeting[j][0] + " " + meeting[j][1]);
//							meets++;
//							
//							
//						}
//					}
//					System.out.println(" // 잡은 일정 개수 : " + meets + " ");
//					if(meets > bestSchedule)
//						bestSchedule = meets;
//					meets = 0;
//				}
//
//			}
//			hours++;
//			
//		}
//		
//		System.out.println("");
//		System.out.println(bestSchedule);
	}

}