package practice;

import java.util.Scanner;

public class Baekjoon2798 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cardCnt = sc.nextInt();
		int max = sc.nextInt();
		
		int[] card = new int[cardCnt];
		for(int i=0; i<cardCnt; i++) {
			card[i] = sc.nextInt();
		}
		sc.close();
		
		// 입력된 카드 값 출력
		for(int i=0; i<cardCnt; i++) {
			System.out.print(card[i] + " ");
		}
		System.out.println("");
		
		int closer = 0;
		
		int sum = 0;
		for(int j=0; j < cardCnt-2; j++) {
			for(int q=j+1; q < cardCnt-1; q++) {
				for(int k=q+1; k < cardCnt ; k++) {
					sum = card[j] + card[q] + card[k];
					if(sum <= max)
						if(sum > closer)
							closer = sum;
				}
			}
		}
		System.out.print(closer);
	}

}


