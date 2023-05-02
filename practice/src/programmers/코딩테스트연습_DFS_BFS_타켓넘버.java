package programmers;

public class 코딩테스트연습_DFS_BFS_타켓넘버 {

	public static void main(String[] args) {
//		int[] numbers = {1, 1, 1, 1, 1}; int target = 3;
		int[] numbers = {4, 1, 2, 1}; int target = 4;
		
		System.out.println(solution(numbers, target));
	}

	static int cnt = 0;
	
	public static int solution(int[] numbers, int target) {
		dfs(numbers, target, 0, 0);
		
        return cnt;
    }
	
	private static void dfs(int[] numbers, int target, int index, int sum) {
		if(index == numbers.length) {
			if(sum == target)
				cnt++;
			return;
		}
		
		dfs(numbers, target, index+1, sum+numbers[index]);
		dfs(numbers, target, index+1, sum-numbers[index]);
	}
	
}