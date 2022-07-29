package practice;

import java.util.Scanner;

public class SWMaestroFinalExam02 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		// 개인별 능력치 값 저장
		int[][] pos = new int[n][2];
		for(int i=0; i<n; i++) {
			pos[i][0] = sc.nextInt();
			pos[i][1] = sc.nextInt();
		}
		
		// 개인별 관계 그룹짓기
		int[][] relation = new int[m][m];
		int j=0;
		int k=0;
		for(int i=1; i<=m; i++) {
			int relation1 = sc.nextInt();
			int relation2 = sc.nextInt();
			if (relation1 != relation2) {
				relation[j][k] = relation1;
				k++;
				relation[j][k] = relation2;
				j++; k++;
			}
		}
		sc.close();
	}
}