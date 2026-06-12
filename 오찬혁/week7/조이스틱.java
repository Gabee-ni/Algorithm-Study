import java.util.*;

class Solution {
	public int solution(String name) {
		int answer = 0;
		char[] arr = name.toCharArray();

		for(int i = 0; i < arr.length; i++){
			int up = arr[i] - 'A';
			int down = 26 - up;
			answer += Math.min(up, down);
		}

		int move = arr.length - 1;
		for(int i = 0; i < arr.length; i++){
			int next = i + 1;
			while(next < arr.length && arr[next] == 'A'){
				next++;
			}
			int rightThenLeft = i + i + (arr.length - next);
			int leftThenRight = (arr.length - next) * 2 + i;
			move = Math.min(move, Math.min(rightThenLeft, leftThenRight));
		}
		answer += move;

		return answer;
	}
}