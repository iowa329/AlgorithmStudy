package baekjoon;

import java.util.*;

public class Baekjoon1074 {

	static int count = 0;

    public static void main(String[] args) {    	
        // 값 입력받기
        Scanner sc = new Scanner(System.in);
    		
        int n = sc.nextInt();

        int r = sc.nextInt();
        int c = sc.nextInt();

		sc.close();
		
		// r행 c열 번호탐색
        findNumber((int)Math.pow(2, n), r, c);
        System.out.println(count);
	}

	// divide and conquer
    private static void findNumber(int size, int r, int c) {
        // 최종 위치에 도착
        if(size == 1) {
            return;
        }
        
        size /= 2;
        // 왼쪽 위
        if(r < size && c < size) {
            count += size * size * 0;
            findNumber(size, r, c);
        } else

        // 오른쪽 위
        if(r < size && c >= size) {
            count += size * size * 1;
            findNumber(size, r, c - size);
        } else

        // 왼쪽 아래
        if(r >= size && c < size) {
            count += size * size * 2;
            findNumber(size, r - size, c);
        } else

        // 오른쪽 아래
        if(r >= size && c >= size) {
            count += size * size * 3;
            findNumber(size, r - size, c - size);
        }
    }
}


// 제출코드

//import java.util.*;
//
//public class Main {
//
//	static int count = 0;
//
//    public static void main(String[] args) {    	
//        // 값 입력받기
//        Scanner sc = new Scanner(System.in);
//    		
//        int n = sc.nextInt();
//
//        int r = sc.nextInt();
//        int c = sc.nextInt();
//
//		sc.close();
//		
//		// r행 c열 번호탐색
//        findNumber((int)Math.pow(2, n), r, c);
//        System.out.println(count);
//	}
//
//	// divide and conquer
//    private static void findNumber(int size, int r, int c) {
//        // 최종 위치에 도착
//        if(size == 1) {
//            return;
//        }
//        
//        size /= 2;
//        // 왼쪽 위
//        if(r < size && c < size) {
//            count += size * size * 0;
//            findNumber(size, r, c);
//        } else
//
//        // 오른쪽 위
//        if(r < size && c >= size) {
//            count += size * size * 1;
//            findNumber(size, r, c - size);
//        } else
//
//        // 왼쪽 아래
//        if(r >= size && c < size) {
//            count += size * size * 2;
//            findNumber(size, r - size, c);
//        } else
//
//        // 오른쪽 아래
//        if(r >= size && c >= size) {
//            count += size * size * 3;
//            findNumber(size, r - size, c - size);
//        }
//    }
//}