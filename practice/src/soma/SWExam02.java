package soma;

import java.util.Scanner;
import java.util.ArrayList;

class SWExam02 {  
  public static void main(String args[]) { 
    int p, n, h;
    Scanner sc = new Scanner(System.in);
    
    p = sc.nextInt();
    n = sc.nextInt();
    h = sc.nextInt();
    sc.nextLine();
    
//    int[] pc = new int[p]; 
    ArrayList<ArrayList<Integer>> pc = new ArrayList<ArrayList<Integer>>();
    
    // 손님 예약 주문 검사
    int sit = 0;
    int time= 0;
    for(int i=1; i<=n; i++) {
    	ArrayList<Integer> reserveTimeList = new ArrayList<Integer>();
    	for(int j=1; j<=n; j++) {
    		sit = sc.nextInt();
        	time = sc.nextInt();
        	sc.nextLine();
        	if (sit == i) {
            	if (time <= h) {
            		reserveTimeList.add(time);
            	}    		
        	}
        	System.out.println(j);
    	}
//    	pc.add(reserveTimeList);

    	System.out.println(i);
    	
        
    }
    sc.close();
    
    for(int i=0; i<p; i++) {
//    	checkMaxTime(pc.get(i));
    	System.out.println(i);
    	System.out.println(pc.get(i));
    }
    
    
  }
  
//  public static int checkMaxTime(ArrayList<Integer> reserveTimeList) {
//	  
//	  
//  }
  
}