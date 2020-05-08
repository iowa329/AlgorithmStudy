package practice;

import java.util.Scanner;

public class SWMaestroExam03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		
		int[] arr = new int[n];
		for(int i=0; i<n; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		
		int penalty = arr[(n-1)-(k-1)] - arr[0];
		
		System.out.print(penalty);
	}

}