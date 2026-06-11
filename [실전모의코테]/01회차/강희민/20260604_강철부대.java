import java.util.*;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 그래프 만들기
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < roads.length; i++) {
            int a = roads[i][0];
            int b = roads[i][1];

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        // 거리 배열 만들기
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();

        queue.add(destination);
        dist[destination] = 0;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph.get(now)) {
                if (dist[next] == -1) {
                    dist[next] = dist[now] + 1;
                    queue.add(next);
                }
            }
        }

        int[] answer = new int[sources.length];

        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }

        return answer;
    }
}