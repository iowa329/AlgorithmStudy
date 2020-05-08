package practice;
import java.util.Scanner;

public class EX_02_05 {
	public static void main(String[] args) {
		int time, hour, minute, second;
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		time = sc.nextInt();
		second = time%60;
		minute = (time/60)%60;
		hour = (time/60)/60;
		System.out.print("입력하신 " + time + "초는 " + hour + "시간 " + minute + "분 " + second + "초 입니다.");
	}
}
