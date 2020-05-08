package practice;

public class checktime_p145_03 {
	public static void main(String[] args) {
		int intArray[][];
		intArray = new int [4][];
		intArray[0] = new int[4];
		intArray[1] = new int[1];
		intArray[2] = new int[1];
		intArray[3] = new int[4];
		
		int num = 0;
		for(int i=0; i<intArray.length; i++) {
			for(int j=0; j<intArray[i].length; j++) {
				intArray[i][j] = num;
				num++;
			}
		}
		
		for(int i=0; i<intArray.length; i++) {
			for(int j=0; j<intArray[i].length; j++) {
				System.out.print(intArray[i][j] + " ");
			}
			System.out.println();
		}
		
	}
}
