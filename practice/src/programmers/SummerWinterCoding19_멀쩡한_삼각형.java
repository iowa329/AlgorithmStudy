package programmers;

public class SummerWinterCoding19_멀쩡한_삼각형 {
	
	public static void main(String[] args) {
		int w = 
				8;
		int h = 
				12;
						 
		long answer = solution(w,h);
		System.out.print(answer);
	}
	
	// w와 h의 최대공약수 * (최소단위)대각선 수가 -> 잘려나간 직사각형 종이
	public static long solution(int w, int h) {
		// 최대공약수
		int gcd = getGCD(w, h);
		
		// 최대공약수로 나눈 몫(최소단위)
		int quotientW = w / gcd;
		int quotientH = h / gcd;
		
		int minCrossSquare = (quotientW + quotientH) - 1; // (최소단위) 대각선 수
		long totalCrossSquare = (long)minCrossSquare * (long)gcd; // 가로지른 총 직사각형의 수
		
		long answer = (long)w * (long)h - totalCrossSquare;
		
        return answer;
    }
	
	// 최대공약수(Greatest Common Divisor) 구하기
	private static int getGCD(int a, int b) {
		if(b == 0)
			return a;
		else 
			return getGCD(b, a%b);
	}
	
}