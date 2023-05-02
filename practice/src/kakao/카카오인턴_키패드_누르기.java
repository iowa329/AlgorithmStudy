package kakao;

public class 카카오인턴_키패드_누르기 {

	public static void main(String[] args) {
//		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5}; String hand = "right";
//		int[] numbers = {7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2}; String hand = "left";
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0}; String hand = "right";
		
		System.out.println(solution(numbers, hand));
	}
	
	public static String solution(int[] numbers, String hand) {
		int posLeft = 10;
		int posRight = 12;
		
		StringBuilder sb = new StringBuilder();
		for(int number: numbers) {
			switch (number) {
			case 1:
			case 4:
			case 7:
				sb.append("L");
				posLeft = number;
				break;

			case 2:
			case 5:
			case 8:
			case 0:
				int distanceLeft = calculateDistance(number, posLeft);
				int distanceRight = calculateDistance(number, posRight);
				
				if(distanceLeft < distanceRight) {
					sb.append("L");
					posLeft = number;
				} else if(distanceLeft == distanceRight) {
					switch (hand) {
					case "left":
						sb.append("L");
						posLeft = number;
						break;

					case "right":
						sb.append("R");
						posRight = number;
						break;
					}
				} else if(distanceLeft > distanceRight) {
					sb.append("R");
					posRight = number;
				}
				break;	
				
			case 3:
			case 6:
			case 9:
				sb.append("R");
				posRight = number;
				break;
				
			default:
				break;
			}
		}
		
        return sb.toString();
    }
	
	private static int calculateDistance(int number, int pos) {
		int[][] keypad = {  {0, 0},  
							{1, 1}, {1, 2}, {1, 3},
							{2, 1}, {2, 2}, {2, 3},
							{3, 1}, {3, 2}, {3, 3},
							{4, 1}, {4, 2}, {4, 3}  };
		
		number = number == 0 ? 11 : number;
		pos = pos == 0 ? 11 : pos;
		
		int x = Math.abs(keypad[number][0] - keypad[pos][0]);
		int y = Math.abs(keypad[number][1] - keypad[pos][1]);
		
		return x+y;
	}
	
}