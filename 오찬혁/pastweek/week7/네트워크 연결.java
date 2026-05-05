package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class 네트워크연결 {

	static class Edge implements Comparable<Edge> {
		int u, v, cost;

		Edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}

		@Override
		public int compareTo(Edge o) {
			return this.cost - o.cost; // 비용 오름차순
		}
	}

	static class DSU{
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
			// 이미 같은 집합
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
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		List<Edge> edges = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			edges.add(new Edge(a, b, c));
		}

		// 간선을 비용 기준으로 정렬
		Collections.sort(edges);

		// DSU 초기화
		DSU dsu = new DSU(N);

		int used = 0; // 선택한 간선 개수
		int answer = 0; // 총 비용

		// 가장 싼 간선부터 하나씩 보면서 MST 만들기
		for (Edge e : edges) {
			if (dsu.union(e.u, e.v)) {
				answer += e.cost; // 실제 두 컴포넌트를 합친 경우만 비용 더함
				used++;
				if (used == N - 1) {
					break;
				}
			}
		}

		System.out.println(answer);
	}
}
