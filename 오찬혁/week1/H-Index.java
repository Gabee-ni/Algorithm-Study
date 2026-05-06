import java.util.*;

class Solution {
	public int solution(int[] citations) {
		int answer = 0;

		Arrays.sort(citations);

		int left = 0;
		int right = citations[citations.length - 1];

		while(left <= right){
			int mid = (left + right) / 2;

			if(canUse(citations, mid)){
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}

		return answer;
	}

	boolean canUse(int[] citations, int mid){
		int cnt = 0;
		for(int ci : citations){
			if(ci >= mid){
				cnt++;
			}
		}

		return cnt >= mid;
	}
}