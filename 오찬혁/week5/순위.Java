import java.util.*;

class Solution {

	static List<Integer>[] graph;
	static List<Integer>[] reGraph;
	static boolean[] visited;

	public int solution(int n, int[][] results) {
		int answer = 0;
		graph = new List[n + 1];
		reGraph = new List[n + 1];

		for(int i = 0; i <= n; i++){
			graph[i] = new ArrayList<>();
			reGraph[i] = new ArrayList<>();
		}

		for(int[] r: results){
			graph[r[0]].add(r[1]);
			reGraph[r[1]].add(r[0]);
		}

		for(int i = 1; i <= n; i++){
			visited = new boolean[n + 1];
			int win = dfs(i, graph) - 1;

			visited = new boolean[n + 1];
			int lose = dfs(i, reGraph) - 1;

			if(win + lose == n - 1){
				answer++;
			}
		}

		return answer;
	}

	static int dfs(int node, List<Integer>[] g){
		visited[node] = true;
		int cnt = 1;
		for(int next : g[node]){
			if(!visited[next]){
				cnt += dfs(next, g);
			}
		}

		return cnt;
	}
}