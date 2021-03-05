package baekjoon;

import java.util.LinkedList;
import java.util.Scanner;

public class Baekjoon2231 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		LinkedList<Integer> splitNumber = new LinkedList<Integer>();
		// 주어진 숫자 분해
		splitNumber(n, splitNumber);
		
	}
	
	// 개별 수로 숫자 분해하기
	public static void splitNumber(int number, LinkedList<Integer> splitedNumber) {
        if(number > 0) {
        	splitedNumber.add(number%10);
            splitNumber(number/10, splitedNumber);
            System.out.println("split target: " + number%10 + " splitedNumber: " + splitedNumber);
        }
    }
	
}
