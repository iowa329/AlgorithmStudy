package practice;

public class SummerInternCodingTest01 {
	public int solution(int p) {

        p++;

        boolean searchBeauty = true;
        while(searchBeauty){
            int[] beautyYear = new int[4];

            beautyYear[0] = p / 1000;

            beautyYear[1] = p % 1000;
            beautyYear[1] = beautyYear[1] / 100;

            beautyYear[2] = p % 100;
            beautyYear[2] = beautyYear[2] / 10;

            beautyYear[3] = p % 10;

            for(int i=0; i<4; i++){
                for(int j=1; j<4; j++){
                    if(i+j <= 3){
                        if(beautyYear[i] == beautyYear[i+j]){
                            p++;
                            j = 4;
                            i = 4;
                            searchBeauty = true;
                        } else {
                            searchBeauty = false;
                        }
                    }
                }
            }
        }

        int answer = p;

        return answer;
    }
}
