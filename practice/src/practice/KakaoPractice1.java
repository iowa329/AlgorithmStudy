package practice;

import java.util.Scanner;

public class KakaoPractice1 {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] pos = new int[1][3];
		
		for(int i=0; i<3; i++) {
			pos[1][i] = sc.nextInt();
			System.out.println(pos[1][i]);
		}
	}
	
}