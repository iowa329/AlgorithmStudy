package practice;

import java.util.Scanner;

public class SWMaestroTest01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int numsCnt = sc.nextInt();
		int range = sc.nextInt();
		
//		sc = new Scanner(System.in);
		int[] nums = new int[numsCnt];
		for(int i=0; i<numsCnt; i++) {
			nums[i] = sc.nextInt();
		}
		
		// 위치 index 출력
		for(int i=1; i<=numsCnt; i++) {
			System.out.print(i + " ");
		}
		System.out.println("");
		
		// 입력된 값 출력
		for(int i=0; i<numsCnt; i++) {
			System.out.print(nums[i] + " ");
		}
		System.out.println("");
		
		// 최소값 '1'의 위치 찾기
		int minPos = 0;
		for(int i=0; i<numsCnt; i++) {
			if (nums[i] == 1) {
				minPos = i + 1;
			}
		}
		System.out.println("minIndex : " + minPos);
		
		int cntMakeSame = 0;
		int startToMin = 0;
		int minToEnd = 0;
		int startToPos = 0;
		int posToEnd = 0;
		int pos = 0;
		int i = 0; Boolean check = true;
		
		if (minPos == 1 || minPos == numsCnt) {
			// 1의 위치가 맨 앞에 있거나 맨 뒤에 있을 때
			cntMakeSame += 1;
			cntMakeSame += (numsCnt-range)/(range-1);
			if ((numsCnt-range)%(range-1) != 0)
				cntMakeSame += 1;
		} else if (1 < minPos && minPos <= numsCnt/2) {
			// 1의 위치가 앞쪽으로 치우쳐져 있을때
			minToEnd = numsCnt - minPos + 1;
			i=0; check = true;
			while (check) {
				if ( (range + ((range-1) * i) ) >= minToEnd) { // 1에 닿았을 경우
					cntMakeSame += (i + 1);
					pos = numsCnt - ( range + ((range-1) * i) ) + 1;
					check = false;
				}
				i++;
			}
			
			if (pos > 1) {
				startToPos = pos;
				if (startToPos <= range) {
					cntMakeSame += 1;
				} else {
					i=1; check = true;
					while (check) {
						if ( (range + ((range-1) * i) ) >= startToPos) { // 맨 앞에 닿았을 경우
							cntMakeSame += (i + 1);
							check = false;
						}
						i++;
					}
				}
			}
		} else if (numsCnt/2 < minPos && minPos < numsCnt) {
			// 1의 위치가 가운데나 뒷쪽으로 치우쳐져 있을때
			startToMin = minPos;
			i=0; check = true;
			while (check) {
				if ( (range + ((range-1) * i) ) >= startToMin) { // 1에 닿았을 경우
					cntMakeSame += (i + 1);
					pos = ( range + ((range-1) * i) );
					check = false;
				}
				i++;
			}
			
			if (pos < numsCnt) {
				posToEnd = numsCnt - pos + 1;
				if (posToEnd <= range) {
					cntMakeSame += 1;
				} else {
					i=1; check = true;
					while (check) {
						if ( (range + ((range-1) * i) ) >= posToEnd) { // 맨 뒤에 닿았을 경우
							cntMakeSame += (i + 1);
							check = false;
						}
						i++;
					}
				}
			}
		}
		
		System.out.println("전염에 필요한 최소 횟수 : " + cntMakeSame);
	}
}


// 다른 간단한 버전

//import java.util.Scanner;
//
//public class Main {
//
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int numsCnt = sc.nextInt();
//		int range = sc.nextInt();
//		
//		// sc = new Scanner(System.in);
//		// int[] nums = new int[numsCnt];
//		// for(int i=0; i<numsCnt; i++) {
//		// 	nums[i] = sc.nextInt();
//		// }
//		
//		int cntMakeSame = 0;
//		int left = numsCnt - range;
//		cntMakeSame++;
//		
//		if(left > 0) {
//		
//			if (left >= range) {
//				cntMakeSame += left/(range-1);
//				if (left%(range-1) != 0)
//					cntMakeSame++;
//			} else {
//				cntMakeSame++;
//			}
//		
//		}
//		
//		System.out.println(cntMakeSame);
//	}
//}