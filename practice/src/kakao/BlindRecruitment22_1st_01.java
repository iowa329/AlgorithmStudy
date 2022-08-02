package kakao;

import java.util.*;

public class BlindRecruitment22_1st_01 {
	
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = {"muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"};
		int k = 2;
		
		solution(id_list, report, k);
	}
	
	static public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = {};
		
		List<String> reporterList = new ArrayList<String>();
		List<ArrayList<String>> reporterLists = new ArrayList<ArrayList<String>>();
		
		int[] reportCountList = new int[id_list.length];		
		
		for(String reportContent: report) {
			String[] reportArr = reportContent.split(" ");
			
			for(int i=0; i<id_list.length; i++) {
				if(reportArr[1] == id_list[i]) {
					if(reporterList.contains(reportArr[0]) == false) {
						reporterList.add(i, reportArr[0]);
						reportCountList[i]++;						
					}
					break;
				}
			}
		}
		
		for(int i=0; i<reportCountList.length; i++) {
			if(reportCountList[i] >= k) {
				
			}
		}
		
		
        
        return answer;
    }
	
	
	
	
}
