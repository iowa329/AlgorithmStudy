package line;

import java.util.*;

public class liner22_exam_01 {
	
	public static void main(String[] args) {
		int[][] queries = 
				{{2, 10}, {7, 1}, {2, 5}, {2, 9}, {7, 32}};
//				{{1, 1}, {1, 2}, {1, 4}, {1, 8}};
		
		int answer = solution(queries);
		System.out.println(answer);
	}
	
	
	public static int solution(int[][] queries) {
		// 복사가 일어난 횟수
        int answer = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
		for(int i=0; i<queries.length; i++) {
			int key = queries[i][0];
			
			int originValue = hashMap.getOrDefault(key, 0);
			int curValue = queries[i][1];
			
			
			System.out.println(key);
			System.out.println(originValue);
			System.out.println(curValue + "\n");
			
			
			// 최초로 배열을 생성 할 경우
			if(originValue == 0) {
				hashMap.put(key, curValue);
			} else 
			// 배열에 원소를 추가 할 경우
			{
				int arrSize = getArrSize(originValue);
				int newValue = originValue + curValue;

				System.out.println("size>>> " + arrSize + "\n");
				
				// 배열 크기를 늘려야 하는 경우
				if(newValue > arrSize) {
					// 복사발생
					answer += originValue;
					
					System.out.println("<<<copied " + answer);
				}
				
				// 새로운 크기의 값으로 갱신
				hashMap.put(key, newValue);
			}
		}
        
        return answer;
    }
	
	// 해당 key의 배열 크기 계산
	public static int getArrSize(int originValue) {
		int arrSize = 0;
		for(int m=0; ; m++) {
			arrSize = (int)Math.pow(2, m);
			if(arrSize >= originValue) return arrSize;
		}
	}
	
}


// 제출코드

//import java.util.*;
//
//class Solution {
//    public int solution(int[][] queries) {
//        // 복사가 일어난 횟수
//        int answer = 0;
//
//        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();
//		for(int i=0; i<queries.length; i++) {
//			int key = queries[i][0];
//			
//			int originValue = hashMap.getOrDefault(key, 0);
//			int curValue = queries[i][1];
//			
//			// 최초로 배열을 생성 할 경우
//			if(originValue == 0) {
//				hashMap.put(key, curValue);
//			} else 
//			// 배열에 원소를 추가 할 경우
//			{
//				int arrSize = getArrSize(originValue);
//				int newValue = originValue + curValue;
//
//				// 배열 크기를 늘려야 하는 경우
//				if(newValue > arrSize) {
//					// 복사발생
//					answer += originValue;
//				}
//				
//				// 새로운 크기의 값으로 갱신
//				hashMap.put(key, newValue);
//			}
//		}
//        
//        return answer;
//    }
//	
//	// 해당 key의 배열 크기 계산
//	public int getArrSize(int originValue) {
//		int arrSize = 0;
//		for(int m=0; ; m++) {
//			arrSize = (int)Math.pow(2, m);
//			if(arrSize >= originValue) return arrSize;
//		}
//	}
//}