package programmers;

import java.util.*;

// [1차] 다트 게임
public class BlindRecruitment18_다트게임 {

	public static void main(String[] args) {
//		String dartResult = "1S2D*3T";
//		String dartResult = "1D2S#10S";
//		String dartResult = "1D2S0T";
//		String dartResult = "1S*2T*3S";
//		String dartResult = "1D#2S*3S";
//		String dartResult = "1T2D3D#";
		String dartResult = "1D2S3T*";
		
		System.out.println(solution(dartResult));
	}
	
	public static int solution(String dartResult) {
		// 점수목록 배열 정리
		String[] list = dartResult.split("[^0-9]");
		ArrayList<Integer> numList = new ArrayList<>();
		for(String num: list)
			if(!num.isEmpty())
				numList.add(Integer.parseInt(num));

		// 보너스|[옵션] 목록 배열 정리
		ArrayList<String> optionList = new ArrayList<>();
		list = dartResult.split("[0-9]");
		for(String option: list)
			if(!option.isEmpty())
				optionList.add(option);
		
		// 다트 게임 점수 계산
		// 각 점수에 대한 계산
		for(int i=0; i<numList.size(); i++) {
			int curNum = numList.get(i);
			// 각 점수별에 대한 보너스 및 옵션 목록 계산 반영
			for(int j=0; j<optionList.get(i).length(); j++) {
				char curOption = optionList.get(i).charAt(j);
				switch (curOption) {
					case 'S':
						curNum = (int)Math.pow(curNum, 1);
						break;
					case 'D':
						curNum = (int)Math.pow(curNum, 2);
						break;
					case 'T':
						curNum = (int)Math.pow(curNum, 3);
						break;
					case '*':
						int beforeIndex = i == 0 ? 0 : i-1;
						numList.set(beforeIndex, numList.get(beforeIndex) * 2);
						curNum *= 2;
						break;
					case '#':
						curNum *= -1;
						break;
				}
				numList.set(i, curNum);
			}
		}
		
		// 점수계산
		int score = 0;
		for(int num: numList)
			score += num;
		
        return score;
    }
	
}