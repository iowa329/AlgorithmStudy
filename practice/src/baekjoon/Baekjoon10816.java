package baekjoon;

import java.io.*;
import java.util.*;

public class Baekjoon10816 {

	public static void main(String[] args) throws IOException {
		// 방법1 자료구조(HashMap) 이용
		
		// 값 입력받기
//        Scanner sc = new Scanner(System.in);
//        
//        // 카드의 개수
//        int n = sc.nextInt();
//        // HashMap
//        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
//        for(int i=0; i<n; i++) {
//        	int key = sc.nextInt();
//        	System.out.println("key: " + key);
//        	
//        	hashMap.put(key, hashMap.getOrDefault(key, 0) + 1);
//        	
//        	System.out.println("hashMap: " + hashMap.get(key));
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
		
		
		
		// 방법2 이분탐색 이용
	
		// 값 입력받기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 카드의 개수
        int n = Integer.parseInt(br.readLine());
        int[] cardList = new int[n];
        
        String[] cards = br.readLine().split(" ");
        for(int i=0; i<n; i++) {
        	cardList[i] = Integer.parseInt(cards[i]);
        }
        
        // 이분탐색을 위해서는 정렬 필수
        Arrays.sort(cardList);
        System.out.println(Arrays.toString(cardList));

        StringBuilder sb = new StringBuilder();
        
        // 몇 개 가지고 있는지 확인하는 숫자
        int m = Integer.parseInt(br.readLine());
        cards = br.readLine().split(" ");
        for(int i=0; i<m; i++) {
        	int card = Integer.parseInt(cards[i]);

        	System.out.println("card>> " + card);
        	
        	int lowest = findLowestIndex(cardList, card);
        	int highest = findHighestIndex(cardList, card);

        	int count = highest - lowest;
        	
        	System.out.println();
        	
        	sb.append(count + " ");
        }
        br.close();
        
        System.out.println(sb.toString());
	}

	// 찾고자 하는 카드 중 가장 낮은 index 찾기
	private static int findLowestIndex(int cardList[], int card) {
		int lower = 0;
		int higher = cardList.length;
		
		while (lower < higher) { // 하한과 상한이 같아질 때(하한이 상한보다 높을 수는 없으므로) 탐색을 종료
			int mid = (lower + higher) / 2;
			
			if(card <= cardList[mid]) { // key값이 중앙값보다 같거나 작을 때  
				higher = mid;
			} else {
				// key값이 중앙값보다 클 때
				lower = mid + 1;
			}
		}
		
		System.out.println("lowest: " + lower);
		return lower;
	}
	
	// 찾고자 하는 카드 중 가장 높은 index 찾기
	private static int findHighestIndex(int cardList[], int card) {
		int lower = 0;
		int higher = cardList.length;
		
		while (lower < higher) { // 하한과 상한이 같아질 때(하한이 상한보다 높을 수는 없으므로) 탐색을 종료
			int mid = ((lower + higher) / 2);// + ((lower + higher) % 2);
			
			if(card < cardList[mid]) { // key값이 중앙값보다 작을 때  
				higher = mid;
			} else {
				// key값이 중앙값보다 클 때
				lower= mid + 1;
			}
		}
		
		System.out.println("highest: " + higher);
		return lower;
	}
}














