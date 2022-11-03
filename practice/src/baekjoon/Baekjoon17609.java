package baekjoon;

import java.io.*;

// 구현 3(구현 2 개선 - 약간의 개선, 구현 1,2보다 적은 메모리 30~40 ms의 시간 단축)
//public class Baekjoon17609 {
//	
//	static String str;
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int t = Integer.parseInt(br.readLine());
//		
//		for(int i=0; i<t; i++) {
//			str = br.readLine();
//			System.out.println(isPalindrome(0, str.length()-1, false));
//		}
//		br.close();
//	}
//
//	private static int isPalindrome(int left, int right, boolean isAfterRemove) {
//		while(left < right) {
//			if(str.charAt(left) != str.charAt(right)) {
//				if(isAfterRemove == false) {
//					int removeLeft = isPalindrome(left+1, right, true);
//					int removeRight = isPalindrome(left, right-1, true);
//					
//					return (removeLeft == 2 && removeRight == 2) ? 2 : 1;					
//				} else {
//					return 2;
//				}
//			}
//			
//			left++;
//			right--;
//		}
//		
//		return 0;
//	}
//	
//}


// 구현 2(구현 1 개선방안...? 이 안된듯 - 메모리 더 사용, 시간 12ms 감소)

public class Baekjoon17609 {
	
	static String str;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		
		for(int i=0; i<t; i++) {
			str = br.readLine();
			System.out.println(isPalindrome(0, str.length()-1));
		}
		br.close();
	}

	private static int isPalindrome(int left, int right) {
		while(left < right) {
			if(str.charAt(left) != str.charAt(right)) {
				boolean removeLeft = isPalindromeAfterRemove(left+1, right);
				boolean removeRight = isPalindromeAfterRemove(left, right-1);
				
				return (removeLeft == false && removeRight == false) ? 2 : 1;
			}
			
			left++;
			right--;
		}
		
		return 0;
	}
	
	private static boolean isPalindromeAfterRemove(int left, int right) {
		while(left < right) {
			if(str.charAt(left) != str.charAt(right)) return false;
			
			left++;
			right--;
		}
		
		return true;
	}
	
}


// 구현 1

//public class Baekjoon17609 {
//	
//	static String str;
//	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int t = Integer.parseInt(br.readLine());
//		
//		for(int i=0; i<t; i++) {
//			str = br.readLine();
//			
//			int left = 0;
//			int right = str.length()-1;
//			
//			int result = 0;
//			if(isPalindrome(left, right) == false)
//				result = isPalindromeAfterRemove(left, right) ? 1 : 2;
//			
//			System.out.println(result);
//		}
//		br.close();
//	}
//
//	private static boolean isPalindrome(int compareL, int compareR) {
//		while(compareL < compareR) {
//			if(str.charAt(compareL) != str.charAt(compareR)) {
//				return false;
//			}
//			
//			compareL++;
//			compareR--;
//		}
//		
//		return true;
//	}
//	
//	private static boolean isPalindromeAfterRemove(int compareL, int compareR) {
//		while(compareL < compareR) {
//			if(str.charAt(compareL) != str.charAt(compareR)) {
//				boolean removeLeft = isPalindrome(compareL+1, compareR);
//				boolean removeRight = isPalindrome(compareL, compareR-1);
//				
//				return (removeLeft == false && removeRight == false) ? false : true;
//			}
//			
//			compareL++;
//			compareR--;
//		}
//		
//		return true;
//		
//		
//	}
//	
//}