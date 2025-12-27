package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리의부모찾기 {

	static boolean[] visited;
	static List<Integer>[] adj;
	static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		visited = new boolean[N + 1];
		adj = new ArrayList[N + 1];
		parent = new int[N + 1];

		for (int i = 1; i <= N; i++) {
			adj[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			adj[a].add(b);
			adj[b].add(a);
		}

		dfs(1);

		StringBuilder sb = new StringBuilder();
		for (int i = 2; i <= N; i++) {
			sb.append(parent[i]).append("\n");
		}

		System.out.println(sb);
	}

	static void dfs(int cur) {
		visited[cur] = true;
		for (int next : adj[cur]) {
			if (!visited[next]) {
				parent[next] = cur;
				dfs(next);
			}
		}
	}
}
