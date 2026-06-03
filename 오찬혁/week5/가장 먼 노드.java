import java.util.*;

class Solution {

	static List<List<Integer>> graph;
	static int[] dist;

	public int solution(int n, int[][] edge) {
		graph = new ArrayList<>();
		dist = new int[n + 1];
		Arrays.fill(dist, -1);

		for(int i = 0; i <= n; i++){
			graph.add(new ArrayList<>());
		}

		for(int[] e : edge){
			graph.get(e[0]).add(e[1]);
			graph.get(e[1]).add(e[0]);
		}

		return bfs();
	}

	static int bfs(){
		Queue<Integer> q = new LinkedList<>();

		q.add(1);
		dist[1] = 0;

		while(!q.isEmpty()){
			int cur = q.poll();

			for(int next : graph.get(cur)){
				if(dist[next] == -1){
					dist[next] = dist[cur] + 1;
					q.add(next);
				}
			}
		}

		int maxDist = Arrays.stream(dist).max().getAsInt();

		return (int) Arrays.stream(dist).filter(d -> d == maxDist).count();
	}
}