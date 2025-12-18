import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class City {
	static List<Integer>[] graph;
	static int[] dist;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());

		graph = new ArrayList[n + 1];

		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			graph[a].add(b);
		}

		dist = new int[n + 1];
		Arrays.fill(dist, -1);

		find(x);

		boolean found = false;
		for (int i = 1; i <= n; i++) {
			if (dist[i] == k) {
				System.out.println(i);
				found = true;
			}
		}
		if (!found)
			System.out.println(-1);
	}

	public static void find(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.add(start);
		dist[start] = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : graph[cur]) {
				if (dist[next] == -1) {
					dist[next] = dist[cur] + 1;
					q.add(next);
				}
			}
		}
	}

}
