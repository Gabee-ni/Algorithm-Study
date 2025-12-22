import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken()); // N개의 도시
		int M = Integer.parseInt(st.nextToken()); // M개의 도로
		int K = Integer.parseInt(st.nextToken()); // 거리
		int X = Integer.parseInt(st.nextToken()); // 출발 도시

		List<Integer>[] cities = new ArrayList[N + 1];
		boolean[] visited = new boolean[N + 1];
		int[] dist = new int[N + 1];
		Arrays.fill(dist, Integer.MAX_VALUE);

		for (int city = 1; city <= N; city++)
			cities[city] = new ArrayList<>();

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			cities[a].add(b);
		}

		// 시작점 초기화
		dist[X] = 0;

		PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
		pq.add(new int[] {0, X}); // {거리, 도시}

		while (!pq.isEmpty()) {
			int[] current = pq.poll();
			int currentDistance = current[0], currentCity = current[1];

			if (currentDistance != dist[currentCity]) // 목표 거리인 경우 아래 확장 진행 X
				continue;
			if (currentDistance > K) // 목표 거리보다 멀면 break
				break;
			if (currentDistance == K) // 목표 거리인 경우 아래 확장 진행 X
				continue;

			for (int nextCity : cities[currentCity]) {
				int nextDistance = currentDistance + 1;
				if (nextDistance < dist[nextCity]) {
					dist[nextCity] = nextDistance;
					pq.add(new int[] {nextDistance, nextCity});
				}
			}
		}

		StringBuilder answer = new StringBuilder();
		for (int city = 1; city <= N; city++) {
			if (dist[city] == K)
				answer.append(city + "\n");
		}

		System.out.println(answer.length() == 0 ? -1 : answer.toString());
	}

}