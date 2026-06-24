import java.util.*;

class Solution {
	public int[] solution(String[] gems) {
		Set<String> set = new HashSet<>();
		Map<String, Integer> count = new HashMap<>();

		for(String gem : gems){
			set.add(gem);
		}

		int total = set.size();
		int left = 0;
		int bLeft = 0, bRight = gems.length;

		Set<String> window = new HashSet<>();
		for(int right = 0; right < gems.length; right++){
			String gem = gems[right];
			count.put(gem, count.getOrDefault(gem, 0) + 1);
			window.add(gem);

			while(window.size() == total){
				if(right - left < bRight - bLeft){
					bLeft = left;
					bRight = right;
				}

				String leftGem = gems[left];
				count.put(leftGem, count.get(leftGem) - 1);
				if(count.get(leftGem) == 0){
					window.remove(leftGem);
				}
				left++;
			}
		}

		return new int[]{bLeft + 1, bRight + 1};
	}
}