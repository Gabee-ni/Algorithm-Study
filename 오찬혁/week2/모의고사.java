import java.util.*;

class Solution {
	public int[] solution(int[] answers) {
		List<Integer> result = new ArrayList<>();
		int[] supo1 = {1, 2, 3, 4, 5};
		int[] supo2 = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] supo3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		int len1 = supo1.length;
		int len2 = supo2.length;
		int len3 = supo3.length;

		int idx = 0;
		int[] cnt = new int[3];
		for(int ans : answers){
			if(ans == supo1[idx % len1]){
				cnt[0]++;
			}
			if(ans == supo2[idx % len2]){
				cnt[1]++;
			}
			if(ans == supo3[idx % len3]){
				cnt[2]++;
			}
			idx++;
		}
		int max = Math.max(cnt[0], Math.max(cnt[1], cnt[2]));

		for(int i = 0; i < 3; i++){
			if(cnt[i] == max) result.add(i + 1);
		}

		return result.stream().mapToInt(i -> i).toArray();
	}
}