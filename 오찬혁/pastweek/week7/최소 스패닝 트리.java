package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 최소스패닝트리 {
	static class Edge implements Comparable<Edge> {
		int u, v, cost;

		public Edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost;
		}
	}

	static class DSU {
		int[] parent, rank;

		DSU(int n) {
			parent = new int[n + 1];
			rank = new int[n + 1];
			for (int i = 1; i <= n; i++) {
				parent[i] = i;
			}
		}

		int find(int x) {
			if (parent[x] == x) {
				return x;
			}
			return parent[x] = find(parent[x]);
		}

		boolean union(int a, int b) {
			a = find(a);
			b = find(b);

			if (a == b) {
				return false;
			}
			if (rank[a] < rank[b]) {
				parent[a] = b;
			} else if (rank[a] > rank[b]) {
				parent[b] = a;
			} else {
				parent[b] = a;
				rank[a]++;
			}
			return true;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Edge> edges = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());

			edges.add(new Edge(a, b, c));
		}

		Collections.sort(edges);

		DSU dsu = new DSU(N);

		long answer = 0;
		long cnt = 0;

		for (Edge e : edges) {
			if (dsu.union(e.u, e.v)) {
				answer += e.cost;
				cnt++;
				if (cnt == N - 1) {
					break;
				}

			}
		}

		System.out.println(answer);
	}
}
