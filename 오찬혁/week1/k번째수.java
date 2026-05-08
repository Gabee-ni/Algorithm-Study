import java.util.*;

class Solution {
	public int[] solution(int[] array, int[][] commands) {
		List<Integer> result = new ArrayList<>();

		for(int k = 0; k < commands.length; k++){
			int len = commands[k][1] - commands[k][0] + 1;
			int[] arr = new int[len];
			int idx = 0;

			for(int i = commands[k][0] - 1; i < commands[k][1]; i++){
				arr[idx++] = array[i];
			}

			Arrays.sort(arr);

			result.add(arr[commands[k][2] - 1]);
		}

		return result.stream().mapToInt(i -> i).toArray();
	}
}