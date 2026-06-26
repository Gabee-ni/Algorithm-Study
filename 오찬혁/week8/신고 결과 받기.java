import java.util.*;

class Solution {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		Map<String, Set<String>> reported = new HashMap<>();

		for(int i = 0; i < report.length; i++){
			String[] temp = report[i].split(" ");
			String from = temp[0], to = temp[1];
			reported.computeIfAbsent(to, key -> new HashSet<>()).add(from);
		}

		Map<String, Integer> mailCnt = new HashMap<>();
		for(Set<String> set : reported.values()){
			if(set.size() >= k){
				for(String name : set){
					mailCnt.merge(name, 1, Integer::sum);
				}
			}
		}

		for(int i = 0; i < id_list.length; i++){
			answer[i] = mailCnt.getOrDefault(id_list[i], 0);
		}

		return answer;
	}
}