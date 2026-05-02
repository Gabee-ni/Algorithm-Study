package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 최단경로 {

	static class Node{
		int v, w;

		Node(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	static int V;
	static int E;
	static int K;
	static List<Node>[] graph;
	static int[] dist;
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		V = Integer.parseInt(st.nextToken());
		E = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(br.readLine());

		graph = new List[V + 1];
		dist = new int[V + 1];

		for (int i = 1; i <= V; i++) {
			graph[i] = new ArrayList<>();
			dist[i] = INF;
		}

		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[u].add(new Node(v, w));
		}

		dijkstra(K);

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= V; i++) {
			if (dist[i] == INF) {
				sb.append("INF\n");
			} else {
				sb.append(dist[i]).append('\n');
			}
		}
		System.out.println(sb);
	}

	static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
		dist[start] = 0;
		pq.offer(new Node(start, 0));

		boolean[] visited = new boolean[V + 1];

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			int curV = cur.v;

			if (visited[curV]) {
				continue;
			}
			visited[curV] = true;

			for (Node next : graph[curV]) {
				if (dist[next.v] > dist[curV] + next.w) {
					dist[next.v] = dist[curV] + next.w;
					pq.offer(new Node(next.v, dist[next.v]));
				}
			}

		}
	}
}
