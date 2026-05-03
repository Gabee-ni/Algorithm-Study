import java.util.*;

class Solution {
	public int solution(String[][] clothes) {
		int answer = 1;
		HashMap<String, Integer> map = new HashMap<>();

		for(String[] cloth : clothes){
			String type = cloth[1];
			map.put(type, map.getOrDefault(type, 0) + 1);
		}

		for(Map.Entry<String, Integer> entry : map.entrySet()){
			answer *= entry.getValue() + 1;
		}

		return answer - 1;
	}
}