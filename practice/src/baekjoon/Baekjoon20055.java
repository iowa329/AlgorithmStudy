package baekjoon;

import java.io.*;
import java.util.*;

class ConveyerBelt {
	int a;
	boolean isRobotOn;
	
	public ConveyerBelt(int a, boolean isRobotOn) {
		this.a = a;
		this.isRobotOn = isRobotOn;
	}
}

public class Baekjoon20055 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer strTkr = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(strTkr.nextToken());
		int k = Integer.parseInt(strTkr.nextToken());
		
		ArrayList<ConveyerBelt> conveyerBelts = new ArrayList<>();
		conveyerBelts.add(0, new ConveyerBelt(0, false)); // 0은 편의상 제외하고 시작
		
		strTkr = new StringTokenizer(br.readLine());
		br.close();
		// 컨베이어 벨트 내구도 a값 입력받기
		for(int i=1; i<=n*2; i++)
			conveyerBelts.add(i, new ConveyerBelt(Integer.parseInt(strTkr.nextToken()), false));
		
		// 내구도가 0인 칸의 개수가 K개 이상이라면 반복문 종료
		int cycle = 0;
		int durability = 0;
		while(durability < k) {
			// 1
			// 맨 뒤 값을 맨 앞으로 삽입하여 벨트가 한칸씩 회전
			ConveyerBelt toGoTop = conveyerBelts.get(n*2);
			conveyerBelts.remove(n*2);
			conveyerBelts.add(1, toGoTop);

			// 내리는 위치(n)의 로봇은 즉시 내림
			ConveyerBelt toGoDown = conveyerBelts.get(n); 
			if(toGoDown.isRobotOn)
				toGoDown.isRobotOn = false;
			
			// 2
			for(int i=n-1; i>=1; i--) {
				ConveyerBelt curBelt = conveyerBelts.get(i);
				ConveyerBelt toGoForwardBelt = conveyerBelts.get(i+1);
				if(curBelt.isRobotOn) {
					// 이동하려는 칸에 로봇이 없고, 내구도가 1 이상 남아 있다면
					if(toGoForwardBelt.isRobotOn == false && toGoForwardBelt.a >= 1) {
						toGoForwardBelt.isRobotOn = true; // 올리고
						toGoForwardBelt.a -= 1; // 내구도 감소
						
						curBelt.isRobotOn = false;
					}
				}				
			}
			
			// 내리는 위치(n)의 로봇은 즉시 내림
			toGoDown = conveyerBelts.get(n); 
			if(toGoDown.isRobotOn)
				toGoDown.isRobotOn = false;
			
			// 3
			ConveyerBelt conveyerBeltUp = conveyerBelts.get(1);
			if(conveyerBeltUp.isRobotOn == false && conveyerBeltUp.a > 0) {
				conveyerBeltUp.isRobotOn = true;
				conveyerBeltUp.a -= 1;
			}
			
			// 4
			durability = 0;
			for(int i=1; i<=n*2; i++)
				if(conveyerBelts.get(i).a <= 0)
					durability++;
			
			cycle++;
		}
		
		// 종료되었을 때 몇 단계였는지 출력
		System.out.println(cycle);
	}
	
}