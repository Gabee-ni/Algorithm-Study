import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


class Solution {
    public int solution(int k, int[] tangerine) {
		Map<Integer, Integer> map = new HashMap<>();
		List<Integer> list;

		for (int i = 0; i < tangerine.length; i++) {
			map.put(tangerine[i], map.getOrDefault(tangerine[i], 0) + 1);
		}

		list = map.keySet().stream().sorted((a, b) -> map.get(b) - map.get(a)).collect(Collectors.toList());
        
		int sum = 0;

		for (int i = 0; i < list.size(); i++) {
			sum += map.get(list.get(i));
			if (sum >= k)
				return i + 1;
		}

		return 0;
    }
}