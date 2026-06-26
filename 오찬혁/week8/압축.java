import java.util.*;

class Solution {
	public int[] solution(String msg) {
		Map<String, Integer> dict = new HashMap<>();
		// A~Z 를 1~26 으로 초기화
		for (int i = 0; i < 26; i++) {
			dict.put(String.valueOf((char)('A' + i)), i + 1);
		}
		int next = 27;                 // 다음에 등록할 번호

		List<Integer> result = new ArrayList<>();
		int i = 0, n = msg.length();

		while (i < n) {
			// 1) 사전에 있는 가장 긴 조각 w 찾기
			String w = String.valueOf(msg.charAt(i));
			int j = i + 1;
			while (j < n && dict.containsKey(w + msg.charAt(j))) {
				w += msg.charAt(j);    // 한 글자 더 붙여서 더 긴 조각 시도
				j++;
			}

			// 2) w 번호 출력
			result.add(dict.get(w));

			// 3) w + 다음 글자 를 새 번호로 등록 (다음 글자가 있을 때만)
			if (j < n) {
				dict.put(w + msg.charAt(j), next++);
			}

			// 4) w 길이만큼 건너뛰기
			i = j;
		}

		// List<Integer> → int[]
		int[] answer = new int[result.size()];
		for (int k = 0; k < result.size(); k++) {
			answer[k] = result.get(k);
		}
		return answer;
	}
}