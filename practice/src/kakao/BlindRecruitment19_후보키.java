package kakao;

import java.util.*;

public class BlindRecruitment19_후보키 {

	public static void main(String[] args) {
		String[][] relation = 
				{{"100","ryan","music","2"},{"200","apeach","math","2"},
				 {"300","tube","computer","3"},{"400","con","computer","4"},
				 {"500","muzi","music","3"},{"600","apeach","music","2"}};
		
		System.out.println(solution(relation));
	}
	
	public static int solution(String[][] relation) {
		int lengthTuple = relation.length;
		int lengthAttribute = relation[0].length;
		
		ArrayList<Integer> candidateKeyList = new ArrayList<>();
		
		for(int bitCombi=1; bitCombi<=(1<<lengthAttribute)-1; bitCombi++) {
			
			// 중복값 판별을 위한 hashSet 선언
			HashSet<String> hashSet = new HashSet<>();
			
			// tuple 개수만큼 전체 탐색
			for(int tuple=0; tuple<lengthTuple; tuple++) {
				StringBuilder sb = new StringBuilder();

				// tuple 내 요소(attribute)에 대한 조합 실행
				for(int attribute=0; attribute<lengthAttribute; attribute++) {
					// &연산(둘다 1이면 1)을 통해 동일하면 0보다 크다(1010 & 1010 -> 1010(0000보다 크다))
					if( (bitCombi & (1 << attribute)) > 0)
						sb.append(relation[tuple][attribute]);
				}
				
				// 합쳐진 조합은 중복판별 set에 추가
				hashSet.add(sb.toString());
			}
			
			if(hashSet.size() == lengthTuple && check(candidateKeyList, bitCombi))
				candidateKeyList.add(bitCombi);
		}
		
        return candidateKeyList.size();
    }
	
	private static boolean check(ArrayList<Integer> keyList, int curBitCombi) {
		for(int key: keyList) {
			if( (key & curBitCombi) == key)
				return false;
		}
		
		return true;
	}
	
}
