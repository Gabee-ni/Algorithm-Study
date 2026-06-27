import java.util.*;

class Solution {
	public int solution(int[] elements) {
		Set<Integer> set = new HashSet<>();
		int n = elements.length;

		// 부분 수열 길이
		for(int len = 1; len <= n; len++){
			// 시작 위치
			for(int start = 0; start < n; start++){
				int sum = 0;
				for(int k = 0; k < len; k++){
					sum += elements[(start + k) % n];
				}
				set.add(sum);
			}
		}

		return set.size();
	}
}
