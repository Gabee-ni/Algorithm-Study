import java.util.*;

class Solution {

	static int n;
	static String[][] relation;
	static List<List<Integer>> keys = new ArrayList<>();

	public int solution(String[][] relation) {
		n = relation[0].length;
		this.relation = relation;

		findComb(0, new ArrayList<>());

		return keys.size();
	}

	static void findComb(int idx, List<Integer> picked){
		if(idx == n){
			if(picked.isEmpty()) return;
			// System.out.println(picked);
			if(isUnique(picked)){
				for(List<Integer> key : keys){
					if(picked.containsAll(key)) return;
				}
				keys.add(new ArrayList<>(picked));
			}

			return;
		}

		findComb(idx + 1, picked);

		picked.add(idx);
		findComb(idx + 1, picked);
		picked.remove(picked.size() - 1);
	}

	static boolean isUnique(List<Integer> picked){
		Set<String> set = new HashSet<>();
		for(int i = 0; i < relation.length; i++){
			StringBuilder sb = new StringBuilder();
			for(int idx : picked){
				sb.append(relation[i][idx]).append(",");
			}
			set.add(sb.toString());
		}

		return set.size() == relation.length;
	}
}