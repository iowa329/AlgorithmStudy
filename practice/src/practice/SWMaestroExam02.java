package practice;

import java.util.Scanner;

public class SWMaestroExam02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int test = sc.nextInt();
		System.out.println("");
		
		System.out.println(test);
		
		int getTest = 1;
		while(getTest<=test) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			System.out.println(n + " " + m);
			
			int[][] tile = new int[n][m];
			for(int i=0; i<n; i++) {
				for(int j=0; j<m; j++) {
					tile[i][j] = sc.nextInt();
					System.out.print(tile[i][j] + " ");
				}
				System.out.println("");
			}
			
			// 정사각형 유무 판단
			if (n == m) {
				// 2의 배수 타일 여부 판단
				if(n%2 == 0 && m%2 == 0) {
					
				} else {
					
				}
			} else {
				
			}
					
			
			
			
			
			
			
			getTest++;
			System.out.println("");
		}
		sc.close();
	}

}
