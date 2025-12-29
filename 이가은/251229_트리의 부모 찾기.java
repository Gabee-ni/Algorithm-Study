import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(bf.readLine());

		List<Integer>[] graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < n - 1; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}

		int[] parent = new int[n + 1];
		boolean[] visited = new boolean[n + 1];

		Queue<Integer> queue = new LinkedList<>();
		queue.add(1);
		visited[1] = true;

		while (!queue.isEmpty()) {
			int current = queue.poll();
			for (int next : graph[current]) {
				if (visited[next])
					continue;
				visited[next] = true;
				parent[next] = current;
				queue.add(next);
			}
		}

		for (int i = 2; i < n + 1; i++) {
			sb.append(parent[i] + "\n");
		}

		System.out.println(sb);
	}
}