package practice;

public class EX_02_01 {
	public static void main(String[] args) {
		final double PI = 3.14;
		double radius = 10; //원의 반지
		double circleArea = 0; //원의 면적
		
		circleArea = radius * radius * PI;
		
		System.out.print(radius);
		System.out.println();
		System.out.print("원의 면적 = ");
		System.out.print(circleArea);
	}
}
