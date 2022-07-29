package practice;

public class KakaoSummerInternExam01 {
	
	public String solution(int[] numbers, String hand) {
		
		String answer = "";
		
		String lastPosL = "*";
		String lastPosR = "#";

		int distanceL = 0;
		int distanceR = 0;
		
		for(int i=0; i<numbers.length; i++) {
			switch (numbers[i]) {
			case 1:
				answer += "L";
				lastPosL = "1";
				break;
			case 4:
				answer += "L";
				lastPosL = "4";
				break;
			case 7:
				answer += "L";
				lastPosL = "7";
				break;
			case 3:
				lastPosR = "3";
				answer += "R";
				break;
			case 6:
				lastPosR = "6";
				answer += "R";
				break;
			case 9:
				lastPosR = "9";
				answer += "R";
				break;
				
			case 2:
				if( lastPosL.equals("1") || lastPosL.equals("5")) {
					distanceL = 1;
				} else if( lastPosL.equals("4") || lastPosL.equals("8")) {
					distanceL = 2;
				} else if( lastPosL.equals("7") || lastPosL.equals("0")) {
					distanceL = 3;
				} else if( lastPosL.equals("*")) {
					distanceL = 4;
				} else if( lastPosL.equals("2")) {
					distanceL = 0;
				}
				
				if( lastPosR.equals("3") || lastPosR.equals("5")) {
					distanceR = 1;
				} else if( lastPosR.equals("6") || lastPosR.equals("8")) {
					distanceR = 2;
				} else if( lastPosR.equals("9") || lastPosR.equals("0")) {
					distanceR = 3;
				} else if( lastPosR.equals("#") ) {
					distanceR = 4;
				} else if( lastPosR.equals("2")) {
					distanceR = 0;
				}
				
				if (distanceL == distanceR) {
					if (hand.equals("left")) {
						answer += "L";
						lastPosL = "2";
					} else {
						answer += "R";
						lastPosR = "2";
					}
				} else if (distanceL > distanceR) {
					answer += "R";
					lastPosR = "2";
				} else {
					answer += "L";
					lastPosL = "2";
				}
				break;
				
			case 5:
				if( lastPosL.equals("2") || lastPosL.equals("4") || lastPosL.equals("8")) {
					distanceL = 1;
				} else if( lastPosL.equals("1") || lastPosL.equals("7") || lastPosL.equals("0")) {
					distanceL = 2;
				} else if( lastPosL.equals("*")) {
					distanceL = 3;
				} else if( lastPosL.equals("5")) {
					distanceL = 0;
				}
				
				if( lastPosR.equals("2") || lastPosR.equals("6") || lastPosR.equals("8")) {
					distanceR = 1;
				} else if( lastPosR.equals("3") || lastPosR.equals("9") || lastPosR.equals("0")) {
					distanceR = 2;
				} else if( lastPosR.equals("#")) {
					distanceR = 3;
				} else if( lastPosR.equals("5")) {
					distanceR = 0;
				}
				
				if (distanceL == distanceR) {
					if (hand.equals("left")) {
						answer += "L";
						lastPosL = "5";
					} else {
						answer += "R";
						lastPosR = "5";
					}
				} else if (distanceL > distanceR) {
					answer += "R";
					lastPosR = "5";
				} else {
					answer += "L";
					lastPosL = "5";
				}
				break;
				
			case 8:
				if( lastPosL.equals("5") || lastPosL.equals("7") || lastPosL.equals("0")) {
					distanceL = 1;
				} else if( lastPosL.equals("2") || lastPosL.equals("4") || lastPosL.equals("*")) {
					distanceL = 2;
				} else if( lastPosL.equals("1")) {
					distanceL = 3;
				} else if( lastPosL.equals("8")) {
					distanceL = 0;
				}
				
				if( lastPosR.equals("5") || lastPosR.equals("9") || lastPosR.equals("0")) {
					distanceR = 1;
				} else if( lastPosR.equals("2") || lastPosR.equals("6") || lastPosR.equals("#")) {
					distanceR = 2;
				} else if( lastPosR.equals("3")) {
					distanceR = 3;
				} else if( lastPosR.equals("8")) {
					distanceR = 0;
				}
				
				if (distanceL == distanceR) {
					if (hand.equals("left")) {
						answer += "L";
						lastPosL = "8";
					} else {
						answer += "R";
						lastPosR = "8";
					}
				} else if (distanceL > distanceR) {
					answer += "R";
					lastPosR = "8";
				} else {
					answer += "L";
					lastPosL = "8";
				}
				break;
				
			case 0:
				if( lastPosL.equals("*") || lastPosL.equals("8")) {
					distanceL = 1;
				} else if( lastPosL.equals("7") || lastPosL.equals("5")) {
					distanceL = 2;
				} else if( lastPosL.equals("4") || lastPosL.equals("2")) {
					distanceL = 3;
				} else if( lastPosL.equals("1")) {
					distanceL = 4;
				} else if( lastPosL.equals("0")) {
					distanceL = 0;
				}
				
				if( lastPosR.equals("#") || lastPosR.equals("8")) {
					distanceR = 1;
				} else if( lastPosR.equals("9") || lastPosR.equals("5")) {
					distanceR = 2;
				} else if( lastPosR.equals("6") || lastPosR.equals("2")) {
					distanceR = 3;
				} else if( lastPosR.equals("3")) {
					distanceR = 4;
				} else if( lastPosR.equals("0")) {
					distanceR = 0;
				}
				
				if (distanceL == distanceR) {
					if (hand.equals("left")) {
						answer += "L";
						lastPosL = "0";
					} else {
						answer += "R";
						lastPosR = "0";
					}
				} else if (distanceL > distanceR) {
					answer += "R";
					lastPosR = "0";
				} else {
					answer += "L";
					lastPosL = "0";
				}
				break;	
			}
		}
		System.out.println(answer);
		
        return answer;
    }
	
}
