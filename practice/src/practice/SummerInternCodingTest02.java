package practice;

import java.util.ArrayList;

public class SummerInternCodingTest02 {
    public long solution(long n) {

    	ArrayList<Integer> threeNum = new ArrayList<Integer>(); 
        
    	int start = 0;
        int endNum = 1;
        
        threeNum.add(1);
        for(int i=0; threeNum.size() < n; i++){
        	if(i == start) {
        		endNum *= 3;
        		start = threeNum.size();
        		threeNum.add(endNum);
        		i = -1;
        	} else {
        		int add = threeNum.get(start) + threeNum.get(i);
            	threeNum.add(add);
        	}
        }
        
        int lastIndex = threeNum.size() - 1;
        long answer = threeNum.get(lastIndex);

        return answer;
    }
}
