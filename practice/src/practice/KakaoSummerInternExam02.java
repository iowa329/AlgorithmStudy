package practice;

import java.util.ArrayList;

public class KakaoSummerInternExam02 {

	public long solution(String expression) {
        
		// 수식 배열로 자르기
		ArrayList<String> expressions = new ArrayList<String>();
		String str = "";
		int lastIndex = 0;
        for(int i=0; i<expression.length(); i++) {
        	if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
        		str = expression.substring(lastIndex, i);
        		expressions.add(str);
        		lastIndex = i;
        		
        		str = expression.substring(lastIndex, lastIndex+1);
        		expressions.add(str);
        		lastIndex += 1;
        	}
        }
        str = expression.substring(lastIndex, expression.length());
        expressions.add(str);
        
        
        // 수식 종류 개수 파악
        int cnt = 0;
        ArrayList<String> operators = new ArrayList<String>();
        if (expressions.contains("+")) {
        	cnt += 1;
        	operators.add("+");
        } else if (expressions.contains("-")) {
        	cnt += 1;
        	operators.add("-");
        } else if (expressions.contains("*")) {
        	cnt += 1;
        	operators.add("*");
        }
        
        
        // 경우의 수 구하기
        long answer = 0;
        long tmpAnswer;
        ArrayList<String> tmpArr;
        
