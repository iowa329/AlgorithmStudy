package baekjoon;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();
        
        int result = 0;
        for(int searchNumber=1; searchNumber<=n; searchNumber++) {
            int searchTarget = searchNumber;
            int sum = searchNumber;
            while(searchTarget > 0) {
                sum += searchTarget%10;
                searchTarget /= 10;
            }
            if (sum == n) {
                result = searchNumber;
                break;
            }
        }
        
        System.out.println(result);
    }
	
}