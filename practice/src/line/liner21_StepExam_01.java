package line;

import line.liner21_StepExam_01.FlagArgumentType;

public class liner21_StepExam_01 {
	
	public static void main(String[] args) {
		String program = "line";
		String[] flag_rules = { "-s STRING", "-n NUMBER", "-e NULL" };
		String[] commands = { "line -n 100 -s hi -e", "lien -s Bye" };
		
		solution(program, flag_rules, commands);
	}
	
	public static boolean[] solution(String program, String[] flag_rules, String[] commands) {
        FlagRule[] flagRules = new FlagRule[flag_rules.length];
		for(int i=0; i<flag_rules.length; i++) {
			String[] data = flag_rules[i].split(" ");
			flagRules[i].flag = data[0];
			flagRules[i].type = data[1];
		}
		
		
		
		
		
		
		boolean[] answer = {};
        return answer;
    }
	
	static boolean commandValidator(String programName, String[] commands, FlagRule[] flagRules) {
		for(String command: commands) {
			String[] commandData = command.split(" ");
			if (commandData[0] != programName) return false;
			if (commandData[1].charAt(0) != '-') return false;
			
			for(int i=1; i<commandData.length; i++) {
				for(int j=0; j<flagRules.length; j++) {
					
					// -(dash)로 시작하는 flag일 경우
					if (i%2 == 1) {
						if (commandData[i] == flagRules[j].flag) {
							if (commandData[i+1] == flagRules[j].flag) {
								
							}
						} else {
							
						}
					} else {
						// -(dash) 이후 나오는 type인 경우
						
					}
					
					
					
					
					if(commandData[i] != flagRules[j].flag) {
						return false;
					} else if (commandData[i+1] != flagRules[j].type) {
						return false;
					}
				}
			}
		}
		
		return true;
	}
	
	enum FlagArgumentType {
		NULL, NUMBER, STRING
	}
}

class FlagRule {
	String flag;
	String type;
}