import java.util.*;

class Solution {
	public int[] solution(int[] numbers) {
		int n = numbers.length;
		int[] answer = new int[n];
		Deque<Integer> dq = new ArrayDeque<>();

		Arrays.fill(answer, -1);

		for(int i = 0; i < n; i++){
			while(!dq.isEmpty() && numbers[dq.peek()] < numbers[i]){
				int idx = dq.pop();
				answer[idx] = numbers[i];
			}
			dq.push(i);
		}

		return answer;
	}
}