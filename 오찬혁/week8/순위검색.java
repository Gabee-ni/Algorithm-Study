import java.util.*;

class Solution {
	public int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];
		Map<String, List<Integer>> map = new HashMap<>();

		for(String s : info){
			String[] t = s.split(" ");
			int score = Integer.parseInt(t[4]);

			String[] lang = {t[0], "-"};
			String[] job = {t[1], "-"};
			String[] career = {t[2], "-"};
			String[] food = {t[3], "-"};
			for(String a : lang){
				for(String b : job){
					for(String c : career){
						for(String d : food){
							String key = a + " " + b + " " + c + " " + d;
							map.computeIfAbsent(key, k -> new ArrayList<>()).add(score);
						}
					}
				}
			}

		}

		for(List<Integer> list : map.values()){
			Collections.sort(list);
		}

		for(int i = 0; i < query.length; i++){
			String q = query[i].replaceAll(" and ", " ");
			String[] t = q.split(" ");

			int target = Integer.parseInt(t[4]);
			String key = t[0] + " " + t[1] + " " + t[2] + " " + t[3];

			List<Integer> list = map.get(key);
			if(list == null){
				answer[i] = 0;
				continue;
			}

			answer[i] = list.size() - lowerBound(list, target);
		}

		return answer;
	}

	private int lowerBound(List<Integer> list, int target){
		int lo = 0, hi = list.size();
		while(lo < hi){
			int mid = (lo + hi) / 2;
			if(list.get(mid) >= target){
				hi = mid;
			} else {
				lo = mid + 1;
			}
		}
		return lo;
	}
}