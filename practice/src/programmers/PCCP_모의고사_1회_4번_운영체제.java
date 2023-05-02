package programmers;

import java.util.*;

// 운영체제
public class PCCP_모의고사_1회_4번_운영체제 {

	public static void main(String[] args) {
//		a는 프로그램의 점수를 의미하며, 1 ≤ a ≤ 10 을 만족합니다.
//		b는 프로그램이 호출된 시각을 의미하며, 0 ≤ b ≤ 10,000,000을 만족합니다.
//		c는 프로그램의 실행 시간을 의미하며, 1 ≤ c ≤ 1,000을 만족합니다.
		
		int[][] program = {{2, 0, 10}, {1, 5, 5}, {3, 5, 3}, {3, 12, 2}};
//		int[][] program = {{3, 6, 4}, {4, 2, 5}, {1, 0, 5}, {5, 0, 5}};
		
		System.out.println("\n" + Arrays.toString(solution(program)));
	}
	
	static class Program implements Comparable<Program> {
		int score;
		int startTime;
		int runTime;
		int waitingTime;
		
		public Program(int score, int startTime, int runTime, int waitingTime) {
			this.score = score;
			this.startTime = startTime;
			this.runTime = runTime;
			this.waitingTime = waitingTime;
		}
		
		@Override
		public int compareTo(Program o) {
			// 실행시간 오름차순 정렬
			if(this.startTime < o.startTime) {
				return -1;
			} else  
			// 실행시간이 동일하다면
			if(this.startTime == o.startTime) {
				// 점수기준 기준 오름차순 정렬
				return this.score < o.score ? -1 : 1;
			} else {
				return 1;
			}
		}
		
		@Override
		public String toString() {
			return String.format("(%d, %d, %d, %d)", score, startTime, runTime, waitingTime);
		}
	}
	
	public static long[] solution(int[][] program) {
		Queue<Program> pq = new PriorityQueue<>();
		for(int[] programInfo: program) {
			pq.add(new Program(programInfo[0], programInfo[1], programInfo[2], 0));
		}
		
		System.out.println(pq);
		
		long[] answer = new long[10+1];
		
		int curTime = 0;
		int runningWillEnd = -1;
//		Queue<Program> pqWaiting = new PriorityQueue<>();
		
		while(curTime <= 20) {
			System.out.println(curTime + ">>" + runningWillEnd);
			System.out.println(pq);
			
			Program programInfo; 
			if(pq.peek().startTime >= curTime) {
				programInfo = pq.poll();

				// 실행 중인 프로그램이 없다면
				if(runningWillEnd <= curTime) {
					System.out.println("요기요");
					
					runningWillEnd = programInfo.runTime;
					answer[programInfo.score] += programInfo.waitingTime;
					
					for(Program nextProgram: pq) {
						if(nextProgram.waitingTime > 0) {
							nextProgram.waitingTime++;
						} else {
							break;
						}
					}
					curTime++;
				} else {
					System.out.println("저기요");
					
					// 실행 중인 프로그램이 있다면
					for(Program nextProgram: pq) {
						if(nextProgram.waitingTime > 0) {
							nextProgram.waitingTime++;
						} else {
							break;
						}
					}
					
					if(programInfo.startTime <= curTime && curTime <= programInfo.runTime) {
						programInfo.waitingTime++;
						System.out.println("called");
					}
						
					pq.add(programInfo);
					
					curTime++;
					
					
				}
			} else {
				curTime++;
				for(Program nextProgram: pq) {
					if(nextProgram.waitingTime > 0) {
						nextProgram.waitingTime++;
					} else {
						break;
					}
				}
				
				System.out.println();
				continue;
			}
			
			
			System.out.println();
			// 기본 수행
//			curTime++;
//			for(Program nextProgram: pq) {
//				if(nextProgram.waitingTime > 0) {
//					nextProgram.waitingTime++;
//				} else {
//					break;
//				}
//			}
//			System.out.println();
			
//			if(pq.peek().startTime == curTime) {
//				programInfo = pq.poll();
//				System.out.println("꺼냄");
//			} else if(pqWaiting.peek().startTime == curTime){
//				programInfo = pqWaiting.poll();
//				System.out.println("나감");
//			} else {
//				curTime++;
//				for(Program waitingProgram: pqWaiting) {
//					waitingProgram.waitingTime++;
//				}
//				
//				continue;
//			}
//			
//			
//			// 실행 중인 프로그램이 없다면
//			if(curTime > runningWillEnd) {
//				runningWillEnd = programInfo.runTime;
//				answer[programInfo.score] += programInfo.waitingTime;
//			} else {
//				// 실행 중인 프로그램이 있다면
//				pqWaiting.add(programInfo);
//				System.out.println("들어옴");
//			}
//			
//			curTime++;
//			for(Program waitingProgram: pqWaiting) {
//				waitingProgram.waitingTime++;
//			}
		}
		answer[0] = curTime-1;
		
        return answer;
    }
	
}






























