import java.util.*;

class Solution {
	public int solution(int[] topping) {
		int answer = 0;
		Map<Integer, Integer> map = new HashMap<>();

		for(int t : topping){
			map.put(t, map.getOrDefault(t, 0) + 1);
		}

		int rightKinds = map.size();

		Set<Integer> set = new HashSet<>();
		int leftKinds = 0;

		for(int i = 0; i < topping.length - 1; i++){
			int t = topping[i];

			if(!set.contains(t)){
				set.add(t);
				leftKinds++;
			}

			map.put(t, map.get(t) - 1);
			if(map.get(t) == 0){
				map.remove(t);
				rightKinds--;
			}

			if(leftKinds == rightKinds){
				answer++;
			}
		}

		return answer;
	}
}