package kakao;

import java.util.*;

// BlindRecruitment22_SecondHalf_1st_01과 동일
public class BlindRecruitment23_개인정보_수집_유효기간 {

	public static void main(String[] args) {
		String today = 
				"2022.05.19";
//				"2020.01.01";
		
		String[] terms = 
				{"A 6", "B 12", "C 3"};
//				{"Z 3", "D 5"};
		
		String[] privacies =
				{"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};
//				{"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};
						 
		int[] answer = solution(today, terms, privacies);
		System.out.print(Arrays.toString(answer));
	}

	public static int[] solution(String today, String[] terms, String[] privacies) {
        // 파기해야할 개인정보 번호(오름차순)
		int[] answer = {};
		List<Integer> expireList = new ArrayList<Integer>();
        
		// 약관 종류에 따른 유효기간
		HashMap<String, Integer> termsHashMap = new HashMap<String, Integer>();
		for(int i=0; i<terms.length; i++) {
			String[] term = terms[i].split(" ");
			termsHashMap.put(term[0], Integer.parseInt(term[1]));
		}
        
		// 오늘 날짜 기준 유효기간 확인
		int todayNum = dateConverter(today);
		for(int i=0; i<privacies.length; i++) {
			String[] privacy = privacies[i].split(" ");
			
			int privacyNum = dateConverter(privacy[0]);
			int vaildation = termsHashMap.get(privacy[1]) * 28 - 1;
			
			int expireDate = privacyNum + vaildation;			
			if(expireDate < todayNum) {
				expireList.add(i+1);
			}
		}
		
		// 오름차순으로 정렬
		Collections.sort(expireList);
		// ArrayList에서 int[]로 변환
		answer = expireList.stream().mapToInt(i -> i).toArray();
		
        return answer;
    }
	
	// 날짜 일괄정렬
	public static int dateConverter(String date) {
		int dateNum = 0;
		int daysOfMonth = 28;
		
		String[] dateList = date.split("\\."); // 0: YYYY, 1: MM, 2: DD
		
		dateNum += (Integer.parseInt(dateList[0]) - 2000) * 12 * daysOfMonth;
		dateNum += Integer.parseInt(dateList[1]) * daysOfMonth;
		dateNum += Integer.parseInt(dateList[2]);
		
		return dateNum;
	}
	
}
