package kakao;

public class BlindRecruitment22_1st_06 {
	public static void main(String[] args) {
		int[][] board = 
//						{
//						{5,5,5,5,5},
//						{5,5,5,5,5},
//						{5,5,5,5,5},
//						{5,5,5,5,5}
//						};
		
		{{1,2,3},{4,5,6},{7,8,9}};
		
		int[][] skill = 
//			{{1,0,0,3,4,4},{1,2,0,2,3,2},{2,1,0,3,1,2},{1,0,1,3,3,1}};
		{{1,1,1,2,2,4},{1,0,0,1,1,2},{2,2,0,2,0,100}};
		
		solution(board, skill);
	}
	
	static public int solution(int[][] board, int[][] skill) {
        for(int[] targetSkill: skill) {
        	
        	for(int x=targetSkill[1]; x<=targetSkill[3]; x++) {
        		for(int y=targetSkill[2]; y<=targetSkill[4]; y++) {
        			
        			int power = 0;
        			switch (targetSkill[0]) {
                	// 파괴
            		case 1:
            			power = -1;
            			break;

            		// 복구
            		case 2:
            			power = 1;
            			break;
            			
            		default:
            			break;
            		}
        			
        			board[x][y] += targetSkill[5] * power; 
        			
        		}
        	}
        	
        }
        
        int answer = 0;
        for(int i=0; i<board.length; i++) {
        	for(int j=0; j<board[0].length; j++) {
        		if(board[i][j] >= 1) {
        			answer++;
        		}
        	}
        }
        
        System.out.println(answer);
        
        return answer;
    }
	
	
	
	
	
	
	
	// you can also use imports, for example:
	// import java.util.*;

	// you can write to stdout for debugging purposes, e.g.
	// System.out.println("this is a debug message");

	class Solution {
	    public String solution(int A, int B, int C) {
	        // write your code in Java SE 8

	        String answer = "";

	        int biggest = A;
	        char biggestChar = 'a';
	        if(biggest < B) {
	            biggest = B;
	            biggestChar = 'b';
	            if(biggest < C) {
	                biggest = C;
	                biggestChar = 'c';
	            }
	        } else if(biggest < C) {
	            biggest = C;
	            biggestChar = 'c';
	            if(biggest < B) {
	                biggest = B;
	                biggestChar = 'b';
	            }
	        }

	        int sizeA = (A/2) + (A%1);
	        int sizeB = (B/2) + (B%1);
	        int sizeC = (C/2) + (C%1);

	        char firstChar = ' ';

	        if (sizeA > sizeB + sizeC) {
	            firstChar = 'a';
	        } else if(sizeB > sizeA + sizeC) {
	            firstChar = 'b';
	        } else if(sizeC > sizeA + sizeB) {
	            firstChar = 'c';
	        }


	        switch (firstChar) {
	            case 'a' :
	                answer += "aa";
	                break;
	            
	            case 'b' :
	                answer += "bb";
	                break;

	            case 'c' :
	                answer += "cc";
	                break;

	            default :
	                break;
	        }



	        for(int i=0; i<A+B+C; i++) {
	            for(;biggest>=0; biggest--) {
	                answer += biggestChar+biggestChar;
	                if(biggest == 1) {
	                    answer += biggestChar;
	                }

	            }
	        }


	        return answer;
	    }
	}

	
}
