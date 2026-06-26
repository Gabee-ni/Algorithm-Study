import java.util.*;

class Solution {
	public int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;
		int n = want.length;
		HashMap<String, Integer> map = new HashMap<>();

		for(int i = 0; i < n; i++){
			map.put(want[i], number[i]);
		}

		for(int i = 0; i <= discount.length - 10; i++){
			HashMap<String, Integer> disMap = new HashMap<>();
			for(int j = i; j < i + 10; j++){
				disMap.merge(discount[j], 1, Integer::sum);
			}

			if(disMap.equals(map)){
				answer++;
			}
		}

		return answer;
	}
}