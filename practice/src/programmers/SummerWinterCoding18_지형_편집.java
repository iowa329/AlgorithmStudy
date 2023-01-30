package programmers;

import java.util.*;

public class SummerWinterCoding18_지형_편집 {

	public static void main(String[] args) {
//		int[][] land = {{1, 2}, {2, 3}}; int P = 3; int Q = 2;
		int[][] land = {{4, 4, 3}, {3, 2, 2}, {2, 1, 0}}; int P = 5; int Q = 3;
		
		System.out.print(solution(land, P, Q));
	}
	
	// 구현3
	// land 배열을 기준으로 1차원 배열 변환 뒤 높이 기준 반복문을 수행하는 방법(시간복잡도 최대 300 * 300)
	
//	정확성  테스트
//	테스트 1 〉	통과 (0.41ms, 64.9MB)
//	테스트 2 〉	통과 (0.48ms, 79.4MB)
//	테스트 3 〉	통과 (0.41ms, 72.3MB)
//	테스트 4 〉	통과 (0.50ms, 73.8MB)
//	테스트 5 〉	통과 (0.52ms, 74.1MB)
//	테스트 6 〉	통과 (0.54ms, 77.8MB)
//	테스트 7 〉	통과 (0.52ms, 74.2MB)
//	테스트 8 〉	통과 (0.58ms, 76.9MB)
//	테스트 9 〉	통과 (0.38ms, 77.2MB)
//	테스트 10 〉	통과 (0.38ms, 72.4MB)
//	테스트 11 〉	통과 (0.59ms, 73.2MB)
//	테스트 12 〉	통과 (0.69ms, 86.3MB)
//	테스트 13 〉	통과 (0.91ms, 83.9MB)
//	테스트 14 〉	통과 (1.71ms, 77.9MB)
//	테스트 15 〉	통과 (3.86ms, 83MB)
//	테스트 16 〉	통과 (5.31ms, 81.1MB)
//	테스트 17 〉	통과 (4.09ms, 83.5MB)
//	테스트 18 〉	통과 (4.45ms, 84.1MB)
//	테스트 19 〉	통과 (6.94ms, 90.1MB)
//	테스트 20 〉	통과 (7.51ms, 79.8MB)
//	테스트 21 〉	통과 (0.44ms, 74.6MB)
//	테스트 22 〉	통과 (0.36ms, 76.2MB)
//	테스트 23 〉	통과 (0.44ms, 76.1MB)
//	테스트 24 〉	통과 (0.42ms, 75.5MB)
//	테스트 25 〉	통과 (0.44ms, 72.3MB)
//	테스트 26 〉	통과 (0.39ms, 78.4MB)
//	테스트 27 〉	통과 (0.54ms, 73MB)
//	테스트 28 〉	통과 (0.43ms, 80.8MB)
//	테스트 29 〉	통과 (0.49ms, 75.2MB)
//	테스트 30 〉	통과 (0.55ms, 79.5MB)
//	테스트 31 〉	통과 (0.61ms, 86.3MB)
//	테스트 32 〉	통과 (0.51ms, 74.1MB)
	
//	효율성  테스트
//	테스트 1 〉	통과 (40.20ms, 58.9MB)
//	테스트 2 〉	통과 (69.97ms, 60.2MB)
//	테스트 3 〉	통과 (38.31ms, 60.3MB)
//	테스트 4 〉	통과 (19.61ms, 57.3MB)
//	테스트 5 〉	통과 (24.08ms, 60MB)
//	테스트 6 〉	통과 (14.11ms, 56.9MB)
//	테스트 7 〉	통과 (10.12ms, 56.7MB)
//	테스트 8 〉	통과 (58.09ms, 57.9MB)
	
//	채점 결과
//	정확성: 69.0
//	효율성: 31.0
//	합계: 100.0 / 100.0
	
	public static long solution(int[][] land, int P, int Q) {
		int n = land.length;
		int heightCnt = n * n;
        
        // 2차원 land 배열 1차원 landInfo로 변환
		int[] landInfo = new int[heightCnt];
        long totalBlocks = 0;
        for(int i=0; i<n; i++) {
        	for(int j=0; j<n; j++) {
        		int height = land[i][j];
        		
        		landInfo[(i*n)+j] = height;
        		totalBlocks += height;
        	}
        }
        // 높이정보 오름차순 정렬
        Arrays.sort(landInfo);
        
        long answer = Long.MAX_VALUE;
        
        long beforeHeight = -1; // curHeight가 long형으로 선언되었기 때문에 같이 long형으로 선언
        long accumulatedBlocks = 0;
        for(int i=0; i<heightCnt; i++) {
        	long curHeight = landInfo[i]; // int형 대신 long형으로 선언
        	
        	// 높이가 달라질 때(블록의 높이가 평평해질 때) 비용 계산
        	if(curHeight != beforeHeight) {
        		beforeHeight = curHeight;
        		
        		// 추가할 블록 비용 계산
        		long blocksToAdd = i * curHeight;
        		blocksToAdd -= accumulatedBlocks;
        		long costAdd = blocksToAdd * P;
        		
        		// 제거할 블록 비용 계산
        		long blocksToRemove = totalBlocks - accumulatedBlocks;
        		// curHeight가 long형 대신 int형으로 선언되면 이 부분 연산과정에서 int형 값이 들어가 마지막 테스트케이스에서 오류가 나는 것으로 추정
        		// (long)형으로 캐스팅 할 경우 마지막 테스트케이스는 통과하지만 효율성 테스트에서 실패함
        		blocksToRemove -= (heightCnt - i) * curHeight;
        		long costRemove = blocksToRemove * Q;
        		
        		long curCost = costAdd + costRemove;
    			// 최소비용 갱신
        		answer = Math.min(answer, curCost);
        	}
        	
        	accumulatedBlocks += curHeight;
        }
        
        return answer;
    }
	
