package baekjoon;

import java.util.*;

public class Baekjoon2231 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.close();
		
		// 간단한 탐색 방법
		int result = 0;
		for(int searchNumber=1; searchNumber<=n; searchNumber++) {
			int searchTarget = searchNumber;
			int sum = searchNumber;
			while(searchTarget > 0) {
				sum += searchTarget%10;
				searchTarget /= 10;
			}
			if (sum == n) {
				result = searchNumber;
				break;
			}
		}
		
		System.out.println(result);
		
		
		
		
//		Stack<Integer> splitNumber = new Stack<Integer>();
//		// 주어진 숫자 분해
//		splitNumber(n, splitNumber);
//		
//		System.out.println(splitNumber.peek() + ", size : " +  splitNumber.size());
//		System.out.println(splitNumber);
//		System.out.println(n);
//		
//		int result = findConstructorNumber(n, splitNumber.size(), splitNumber);
//		
//		System.out.println("생성자 : " + result);
	}
	
	// 개별 수로 숫자 분해하기
	public static void splitNumber(int number, Stack<Integer> splitedNumber) {
        if(number > 0) {
        	splitedNumber.add(number%10);
            splitNumber(number/10, splitedNumber);
        }
    }
	
	// 생성자 찾아내기
	public static int findConstructorNumber(int originalNumber, int numberSize, Stack<Integer> splitedNumber) {
		int range = (numberSize-1) * 9 + splitedNumber.peek();
		
		int startNumber = originalNumber - range;
		for(int i = startNumber; i <= originalNumber; i++) {
			splitedNumber.clear();
			splitNumber(i, splitedNumber);
			
			System.out.println(i + ", " + splitedNumber);
			
			int sum = i;
			int searchCount = splitedNumber.size() - 1;
			for(int j=0; j<=searchCount; j++) {
				System.out.println("꺼냄 : " + splitedNumber.peek());
				sum += splitedNumber.pop();
			}
			System.out.println("합 : " + sum);
			
			if (sum == originalNumber) {
				return i;
			}
		}
		
		return 0;
	}
	
}