        if (cnt == 2) {
        	// 첫번쨰 경우의 수
            tmpArr = calculate(deepCopy(expressions), operators.get(0));
        	tmpArr = calculate(tmpArr, operators.get(1));
        	
        	answer = Long.parseLong(tmpArr.get(0));
        	// 절대값 보정
        	if(answer < 0) {
        		answer *= -1;
        	}
        	
        	// 두번쨰 경우의 수
        	tmpArr = calculate(deepCopy(expressions), operators.get(1));
        	tmpArr = calculate(tmpArr, operators.get(0));
        	
        	tmpAnswer = Long.parseLong(tmpArr.get(0));
        	// 절대값 보정
        	if(tmpAnswer < 0) {
        		tmpAnswer *= -1;
        	}
        	
        	// 결과값 비교
        	if(answer < tmpAnswer) {
        		answer = tmpAnswer;
        	}
        } else if (cnt == 3) {
        	// case 1
    		tmpArr = calculate(deepCopy(expressions), operators.get(0));
			tmpArr = calculate(tmpArr, operators.get(1));
			tmpArr = calculate(tmpArr, operators.get(2));
			
			answer = Long.parseLong(tmpArr.get(0));
			// 절대값 보정
        	if(answer < 0) {
        		answer *= -1;
        	}
        	
        	// case 2
    		tmpArr = calculate(deepCopy(expressions), operators.get(0));
			tmpArr = calculate(tmpArr, operators.get(2));
			tmpArr = calculate(tmpArr, operators.get(1));
			
			tmpAnswer = Long.parseLong(tmpArr.get(0));
			// 절대값 보정
        	if(tmpAnswer < 0) {
        		tmpAnswer *= -1;
        	}
        	
        	// 결과값 비교
        	if(answer < tmpAnswer) {
        		answer = tmpAnswer;
        	}
        	
        	// case 3
    		tmpArr = calculate(deepCopy(expressions), operators.get(1));
			tmpArr = calculate(tmpArr, operators.get(0));
			tmpArr = calculate(tmpArr, operators.get(2));
			
			tmpAnswer = Long.parseLong(tmpArr.get(0));
			// 절대값 보정
        	if(tmpAnswer < 0) {
        		tmpAnswer *= -1;
        	}
        	
        	// 결과값 비교
        	if(answer < tmpAnswer) {
        		answer = tmpAnswer;
        	}
        	
        	// case 4
    		tmpArr = calculate(deepCopy(expressions), operators.get(1));
			tmpArr = calculate(tmpArr, operators.get(2));
			tmpArr = calculate(tmpArr, operators.get(0));
			
			tmpAnswer = Long.parseLong(tmpArr.get(0));
			// 절대값 보정
        	if(tmpAnswer < 0) {
        		tmpAnswer *= -1;
        	}
        	
        	// 결과값 비교
        	if(answer < tmpAnswer) {
        		answer = tmpAnswer;
        	}
        	
        	// case 5
    		tmpArr = calculate(deepCopy(expressions), operators.get(2));
			tmpArr = calculate(tmpArr, operators.get(0));
			tmpArr = calculate(tmpArr, operators.get(1));
			
			tmpAnswer = Long.parseLong(tmpArr.get(0));
			// 절대값 보정
        	if(tmpAnswer < 0) {
        		tmpAnswer *= -1;
        	}
        	
        	// 결과값 비교
        	if(answer < tmpAnswer) {
        		answer = tmpAnswer;
        	}
        	
        	// case 6
    		tmpArr = calculate(deepCopy(expressions), operators.get(2));
			tmpArr = calculate(tmpArr, operators.get(1));
			tmpArr = calculate(tmpArr, operators.get(0));
			
			tmpAnswer = Long.parseLong(tmpArr.get(0));
			// 절대값 보정
        	if(tmpAnswer < 0) {
        		tmpAnswer *= -1;
        	}
        	
        	// 결과값 비교
        	if(answer < tmpAnswer) {
        		answer = tmpAnswer;
        	}
        }
        
        
		return answer;
    }
	
	// 수식 우선순위 계산 함수
	public ArrayList<String> calculate(ArrayList<String> tmpExpressions, String operator) {

		String str = "";
		
		switch (operator) {
		case "+":
			// +일 경우
	        for(int i=0; i<tmpExpressions.size(); i++) {
	        	if(tmpExpressions.get(i).equals("+")) {
	        		int tmp = Integer.parseInt(tmpExpressions.get(i-1)) + Integer.parseInt(tmpExpressions.get(i+1));
	        		str = Integer.toString(tmp);
	        		tmpExpressions.remove(i);
	        		tmpExpressions.add(i, str);
	        		
	        		tmpExpressions.remove(i+1);
	        		tmpExpressions.remove(i-1);
	        		
	        		// 위치 탐색 값 조정
	        		i -= 1;
	        	}
	        }
	        break;
	        
		case "-":
			// -일 경우
	        for(int i=0; i<tmpExpressions.size(); i++) {
	        	if(tmpExpressions.get(i).equals("-")) {
	        		int tmp = Integer.parseInt(tmpExpressions.get(i-1)) - Integer.parseInt(tmpExpressions.get(i+1));
	        		str = Integer.toString(tmp);
	        		tmpExpressions.remove(i);
	        		tmpExpressions.add(i, str);
	        		
	        		tmpExpressions.remove(i+1);
	        		tmpExpressions.remove(i-1);
	        		
	        		// 위치 탐색 값 조정
	        		i -= 1;
	        	}
	        }
	        break;
	        
		case "*":
			// *일 경우
	        for(int i=0; i<tmpExpressions.size(); i++) {
	        	if(tmpExpressions.get(i).equals("*")) {
	        		int tmp = Integer.parseInt(tmpExpressions.get(i-1)) * Integer.parseInt(tmpExpressions.get(i+1));
	        		str = Integer.toString(tmp);
	        		tmpExpressions.remove(i);
	        		tmpExpressions.add(i, str);
	        		
	        		tmpExpressions.remove(i+1);
	        		tmpExpressions.remove(i-1);
	        		
	        		// 위치 탐색 값 조정
	        		i -= 1;
	        	}
	        }
	        break;
		}
		
		return tmpExpressions;
	}
	
	// ArrayList 완전복제 함수
	public ArrayList<String> deepCopy(ArrayList<String> original) {
	
		// 객체 복사
		ArrayList<String> tmpExpressions = new ArrayList<String>();
		for(int i=0; i<original.size(); i++) {
			tmpExpressions.add(original.get(i));
		}
		
		return tmpExpressions;
	}
	
}
