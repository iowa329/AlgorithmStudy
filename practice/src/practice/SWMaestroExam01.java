package practice;

import java.util.Scanner;

public class SWMaestroExam01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		String result = "";
		
		int cnt = n/2;
		if(n%2 == 0) {
			for(int i=1; i<=cnt; i++) {
				result = result + "1";
			}
		} else {
			cnt--;
			result = result + "7";
			for(int i=1; i<=cnt; i++) {
				result = result + "1";
			}
		}
		
		System.out.println(result);
	}

}
