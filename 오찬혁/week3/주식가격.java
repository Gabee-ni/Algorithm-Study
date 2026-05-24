import java.util.*;

class Solution {
	public int[] solution(int[] prices) {
		List<Integer> result = new ArrayList<>();

		for(int i = 0; i < prices.length; i++){
			int cnt = 0;

			for(int j = i + 1; j < prices.length; j++){
				if(prices[i] <= prices[j]){
					cnt++;
				} else {
					cnt++;
					break;
				}
			}

			result.add(cnt);
		}

		return result.stream().mapToInt(i -> i).toArray();
	}
}