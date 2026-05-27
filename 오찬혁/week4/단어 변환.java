import java.util.*;

class Solution {

	static boolean[] visited;
	static int answer = Integer.MAX_VALUE;

	public int solution(String begin, String target, String[] words) {
		visited = new boolean[words.length];

		dfs(begin, begin, target, words, 0);

		return answer == Integer.MAX_VALUE ? 0 : answer;
	}

	static void dfs(String begin, String cur, String target, String[] words, int cnt){
		if(cur.equals(target)){
			answer = Math.min(answer, cnt);
			return;
		}

		for(int i = 0; i < words.length; i++){
			if(!visited[i] && canConvert(cur, words[i])){
				visited[i] = true;
				dfs(begin, words[i], target, words, cnt + 1);
				visited[i] = false;
			}
		}
	}

	static boolean canConvert(String a, String b){
		int diff = 0;
		for(int i = 0; i < a.length(); i++){
			if(a.charAt(i) != b.charAt(i)) diff++;
		}
		return diff == 1;
	}
}