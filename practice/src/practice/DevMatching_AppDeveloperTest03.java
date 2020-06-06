package practice;

public class DevMatching_AppDeveloperTest03 {
	
	public int solution(String command, String[] buttons, int[] scores) {
        int answer = command.length();
        
        int searchIndex = 0;
        int tmpAnswer = 0;
        
        for(int j=0; j<buttons.length; j++) {
        	searchIndex = 0;
        	tmpAnswer = 0;
        	
        	for(int i=j; i<buttons.length; i++) {
        		int resultIndex = command.indexOf(buttons[i], searchIndex);
				if (resultIndex != -1) {
					tmpAnswer += resultIndex - searchIndex;
	    			tmpAnswer += scores[i];
	    			searchIndex = resultIndex + buttons[i].length();
	    		}
            }
        	tmpAnswer += command.length() - searchIndex;
        	if(tmpAnswer > answer) {
        		answer = tmpAnswer;
        	}
        	
        }
        
        for(int j=buttons.length - 1; j>0; j--) {
        	searchIndex = 0;
        	tmpAnswer = 0;
        	
        	for(int i=j; i>0; i--) {
        		int resultIndex = command.indexOf(buttons[i], searchIndex);
				if (resultIndex != -1) {
					tmpAnswer += resultIndex - searchIndex;
	    			tmpAnswer += scores[i];
	    			searchIndex = resultIndex + buttons[i].length();
	    		}
            }
        	tmpAnswer += command.length() - searchIndex;
        	if(tmpAnswer > answer) {
        		answer = tmpAnswer;
        	}
        	
        }
        
        return answer;
    }
	
}
