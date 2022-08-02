package naver;

public class Zmate22_summer_01 {
	
	public static void main(String[] args) {
		System.out.println("hello naver Z-mate");
	}

}


//you can also use imports, for example:
import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Solution {
 public int solution(int[] A) {
     // write your code in Java SE 8

     int arrSize = A.length;
     int[] bulbs = new int[arrSize];
     
     int shine = 0;

     for(int i=0; i<arrSize; i++) {
         boolean isLinked = true;

         bulbs[A[i]-1] = A[i];
         

         for(int j=0; j<=i; j++) {
             if(bulbs[j] == 0) {
                 isLinked = false;
                 break;
             }
         }

         if(isLinked == true) {
             shine++;
         }
         
     }


     return shine;
 }
}
