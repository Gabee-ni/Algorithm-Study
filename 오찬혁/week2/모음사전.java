import java.util.*;

class Solution {

	String[] vowels = {"A", "E", "I", "O", "U"};
	List<String> dict = new ArrayList<>();

	public int solution(String word) {

		dfs("");

		return dict.indexOf(word) + 1;
	}

	void dfs(String cur){
		if(cur.length() > 5){
			return;
		}
		if(cur.length() > 0){
			dict.add(cur);
		}

		for(int i = 0; i < vowels.length; i++){
			dfs(cur + vowels[i]);
		}
	}
}