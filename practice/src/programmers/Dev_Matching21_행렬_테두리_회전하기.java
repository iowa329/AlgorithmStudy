package programmers;

import java.util.*;

public class Dev_Matching21_행렬_테두리_회전하기 {

	public static void main(String[] args) {
//		int rows = 6; int colums = 6; int[][] queries = {{2,2,5,4},{3,3,6,6},{5,1,6,3}};
		int rows = 3; int colums = 3; int[][] queries = {{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}};
//		int rows = 100; int colums = 97; int[][] queries = {{1,1,100,97}};
		
		System.out.println(Arrays.toString(solution(rows, colums, queries)));
	}
	
	public static int[] solution(int rows, int columns, int[][] queries) {
		int[][] arr = new int[rows+1][columns+1];
		// 배열 초기화
		for(int i=1; i<=rows; i++)
			for(int j=1; j<=columns; j++)
				arr[i][j] = (i-1) * columns + j;
		
		// 각 쿼리별 최소값 계산
		int[] answer = new int[queries.length];
		for(int i=0; i<queries.length; i++) {
			int x1 = queries[i][0];
			int y1 = queries[i][1];
			int x2 = queries[i][2];
			int y2 = queries[i][3];
			
			// 시계방향 행렬 회전
			int tmpNum = arr[x1][y1];
			int minNum = tmpNum;
			
			// for문 순서 - 좌하우상(반시계 방향으로)
			for(int x=x1+1; x<=x2; x++) {
				minNum = Math.min(minNum, arr[x][y1]);
				arr[x-1][y1] = arr[x][y1];
			}
			for(int y=y1+1; y<=y2; y++) {
				minNum = Math.min(minNum, arr[x2][y]);
				arr[x2][y-1] = arr[x2][y];
			}
			for(int x=x2-1; x>=x1; x--) {
				minNum = Math.min(minNum, arr[x][y2]);
				arr[x+1][y2] = arr[x][y2];
			}
			for(int y=y2-1; y>=y1; y--) {
				minNum = Math.min(minNum, arr[x1][y]);
				arr[x1][y+1] = arr[x1][y];
			}
			
			arr[x1][y1+1] = tmpNum;
			
			answer[i] = minNum;
		}
		
        return answer;
    }
	
}