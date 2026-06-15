import java.util.*;

class Solution {
	public int solution(int[] topping) {
		int answer = 0;
		Map<Integer, Integer> map = new HashMap<>();
		Set<Integer> set = new HashSet<>();

		for(int top : topping){
			map.put(top, map.getOrDefault(top, 0) + 1);
		}

		for(int top : topping){
			map.put(top, map.get(top) - 1);
			if(map.get(top) == 0){
				map.remove(top);
			}
			set.add(top);

			if(set.size() == map.size()){
				answer++;
			}
		}

		return answer;
	}
}