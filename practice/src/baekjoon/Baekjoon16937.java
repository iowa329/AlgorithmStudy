package baekjoon;

import java.io.*;
import java.util.*;

// 경우의 수 : 스티커 2개 선택(n^2) x 각각 회전(2^2) x 가로/세로 정렬(2)
// 연산가능 최대값 : (n의 최대값 = 100) 10000 x 4 x 2 = 80000회
// 전부 탐색 가능(브루트 포스)
public class Baekjoon16937 {

	static int h, w, max;
	static int[][] stickers;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		h = Integer.parseInt(strTkr.nextToken());
		w = Integer.parseInt(strTkr.nextToken());
		
		strTkr = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(strTkr.nextToken());
		stickers = new int[n][2];
		
		// 스티커 정보 입력받기
		for(int i=0; i<n; i++) {
			strTkr = new StringTokenizer(br.readLine());
			stickers[i][0] = Integer.parseInt(strTkr.nextToken());
			stickers[i][1] = Integer.parseInt(strTkr.nextToken());
		}
		br.close();
		
		
		// 브루트 포스
		// 스티커 두개이기 때문에 서로 다른 두 스티커의 검사 경우의 수: 중복 제외(j=i+1), 마지막 i는 검사 필요x
		for(int i=0; i<n-1; i++) {
			for(int j=i+1; j<n; j++) {
				
				// 경우의 수 전부 탐색
				int[] roatedCasesI = {0, 0, 1, 1}; // i에 대하여 => 기본, 기본, 회전, 회전
				int[] roatedCasesJ = {0, 1, 0, 1}; // j에 대하여 => 기본, 회전, 기본, 회전
				int[] axisCase = {h, w}; // 스티커 가로, 세로 정렬
				
				// '스티커i/스티커j'에 대한 회전 경우의 수 4가지 x '서로 다른 스터커 두개'에 대한 정렬 경우의 수 2가지(가로/세로) = 총 8가지 경우의 수
				for(int axisCases=0; axisCases<2; axisCases++) {
					for(int rotateCases=0; rotateCases<4; rotateCases++) {
						// 스티커 붙이기 조건 검사
						// 가능할 때 max 비교 후 갱신
						attachingStickers(i, j, roatedCasesI[rotateCases], roatedCasesJ[rotateCases], axisCase[axisCases]);
					}
				}
				
			}
		}
		
		
		// 결과
		System.out.println(max);
	}
	
	// 모눈종이에 스티커 부착
	private static void attachingStickers(int i, int j, int directionI, int directionJ, int compareAxis) {
		int oppositeDirectionI = directionI == 0 ? 1 : 0;
		int oppositeDirectionJ = directionJ == 0 ? 1 : 0;
		int oppositeCompareAxis = compareAxis == h ? w : h;
		
		if(stickers[i][directionI] + stickers[j][directionJ] <= compareAxis &&
			Math.max(stickers[i][oppositeDirectionI], stickers[j][oppositeDirectionJ]) <= oppositeCompareAxis) {
			int size = (stickers[i][0] * stickers[i][1]) + (stickers[j][0] * stickers[j][1]);
			max = Math.max(max, size);
		}
	}

}




































