package baekjoon;

import java.util.*;

public class Baekjoon10816 {

	public static void main(String[] args) {
		// 값 입력받기
        Scanner sc = new Scanner(System.in);
        
        // 카드의 개수
        int n = sc.nextInt();
        // HashMap
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
        for(int i=0; i<n; i++) {
        	int key = sc.nextInt();
        	System.out.println("key: " + key);
        	
        	hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
        	
        	System.out.println("treeMap: " + hashMap.get(key));
        }
        
        
        StringBuilder sb = new StringBuilder();
        
        // 몇 개 가지고 있는지 확인하는 숫자
        int m = sc.nextInt();
        for(int i=0; i<m; i++) {
        	int key = sc.nextInt();
        	sb.append(hashMap.getOrDefault(key, 0) + " ");
        }
        sc.close();
        
        System.out.println(sb.toString());
	}

}


// 제출코드

//import java.util.*;
//
//public class Main {
//
//	public static void main(String[] args) {
//		// 값 입력받기
//        Scanner sc = new Scanner(System.in);
//        
//        // 카드의 개수
//        int n = sc.nextInt();
//        // HashMap
//        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
//        for(int i=0; i<n; i++) {
//        	int key = sc.nextInt();
//        	hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
//        }
//        
//        
//        StringBuilder sb = new StringBuilder();
//        
//        // 몇 개 가지고 있는지 확인하는 숫자
//        int m = sc.nextInt();
//        for(int i=0; i<m; i++) {
//        	int key = sc.nextInt();
//        	sb.append(hashMap.getOrDefault(key, 0) + " ");
//        }
//        sc.close();
//        
//        System.out.println(sb.toString());
//	}
//
//}