package kakao;

public class blind20_01_03 {

	public static void main(String[] args) {
		int[][] lock = { { 1, 1, 1}, 
						 { 1, 1, 0},
						 { 1, 0, 1} };
//		int[][] lock = { { 1, 1, 1, 0}, 
//						 { 1, 1, 0, 1},
//						 { 1, 1, 0, 0},
//						 { 1, 0, 1, 1} };

		int[][] key = { { 0, 0, 0 },
						{ 1, 0, 0 },
						{ 0, 1, 1 } };
//		int[][] key = { { 0, 0, 0, 0 },
//						{ 0, 0, 0, 0 },
//						{ 1, 0, 0, 0 },
//						{ 0, 1, 1, 0 } };
//		int[][] key = { { 1, 2, 3 },
//						{ 4, 5, 6 },
//						{ 7, 8, 9 } };
//		int[][] key = { { 1, 2, 3, 4 },
//						{ 5, 6, 7, 8 },
//						{ 9, 10, 11, 12},
//						{ 13, 14, 15, 16 } };

		System.out.println("lock>>>");
		printArray(lock);
		

		System.out.println("key>>>");
		printArray(key);

		System.out.println("------------------\n");
		
		
		System.out.println("------------------\nresult : " + solution(key,lock));
	}
	
	static boolean solution(int[][] key, int[][] lock) {
		for(int degree=0; degree<=3; degree++) {
			int[][] rotatedtArray = rotation(key, 90*degree);
			
			System.out.println(90*degree + "° moved result>>");
			for(int x= -(rotatedtArray.length-1); x<= rotatedtArray.length-1; x++) {
				for(int y= -(rotatedtArray.length-1); y<= rotatedtArray.length-1; y++) {
					System.out.println("(" + x + ", " + y + ")");
					int [][] movedArray = move(rotatedtArray, x, y);

					if(canItUnlock(movedArray, lock) == true) {
						return true;
					}
				}
			}
			
		}

		return false;
	}
	
	
	static int[][] rotation(int[][] key, int degree) {
		int [][] rotated = new int[key.length][key.length];
		
		// degree calculation
		for (int x = 0; x < rotated.length; x++) {
			for (int y = 0; y < rotated.length; y++) {
				switch (degree) {
				case 0:
					rotated = key;
					break;
				case 90:
					rotated[y][rotated.length-1 -x] = key[x][y];
					break;
				case 180:
					rotated[rotated.length-1 -x][rotated.length-1 -y] = key[x][y];
					break;
				case 270:
					rotated[rotated.length-1 -y][x] = key[x][y];
					break;
				default:
					System.out.println("wrong rotation degree value");
					break;
				}
				
				
			}
		}
		
		System.out.println(Integer.toString(degree) + "° rotated result>>");
		printArray(rotated);
		
		return rotated;
	}
	
	static int[][] move(int[][] key, int x, int y) {
		int [][] moved = new int[key.length][key.length];
		
		for (int i=0; i<moved.length; i++) {
			for (int j=0; j<moved.length; j++) {
				moved[i][j] = 0;
			}
		}
		
		// move by x, y values
		for (int i=0; i<moved.length; i++) {
			for (int j=0; j<moved.length; j++) {				
				int toMoveX = i+x;
				int toMoveY = j+y;
				if (toMoveX >= 0 && toMoveX <= moved.length-1) {
					if (toMoveY >= 0 && toMoveY <= moved.length-1) {
						moved[toMoveX][toMoveY] = key[i][j];
					}
				}
				
			}
		}
		
		printArray(moved);
		
		return moved;
	}
	
	static boolean canItUnlock(int[][] key, int[][] lock) {
			for(int i=0; i<key.length; i++) {
				for(int j=0; j<key.length; j++) {
					if (lock[i][j] == key[i][j]) {
						return false;
					}
				}
			}
		return true;
	}
	
	static void printArray(int[][] toPrint) {
		for (int i = 0; i < toPrint.length; i++) {
			for (int j = 0; j < toPrint.length; j++) {
				int printTarget = toPrint[i][j];
				if (printTarget < 10 && printTarget >=0) {
					System.out.print("0");					
				}
				System.out.print(printTarget + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
//
//	static boolean solution(int[][] key, int[][] lock) {
//		for (int degree = 0; degree <= 270; degree += 90) {
//
//			// move 설정
//			int startRange = 0 - (key.length - 1);
//			int endRange = lock.length - 1;
//			for (int xMove = startRange; xMove <= endRange; xMove++) {
//				for (int yMove = startRange; yMove <= endRange; yMove++) {
//					boolean unlock = true;
//					int sum = 0;
//					
//					// key(x * y) 탐색
//					Loop1 :
//					for (int x = 0; x < key.length; x++) {
//						Loop2 :
//						for (int y = 0; y < key.length; y++) {
//							int rotatedKey = rotation(key, x, y, degree, xMove, yMove);
//							System.out.print(rotatedKey + " ");
//							
////							sum += lock[x][y];
//							if (rotatedKey >= 0) {
////								sum += lock[x][y] + rotatedKey;
//								sum += rotatedKey;
//								
//								if (lock[x][y] == rotatedKey) {
//									unlock = false;
//									
////									System.out.println();
////									break Loop1;
//								}
//							} else {
////								sum += lock[x][y];
//							}
//							
//						}
//						System.out.println();
//					}
//					
//					if (unlock == true && sum == lock.length * lock.length) {
//						return true;
//					}
//					
//					System.out.println();
//				}
//			}
//
//			System.out.println("---------->> end " + degree + "°");
//		}
//
//		return false;
//	}
//
//	static int rotation(int[][] key, int x, int y, int degree, int xMove, int yMove) {
//		x -= xMove;
//		y -= yMove;
//
//		int tmp = 0;
//		switch (degree) {
//		case 90:
//			tmp = x;
//			x = key.length - 1 - y;
//			y = tmp;
//			break;
//
//		case 180:
//			x = key.length - 1 - x;
//			y = key.length - 1 - y;
//			break;
//
//		case 270:
//			tmp = x;
//			x = y;
//			y = key.length - 1 - tmp;
//			break;
//
//		default:
//			break;
//		}
//
//		if (x < 0 || x > key.length - 1)
//			return -2;
//		if (y < 0 || y > key.length - 1)
//			return -2;
//
//		return key[x][y];
//	}

}
