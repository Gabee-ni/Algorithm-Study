import java.util.*;

class Solution {
	public String solution(String number, int k) {
		String answer = "";
		Deque<Character> dq = new ArrayDeque<>();

		for(char c : number.toCharArray()){
			while(k > 0 && !dq.isEmpty() && dq.peekLast() < c){
				dq.pollLast();
				k--;
			}
			dq.addLast(c);
		}

		for(char num : dq){
			answer += String.valueOf(num);
		}

		return answer.substring(0, answer.length() - k);
	}
}