package programmers;

public class SummerWinterCoding18_기지국_설치 {

//	정확성  테스트
//	테스트 1 〉	통과 (0.01ms, 75.9MB)
//	테스트 2 〉	통과 (0.03ms, 74.7MB)
//	테스트 3 〉	통과 (0.02ms, 71.4MB)
//	테스트 4 〉	통과 (0.02ms, 68MB)
//	테스트 5 〉	통과 (0.02ms, 79.4MB)
//	테스트 6 〉	통과 (0.02ms, 77.5MB)
//	테스트 7 〉	통과 (0.01ms, 74.9MB)
//	테스트 8 〉	통과 (0.02ms, 74.5MB)
//	테스트 9 〉	통과 (0.02ms, 74.8MB)
//	테스트 10 〉	통과 (0.03ms, 72.3MB)
//	테스트 11 〉	통과 (0.03ms, 74.4MB)
//	테스트 12 〉	통과 (0.01ms, 76.7MB)
//	테스트 13 〉	통과 (0.01ms, 72.5MB)
//	테스트 14 〉	통과 (0.02ms, 74.7MB)
//	테스트 15 〉	통과 (0.02ms, 77.3MB)
//	테스트 16 〉	통과 (0.03ms, 75.2MB)
//	테스트 17 〉	통과 (0.04ms, 76.8MB)
//	테스트 18 〉	통과 (0.03ms, 76.6MB)
//	테스트 19 〉	통과 (0.02ms, 80.7MB)
//	테스트 20 〉	통과 (0.02ms, 77.4MB)
//	테스트 21 〉	통과 (0.02ms, 71.2MB)
	
//	효율성  테스트
//	테스트 1 〉	통과 (0.75ms, 53.7MB)
//	테스트 2 〉	통과 (0.93ms, 52.9MB)
//	테스트 3 〉	통과 (0.55ms, 53MB)
//	테스트 4 〉	통과 (0.77ms, 53.9MB)
	
//	채점 결과
//	정확성: 70.5
//	효율성: 29.5
//	합계: 100.0 / 100.0
	
	public static void main(String[] args) {
		int N = 11; int[] stations = {4, 11}; int W = 1;
//		int N = 16; int[] stations = {9}; int W = 2;
		
		System.out.print(solution(N, stations, W));
	}
	
	public static int solution(int n, int[] stations, int w) {
        int answer = 0;
		int range5G = w * 2 + 1;
		
		// 1번 아파트 ~ 마지막 기지국 전파도달 아파트
		int startIndex = 1;
		for(int i=0; i<stations.length; i++) {
			if(startIndex < stations[i] - w) {
				int noSignalArea = (stations[i] - w) - startIndex;
				answer += toInstall5G(noSignalArea, range5G);
			}
			
			startIndex = stations[i] + w + 1;
		}

		// 마지막 기지국 전파도달 아파트 ~ n번째 아파트
		if(startIndex <= n) {
			int noSignalArea = (n - startIndex + 1);
			answer += toInstall5G(noSignalArea, range5G);
		}
		
        return answer;
    }
	
	private static int toInstall5G(int noSignalArea, int range5G) {
		int toInstall5G = noSignalArea / range5G;
		if(noSignalArea % range5G != 0)
			toInstall5G += 1;
		
		return toInstall5G;
	}
	
}