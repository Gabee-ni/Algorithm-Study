import java.util.*;

class Solution {
	boolean solution(String s) {
		Deque<String> dq = new ArrayDeque<>();

		for(int i = 0; i < s.length(); i++){
			String str = String.valueOf(s.charAt(i));

			if("(".equals(str)){
				dq.add("(");
			}

			if(")".equals(str)){
				if(dq.isEmpty()){
					return false;
				}
				if("(".equals(dq.peek())){
					dq.remove();
				}
			}
		}

		if(!dq.isEmpty()){
			return false;
		}

		return true;
	}
}