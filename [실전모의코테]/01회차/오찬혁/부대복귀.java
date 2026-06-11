import java.util.*;

class Solution {

	static List<Integer>[] graph;
	static int[] dist;

	public int[] solution(int n, int[][] roads, int[] sources, int destination) {
		List<Integer> result = new ArrayList<>();
		graph = new List[n + 1];

		for(int i = 1; i <= n; i++){
			graph[i] = new ArrayList<>();
		}

		for(int[] r : roads){
			graph[r[0]].add(r[1]);
			graph[r[1]].add(r[0]);
		}

		bfs(n, destination);
		for(int s : sources){
			result.add(dist[s]);
		}

		return result.stream().mapToInt(i -> i).toArray();
	}

	static void bfs(int n, int d){
		Queue<Integer> q = new LinkedList<>();
		dist = new int[n + 1];

		Arrays.fill(dist, -1);
		dist[d] = 0;
		q.add(d);

		while(!q.isEmpty()){
			int cur = q.poll();

			for(int next : graph[cur]){
				if(dist[next] == -1){
					dist[next] = dist[cur] + 1;
					q.add(next);
				}
			}
		}
	}
}