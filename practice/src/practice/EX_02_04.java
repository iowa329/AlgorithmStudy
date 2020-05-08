package practice;
import java.util.Scanner;

public class EX_02_04 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("나이, 체중, 신장을 빈칸으로 분리하여 순서대로 입력하세요");
		System.out.println("나이 : " + sc.nextInt() + "세");
		System.out.println("체중 : " + sc.nextDouble() + "kg");
		System.out.println("신장 : " + sc.nextDouble() + "cm");
	}
}
