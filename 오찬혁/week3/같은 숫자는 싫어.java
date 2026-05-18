import java.util.*;

public class Solution {
	public int[] solution(int []arr) {
		List<Integer> result = new ArrayList<>();

		for(int i = 0; i < arr.length - 1; i++){
			if(arr[i] != arr[i + 1]){
				result.add(arr[i]);
			}
		}
		result.add(arr[arr.length - 1]);

		return result.stream().mapToInt(i -> i).toArray();
	}
}