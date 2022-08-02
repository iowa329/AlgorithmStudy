package kakao;

public class BlindRecruitment22_1st_02 {

	public static void main(String[] args) {
		int n = 437674;
		int k = 3;
		
		solution(n, k);
	}
	
	static public int solution(int n, int k) {
        // 진법 변환
        String kNumberSystem = "";
        while(n > 0) {
        	String tmp = Integer.toString(n%k);
        	kNumberSystem = tmp + kNumberSystem;
        	
        	n /= k;
        }
        
        System.out.println(kNumberSystem);
        
        
        // 숫자 분리
        String[] kNubmerSystems = kNumberSystem.split("0");
        int[] isPrimeNumbers = new int[kNubmerSystems.length];
        for (int i=0; i < kNumberSystem.length(); i++) {
        	System.out.println(kNubmerSystems[i]);
            isPrimeNumbers[i] = Integer.parseInt(kNubmerSystems[i]);
        }
        
        
        int answer = isPrimeNumbers.length;
        // 소수(Prime Number) 판별
        for(int isPrimeNumber: isPrimeNumbers) {
        	for(int i=2; i*i<=isPrimeNumber; i++){
                if(isPrimeNumber % i == 0) {
                	answer--;
                	break;
                }
            }        	
        }
        
        System.out.println("asdasdasd " + answer);
        
        return answer;
    }
	
}
