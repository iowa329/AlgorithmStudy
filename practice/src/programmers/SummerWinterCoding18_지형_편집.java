package programmers;

import java.util.*;

public class SummerWinterCoding18_지형_편집 {

	public static void main(String[] args) {
		int[][] land = {{1, 2}, {2, 3}}; int P = 3; int Q = 2;
//		int[][] land = {{4, 4, 3}, {3, 2, 2}, {2, 1, 0}}; int P = 5; int Q = 3;
		
		System.out.print(solution(land, P, Q));
	}
	
	// 구현3
	// land 배열을 기준으로 1차원 배열 변환 뒤 높이 기준 반복문을 수행하는 방법(시간복잡도 최대 300 * 300)
	
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
        
        int beforeheight = -1;
        long beforeBlocks = 0;
        for(int i=0; i<heightCnt; i++) {
        	int height = landInfo[i];
        	
        	// 높이가 달라질 때(블록의 높이가 평평해질 때) 비용 계산
        	if(height != beforeheight) {
        		beforeheight = height;
        		
        		// 추가할 블록 비용 계산
        		long blocksToAdd = i * height;
        		blocksToAdd -= beforeBlocks;
        		long costAdd = blocksToAdd * P;
        		
        		// 제거할 블록 비용 계산
        		long blocksToRemove = totalBlocks - beforeBlocks;
        		blocksToRemove -= (heightCnt - i) * height;
        		long costRemove = blocksToRemove * Q;
        		
        		long curCost = costAdd + costRemove;
    			// 최소비용 갱신
        		answer = Math.min(answer, curCost);
        	}
        	
        	beforeBlocks += height;
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