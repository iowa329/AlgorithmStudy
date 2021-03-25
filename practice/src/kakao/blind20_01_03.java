package kakao;

public class blind20_01_03 {
	
	public static void main(String[] args) {
		int m = 3;
		int[][] key = new int[m][m];
		for(int i=0; i<key.length; i++) {
			for(int j=0; j<key.length; j++) {
				key[i][j] = (i*key.length)+j+1;
				System.out.print(key[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println();
		rotation(90, key);
	}

	static String solution(String s) {
		return "";
	}

	static int[][] rotation(int degree, int[][] key) {
		int[][] rotatedKey = new int[key.length][key.length];
		
		for(int i=0; i<key.length; i++) {
			for(int j=0; j<key.length; j++) {
				rotatedKey[j][key.length-i] = key[i][j];
				System.out.print(key[i][j]);
			}
			System.out.println();
		}
		
		return rotatedKey;
	}
	
}
