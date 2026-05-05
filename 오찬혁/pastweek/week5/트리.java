package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class 트리 {

	static boolean[] visited;
	static List<Integer>[] graph;
	static int[] leaf;
	static int removeNode;
	static int leafCnt;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		graph = new ArrayList[N];
		visited = new boolean[N];
		leaf = new int[N];
		int[] parent = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			graph[i] = new ArrayList<>();
			parent[i] = Integer.parseInt(st.nextToken());
		}

		int root = -1;
		for (int i = 0; i < N; i++) {
			if (parent[i] == -1) {
				root = i;
			} else {
				graph[parent[i]].add(i);
			}
		}

		int remove = Integer.parseInt(br.readLine());
		// root를 삭제하면 트리 자체가 없어짐
		if (remove == root) {
			System.out.println(0);
			return;
		}

		leafCnt = 0;
		removeNode = remove;
		dfs(root);
		System.out.println(leafCnt);

	}

	static void dfs(int cur) {
		visited[cur] = true;
		int childCnt = 0;

		for (int next : graph[cur]) {
			// 삭제된 노드로는 안 내려감
			if (next == removeNode) {
				continue;
			}
			if (!visited[next]) {
				visited[next] = true;
				childCnt++;
				dfs(next);
			}
		}

		if (childCnt == 0) {
			leafCnt++;
		}
	}
}
