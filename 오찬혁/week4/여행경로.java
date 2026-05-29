import java.util.*;

class Solution {

	String[] answer;
	boolean[] visited;

	public String[] solution(String[][] tickets) {
		int n = tickets.length;

		answer = new String[n + 1];
		visited = new boolean[n + 1];

		Arrays.sort(tickets, (a, b) -> {
			if(!a[0].equals(b[0])){
				return a[0].compareTo(b[0]);
			}
			return a[1].compareTo(b[1]);
		});

		answer[0] = "ICN";
		dfs("ICN", 0, tickets);

		return answer;
	}

	boolean dfs(String cur, int depth, String[][] tickets){
		if(depth == tickets.length){
			return true;
		}

		for(int i = 0; i < tickets.length; i++){
			if(!visited[i] && tickets[i][0].equals(cur)){
				visited[i] = true;
				answer[depth + 1] = tickets[i][1];
				if(dfs(tickets[i][1], depth + 1, tickets)){
					return true;
				}
				visited[i] = false;

			}
		}
		return false;
	}
}