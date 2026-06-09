import java.util.*;

class Solution {
    public int solution(int n, int[][] vertex) {
        ArrayList<Integer>[] graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : vertex) {
            int a = edge[0];
            int b = edge[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);

        Queue<Integer> queue = new LinkedList<>();

        queue.add(1);
        distance[1] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (distance[next] == -1) {
                    distance[next] = distance[current] + 1;
                    queue.add(next);
                }
            }
        }

        int maxDistance = 0;

        for (int i = 1; i <= n; i++) {
            maxDistance = Math.max(maxDistance, distance[i]);
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (distance[i] == maxDistance) {
                answer++;
            }
        }

        return answer;
    }
}