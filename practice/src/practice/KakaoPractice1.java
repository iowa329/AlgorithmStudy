package practice;

import java.util.Scanner;

public class KakaoPractice1 {

	public int[] main(int[][] v) {
        Scanner sc = new Scanner(System.in);
		int[][] pos = new int[3][2];
		
		for(int i=0; i<3; i++) {
            for(int j=0; j<2; j++){
                pos[i][j] = sc.nextInt();
			System.out.println(pos[i][j]);
            }
		}
		sc.close();
        
        int tmp[] = new int[2];
        // x좌표 비교
        if (pos[0][0] == pos[1][0]){
            tmp[0] = pos[2][0];
        } else {
            if(pos[0][0] == pos[2][0]){
                tmp[0] = pos[1][0];
            } else {
                tmp[0] = pos[0][0];
            }
        }
        // y좌표 비교
        if (pos[0][1] == pos[1][1]){
            tmp[1] = pos[2][1];
        } else {
            if(pos[0][1] == pos[2][1]){
                tmp[1] = pos[1][1];
            } else {
                tmp[1] = pos[0][1];
            }
        }

    int[] answer = {tmp[0], tmp[1]};
    
    return answer;
    
    }

}