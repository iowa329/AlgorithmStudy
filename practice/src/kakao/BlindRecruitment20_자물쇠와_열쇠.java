package kakao;

public class BlindRecruitment20_자물쇠와_열쇠 {
	
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
	static int lockSize;
	
	public static boolean solution(int[][] key, int[][] lock) {
		keySize = key.length;
		lockSize = lock.length;
		int expandLockSize = lockSize + ((keySize-1) * 2);
		
		// lock을 중심에 둔 확장된 lock배열 선언
		int[][] expandedLock = new int[expandLockSize][expandLockSize];
		// 중심에 lock 배치
		int startIndex = keySize-1;
		for(int x=startIndex; x<startIndex+lockSize; x++) {
			for(int y=startIndex; y<startIndex+lockSize; y++) {
				expandedLock[x][y] = lock[x-startIndex][y-startIndex];
			}
		}
		
		boolean answer = false;
		
		// key를 돌려가며 완전탐색
		loop_Rotation:
		for(int rotation=0; rotation<=270; rotation+=90) {
			
			// 처음(0도)를 제외하고 key 회전
			if(rotation != 0)
				key = rotateKey(key);
			
			for(int startX=0; startX<keySize-1+lockSize; startX++) {
				loop_checkItCanBeUnlock:
				for(int startY=0; startY<keySize-1+lockSize; startY++) {
					
					// expandLock배열 크기와 동일한 확장된 key배열 선언
					int[][] expandedKey = new int[expandLockSize][expandLockSize];
					for(int x=startX; x<startX+keySize; x++)
						for(int y=startY; y<startY+keySize; y++)
							expandedKey[x][y] = key[x-startX][y-startY];
					
					// expandedLock 중간에 있는 lock 기준으로 잠금해제 가능 여부검사
					for(int x=startIndex; x<startIndex+lockSize; x++) {
						for(int y=startIndex; y<startIndex+lockSize; y++) {
							// lock과 key의 합이 1이 아니면 잠금해제를 할 수 없다
							if(expandedLock[x][y] + expandedKey[x][y] != 1) { // 잠금해제를 할 수 없는 경우
								continue loop_checkItCanBeUnlock; // 조건검사 반복문 종료
							}
						}
					}
					
					// 여기까지 온 경우 반례가 없어 잠금해제를 할 수 있다는 뜻이므로
					answer = true; // 가능처리 후
					break loop_Rotation; // 전체 탐색 완전종료
					
				}
			}
			
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