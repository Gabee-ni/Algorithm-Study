import java.util.*;

class Solution {
	public String solution(String[] participant, String[] completion) {
		HashMap<String, Integer> map = new HashMap<>();

		for(String par : participant){
			map.put(par, map.getOrDefault(par, 0) + 1);
		}

		for(String comp : completion){
			map.put(comp, map.get(comp) - 1);
		}

		for(Map.Entry<String, Integer> entry : map.entrySet()){
			if(entry.getValue() != 0){
				return entry.getKey();
			}
		}

		return "";
	}
}