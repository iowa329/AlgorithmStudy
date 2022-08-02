package kakao;

public class KakaoSummerIntern21_Exam02 {

	public static void main(String[] args) {
		
		String[][] places = 
						{{"POOOP", 
	                      "OXXOX", 
	                      "OPXPX", 
	                      "OOXOX", 
	                      "POXXP"},
		                     
						{ "POOPX", 
		                  "OXPXP", 
		                  "PXXXO", 
		                  "OXXXO", 
		                  "OOOPP"}, 
		                 
						{ "PXOPX", 
		                  "OXOXP", 
		                  "OXPXX", 
		                  "OXXXP", 
		                  "POOXX"}, 
		                 
						{ "OOOXX", 
		                  "XOOOX", 
		                  "OOOXX", 
		                  "OXOOX", 
		                  "OOOOO"}, 
		                 
						{ "PXPXP", 
		                  "XPXPX", 
		                  "PXPXP", 
		                  "XPXPX", 
		                  "PXPXP"}};
		
		int[] answer = solution(places);
//		System.out.println(answer);
		
	}
	
	public static boolean isBoundsOfException(int index) {
		if (index < 0 || index >= 5) {
			return true;
		} else {
			return false;
		}
	}
	
	public static int[] solution(String[][] places) {
		int[] answer = {};
		
//		for(int place=0; place<places.length; place++) {
		for(int place=0; place<1; place++) {
			
			Loop1 :
			for(int x=0; x<5; x++) {
				for(int y=0; y<5; y++) {
					char currentPos = places[place][x].charAt(y);
					System.out.print(currentPos + " ");
					
					if(currentPos == 'P') {
						int searchIndex = x+1;
						if (isBoundsOfException(searchIndex) == false) {
							if(places[place][searchIndex].charAt(y) == 'P') {
								
							}
						}
						
						
						
						
						
						
						
						
						
						
						
						
						if(x == 4) {
							
						} else {
							char target = places[place][x+1].charAt(y); // 우
							
							switch (target) {
							case 'P':
								answer[place] = 0;
								break Loop1;
								
							case 'O':
								if(places[place][x+1].charAt(y) == 'P') {
									
								}
								break Loop1;

							default:
								break;
							}
							
							
							
							
							if (places[place][x+1].charAt(y) == 'P') { // 우
								answer[place] = 0;
								break Loop1;
							} else if (places[place][x].charAt(y+1) == 'P') { // 하
								answer[place] = 0;
								break Loop1;
							} else if (places[place][x+1].charAt(y+1) == 'P') { // 좌우대각선
								answer[place] = 0;
								break Loop1;
							}
						}
					}
				}
				System.out.println();
			}
			
			System.out.println();
		}
		
        
        return answer;
    }
	
}
