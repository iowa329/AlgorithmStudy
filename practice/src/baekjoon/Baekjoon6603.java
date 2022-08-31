package baekjoon;

import java.util.*;

public class Baekjoon6603 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			int k = sc.nextInt();
			if(k == 0) break;
			
			int[] lotto = new int[k];
			for(int i=0; i<k; i++) {
				lotto[i] = sc.nextInt();
			}
			System.out.println("\n입력받은 배열: " + Arrays.toString(lotto));
			
			// first line
//			for(int i=0; i<k; i++) {
//				System.out.print(lotto[i] + " ");				
//			}
//			System.out.println();
			
			// start pattern
//			int depth = k-6;
//			int eraseCnt = 1;

			
			int conquer = 0;
			int depth = k-6;
			int depthCnt = 0;
			while(conquer < 6) {
					
				
				
				
				
//				System.out.println(">>> " + conquer + " " + depthCnt);
				
				for(int i=0; i<6; i++) {
					if (i >= 5-conquer) {
						if (i != 5) { // 마지막 인덱스가 아닌 경우에만
							System.out.print(lotto[i+1] + " ");							
						} else {
							System.out.print(lotto[i+depthCnt] + " ");
							depthCnt++;
						}
					} else {
						System.out.print(lotto[i] + " ");				
					}
					
				}
				System.out.println();
				
				
				if(depthCnt > depth) {
					depthCnt = 1;
					conquer++;
					System.out.println();
				}
				
			}
			
			
			
		}
		sc.close();
		
	}

}
