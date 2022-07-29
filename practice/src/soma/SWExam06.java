package soma;

import java.util.ArrayList;
import java.util.Scanner;

public class SWExam06 {

	public static void main(String args[]) {
		int n;
		Scanner sc = new Scanner(System.in);

		n = sc.nextInt();
		sc.nextLine();

		// scan
		ArrayList<Integer> land = new ArrayList<Integer>();

		for (int i = 0; i < n; i++) {
			land.add(sc.nextInt());
		}
		sc.close();

		int max = 0;
		int maxPos = 0;
		int profit = 0;

		// calculate profit
		while (true) {
			max = 0;
			maxPos = 0;

			int[] result = findMax(max, maxPos, land);
			max = result[0];
			maxPos = result[1];

			profit += max;
			removeLand(maxPos, land);

			System.out.println("max : " + max);
			System.out.println("maxPos : " + maxPos);
			System.out.println("profit : " + profit);
			System.out.println("land : " + land);
			if (land.size() <= 1) {
				break;
			}

			System.out.println(land.size());
		}

		// result
		System.out.println();
		System.out.println("최종 이익 값 : " + profit);
	}

	
	
	
	public static int[] findMax(int max, int maxPos, ArrayList<Integer> land) {
		for (int i = 0; i < land.size(); i++) {
			if (land.get(i) > max) {
				max = land.get(i);
				maxPos = i;
			}
		}

		int[] result = new int[2];
		result[0] = max;
		result[1] = maxPos;

		return result;
	}

	public static ArrayList<Integer> removeLand(int maxPos, ArrayList<Integer> land) {
		int n = land.size();
		if (maxPos < n / 2) {
			for (int i = 0; i < n / 2; i++) {
				land.remove(0);
			}
		} else {
			for (int i = n / 2; i < n; i++) {
				land.remove(n / 2);
			}
		}

		return land;
	}

}