	// 구현1 int형 배열 10억 할당
	// 실패 - 테스트케이스에서 메모리 초과 실패
	
	// 구현2 HashMap 사용
	// 실패 - 효율성 실패, 시간 초과
	
//	정확성  테스트
//	테스트 1 〉	통과 (0.13ms, 85MB)
//	테스트 2 〉	통과 (0.18ms, 87.6MB)
//	테스트 3 〉	통과 (0.31ms, 75.2MB)
//	테스트 4 〉	통과 (0.25ms, 73.3MB)
//	테스트 5 〉	통과 (0.14ms, 75.9MB)
//	테스트 6 〉	통과 (0.18ms, 77.8MB)
//	테스트 7 〉	통과 (0.10ms, 76.4MB)
//	테스트 8 〉	통과 (4.85ms, 71MB)
//	테스트 9 〉	통과 (0.13ms, 66.9MB)
//	테스트 10 〉	통과 (0.24ms, 72.3MB)
//	테스트 11 〉	통과 (1.07ms, 74.8MB)
//	테스트 12 〉	통과 (4.54ms, 77.9MB)
//	테스트 13 〉	통과 (7.16ms, 82.8MB)
//	테스트 14 〉	통과 (10.88ms, 67.2MB)
//	테스트 15 〉	통과 (72.30ms, 80.3MB)
//	테스트 16 〉	통과 (30.36ms, 90.6MB)
//	테스트 17 〉	통과 (31.03ms, 94.2MB)
//	테스트 18 〉	통과 (29.36ms, 84.6MB)
//	테스트 19 〉	통과 (32.48ms, 79.6MB)
//	테스트 20 〉	통과 (40.46ms, 80.5MB)
//	테스트 21 〉	통과 (0.16ms, 74.1MB)
//	테스트 22 〉	통과 (0.32ms, 83.2MB)
//	테스트 23 〉	통과 (0.16ms, 68.5MB)
//	테스트 24 〉	통과 (0.15ms, 81.2MB)
//	테스트 25 〉	통과 (0.18ms, 80.9MB)
//	테스트 26 〉	통과 (0.25ms, 75.7MB)
//	테스트 27 〉	통과 (0.21ms, 72.1MB)
//	테스트 28 〉	통과 (0.15ms, 73.2MB)
//	테스트 29 〉	통과 (0.19ms, 75.9MB)
//	테스트 30 〉	실패 (시간 초과)
//	테스트 31 〉	통과 (0.39ms, 66MB)
//	테스트 32 〉	실패 (시간 초과)
	
//	효율성  테스트
//	테스트 1 〉	실패 (시간 초과)
//	테스트 2 〉	실패 (시간 초과)
//	테스트 3 〉	실패 (시간 초과)
//	테스트 4 〉	실패 (시간 초과)
//	테스트 5 〉	실패 (시간 초과)
//	테스트 6 〉	실패 (시간 초과)
//	테스트 7 〉	실패 (시간 초과)
//	테스트 8 〉	실패 (시간 초과)
	
//	채점 결과
//	정확성: 64.7
//	효율성: 0.0
//	합계: 64.7 / 100.0
	
//	public static long solution(int[][] land, int P, int Q) {
//        int n = land.length;
//        int area = n * n;
//        
//        // 해당 높이로 쌓아올려진 블럭의 개수 확인
//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        int maxHeight = 0;
//        for(int i=0; i<land.length; i++) {
//        	for(int j=0; j<land.length; j++) {
//        		int height = land[i][j];
//        		
//        		hashMap.put(height, hashMap.getOrDefault(height, 0) + 1);
//        		maxHeight = Math.max(maxHeight, height);
//        	}
//        }
//        
//        // 가장 높은 땅으로 채우는 비용 계산
//        long totalToFill = 0L;
//        int emptyArea = 0;
//        for(int i=1; i<=maxHeight; i++) {
//        	emptyArea += hashMap.getOrDefault(i-1, 0);
//        	totalToFill += emptyArea * P;
//        }
//        
//        // 최소비용으로 땅이 평평해지는 비용 계산
//		long answer = totalToFill;
//		long curCost = totalToFill;
//		int filledArea = 0;
//		for(int i=maxHeight; i>=0; i--) {
//			filledArea += hashMap.getOrDefault(i, 0);
//			
//			// 이전에 쌓아올렸던 땅 비용값 원상복구
//			int toRestoreCost = (area - filledArea) * P;
//			curCost -= toRestoreCost;
//			
//			// 해당 층에서 원래 제거해야했던 땅 비용값 계산
//			int toRemoveCost = filledArea * Q;
//			curCost += toRemoveCost;
//			
//			// 최소비용 갱신
//			answer = Math.min(answer, curCost);
//		}
//		
//        return answer;
//    }
	
}