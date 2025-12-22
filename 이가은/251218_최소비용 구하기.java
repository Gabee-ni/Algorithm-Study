import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(bf.readLine());
		int M = Integer.parseInt(bf.readLine());

		Map<Integer, List<int[]>> costStartMap = new HashMap<>();
		int cityMinCosts[] = new int[N + 1];
		boolean visited[] = new boolean[N + 1];

		for (int city = 1; city <= N; city++)
			costStartMap.put(city, new ArrayList<>());

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(bf.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			costStartMap.get(start).add(new int[] {end, cost});
		}

		st = new StringTokenizer(bf.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		// 비용 초기화
		Arrays.fill(cityMinCosts, Integer.MAX_VALUE);
		cityMinCosts[start] = 0;

		for (int visitCnt = 0; visitCnt < N - 1; visitCnt++) {
			int minCity = 0;
			int minCost = Integer.MAX_VALUE;

			// 방문하지 않은 도시 중 최소 비용인 도시 찾기
			for (int city = 1; city <= N; city++) {
				if (visited[city])
					continue;

				if (cityMinCosts[city] < minCost) {
					minCost = cityMinCosts[city];
					minCity = city;
				}
			}

			if (minCity == 0)
				break;

			// 최소 비용 도시 방문 처리
			visited[minCity] = true;

			// 해당 도시를 거쳐서 각 노드까지 가는 비용과 기존에 구한 각 노드의 최소 비용 비교
			List<int[]> adjList = costStartMap.get(minCity);
			for (int[] adjCityInfo : adjList) {
				int adjCity = adjCityInfo[0];
				int adjCost = adjCityInfo[1];
				int minCityCost = cityMinCosts[minCity];

				if (minCityCost + adjCost < cityMinCosts[adjCity]) {
					cityMinCosts[adjCity] = minCityCost + adjCost;
				}
			}
		}

		System.out.println(cityMinCosts[end]);
	}

}