import java.util.*;

class Solution {
	public String solution(int[] numbers) {
		StringBuilder sb = new StringBuilder();
		String[] nums = new String[numbers.length];

		for(int i = 0; i < numbers.length; i++){
			nums[i] = String.valueOf(numbers[i]);
		}

		Arrays.sort(nums, (a, b) -> (b + a).compareTo(a + b));

		if("0".equals(nums[0])){
			return "0";
		}

		for(int i = 0; i < numbers.length; i++){
			sb.append(nums[i]);
		}

		return sb.toString();
	}
}