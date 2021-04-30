package kakao;

public class blind20_01_03 {

	public static void main(String[] args) {
		int[][] lock = { { 1, 1, 1 }, 
						 { 1, 1, 0 },
						 { 1, 0, 1 } };

		int[][] key = { { 0, 0, 0 },
						{ 1, 0, 0 },
						{ 0, 1, 1 } };

		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				System.out.print(key[i][j] + " ");
			}
			System.out.println();
		}

		System.out.println("------------");

		System.out.println("\n결과 : " + String.valueOf(solution(key, lock)));
	}

	static boolean solution(int[][] key, int[][] lock) {
		for (int degree = 0; degree <= 270; degree += 90) {

			// move 설정
			int startRange = 0 - (key.length - 1);
			int endRange = lock.length;
			for (int xMove = startRange; xMove < endRange; xMove++) {
				for (int yMove = startRange; yMove < endRange; yMove++) {
					boolean unlock = true;
					int sum = 0;
					
					// key(x * y) 탐색
					for (int x = 0; x < key.length; x++) {
						for (int y = 0; y < key.length; y++) {
							int rotatedKey = rotation(key, x, y, degree, xMove, yMove);
							System.out.print(rotatedKey + " ");
							
							if (rotatedKey >= 0) {
								if (lock[x][y] == rotatedKey)
									unlock = false;
								
								sum += lock[x][y] + rotatedKey;						
							} else {
								sum+= lock[x][y];
							}
							
						}
						System.out.println();
					}
					
					if (unlock == true && sum == lock.length * lock.length) {
						return true;
					}
					
					System.out.println();
				}
			}

			System.out.println("---------->> end " + degree + "°");
		}

		return false;
	}

	static int rotation(int[][] key, int x, int y, int degree, int xMove, int yMove) {
		x -= xMove;
		y -= yMove;

		int tmp = 0;
		switch (degree) {
		case 90:
			tmp = x;
			x = key.length - 1 - y;
			y = tmp;
			break;

		case 180:
			x = key.length - 1 - x;
			y = key.length - 1 - y;
			break;

		case 270:
			tmp = x;
			x = y;
			y = key.length - 1 - tmp;
			break;

		default:
			break;
		}

		if (x < 0 || x > key.length - 1)
			return -2;
		if (y < 0 || y > key.length - 1)
			return -2;

		return key[x][y];
	}

}
