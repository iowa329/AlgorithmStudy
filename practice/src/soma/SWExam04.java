package soma;

import java.util.Scanner;

public class SWExam04 {
	public static void main(String args[]) { 
	    Scanner sc = new Scanner(System.in);
	    
	    int n;
	    n = sc.nextInt();
	    sc.nextLine();
	    
	    int[] step = new int[n];
	    boolean[] stepped = new boolean[n];
	    for(int i=0; i<n; i++) {
	    	step[i] = sc.nextInt();
	    	stepped[i] = false;
	    }
	    sc.close();
	    
	    boolean[] tmpStepped = stepped;
	    int cnt = 0;
	    int maxCnt = 0;
	    for(int test=0; test<=2; test++) {
	    	boolean check = true;
	    	cnt = 0;
	    	tmpStepped = stepped;
	    	
	    	int move = test;
	    	int pos = 0;
	    	
	    	while(check) {
	    		cnt++;
	    		pos += move;
		    	move = step[pos];
		    	
		    	if (tmpStepped[pos] == false) {
		    		tmpStepped[pos] = true;
		    	} else {
		    		check = false;
		    	}
	    	}
	    	
	    	if(cnt > maxCnt) {
	    		maxCnt = cnt;
	    	}
	    }
	    
	    System.out.println(maxCnt);
	}
}
