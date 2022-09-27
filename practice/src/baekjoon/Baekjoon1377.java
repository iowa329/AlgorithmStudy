package baekjoon;

import java.io.*;
import java.util.*;

// 버블소트 배열 정의
class Arr {
	int num;
	int index;
	
	public Arr(int num, int index) {
		this.num = num;
		this.index = index;
	}
}

public class Baekjoon1377 {

	public static void main(String[] args) throws IOException {
		// 메모리 초과 문제 해결을 위해 Scanner 대신 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		Arr[] a = new Arr[n+1];
		
		a[0] = new Arr(0, 0);; // NullPointerException 방지
		// 값 입력받기		
		for (int i=1; i<=n; i++) {
			a[i] = new Arr(Integer.parseInt(br.readLine()), i);;
		}
		br.close();
		
		// 숫자 기준 오름차순 정렬
		Arrays.sort(a, new Comparator<Arr>() {
			@Override
			public int compare(Arr o1, Arr o2) {
				return o1.num - o2.num;
			};
		});
		
		// 정렬 후 가장 많이 이동한 숫자(index위치 기준) 탐색
		int max = 0;
		for (int i=1; i<=n; i++) {
			int distance = a[i].index - i;
			if(distance > max) {
				max = distance;
			}
			
//			max = Math.max(max, distance); 
		}
		
		// 버블소트는 정렬 이후(swap이 가능한 모든 숫자가 swap이 된 이후) 최종확인을 위해 한번 더 순회하므로
		max += 1;
		
		// 결과
		System.out.println(max);
	}

}