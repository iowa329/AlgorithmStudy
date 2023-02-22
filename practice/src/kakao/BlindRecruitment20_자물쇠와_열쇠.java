package kakao;

import java.util.*;

public class BlindRecruitment20_자물쇠와_열쇠 {

	private static void printArrays(int[][] targetArray) {
		for(int[] array: targetArray) {
			System.out.println(Arrays.toString(array));
		}
	}
	
	public static void main(String[] args) {
		int[][] key = { { 0, 0, 0 },
						{ 1, 0, 0 },
						{ 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1}, 
						 { 1, 1, 0},
						 { 1, 0, 1} };
		
		System.out.println(solution(key, lock));
	}
	
	static int keySize;
	
	public static boolean solution(int[][] key, int[][] lock) {
		keySize = key.length;
		int expandLockSize = lock.length + (keySize * 2) - 2;
		
		// lock을 중심에 둔 확장된 lock배열 선언
		// 경계 밖 부분 -1로 초기화
		int[][] expandedLock = new int[expandLockSize][expandLockSize];
		for(int[] expandedLockX: expandedLock) {
			Arrays.fill(expandedLockX, -1);
		}
		
		// 중심에 lock 배치
		int startIndex = keySize-1;
		for(int x=startIndex; x<startIndex+keySize; x++) {
			for(int y=startIndex; y<startIndex+keySize; y++) {
				expandedLock[x][y] = lock[x-startIndex][y-startIndex];
			}
		}
		
		boolean answer = false;
		
		// key를 돌려가며 완전탐색
		for(int rotation=0; rotation<=270; rotation+=90) {
			
			for(int startX=0; startX<keySize-1+lock.length; startX++) {
				for(int startY=0; startY<keySize-1+lock.length; startY++) {
					
					for(int x=startX; x<keySize; x++) {
						for(int y=startY; y<keySize; y++) {
							if(expandedLock[x][y] == -1)
								continue;
							if(expandedLock[x][y])
							
						}
					}					
					
				}
			}
			
			
				
			
			key = rotateKey(key);
			
		}
		
        return answer;
    }
	
	private static int[][] rotateKey(int[][] originalKey) {
		int[][] rotatedKey = new int[keySize][keySize];
		for(int x=0; x<keySize; x++)
			for(int y=0; y<keySize; y++)
				rotatedKey[y][keySize-1-x] = originalKey[x][y];
		
		return rotatedKey;
	}
	
}
