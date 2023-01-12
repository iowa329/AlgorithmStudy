package kakao;

import java.io.*;
import java.util.*;

public class BlindRecruitment23_이모티콘_할인행사 {

	public static void main(String[] args) {
		int[][] users = 
				{{40, 10000}, {25, 10000}};
		int[] emoticons = 
				{7000, 9000};
		
		int[] result = solution(users, emoticons);
		System.out.println(result);
	}
	
	public static int[] solution(int[][] users, int[] emoticons) {
        int[][] emoticonsDC = new int[emoticons.length][4];
        for(int emoticon=0; emoticon<emoticons.length; emoticon++) {
        	for(int discount=0; discount<4; discount++) {
        		int rate = (discount+1) * 10;
        		emoticonsDC[emoticon][discount] = emoticons[emoticon] - (emoticons[emoticon] * rate / 100);
            }
        }
        
        for(int i=0; i<emoticons.length; i++) {
        	System.out.println(Arrays.toString(emoticonsDC[i]));
        }
		
		int[] answer = {};
        return answer;
    }
	
}