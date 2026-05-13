import java.util.*;

class Solution {
    List<Integer>[] graph;
    boolean[] visited;

    public int solution(int n, int[][] wires) {
        graph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            graph[a].add(b);
            graph[b].add(a);
        }

        int answer = n;

        for (int[] wire : wires) {
            int a = wire[0];
            int b = wire[1];

            visited = new boolean[n + 1];

            int count = dfs(a, b);

            int diff = Math.abs(count - (n - count));
            answer = Math.min(answer, diff);
        }

        return answer;
    }

    private int dfs(int current, int blocked) {
        visited[current] = true;
        int count = 1;

        for (int next : graph[current]) {
            if (next == blocked) continue;

            if (!visited[next]) {
                count += dfs(next, blocked);
            }
        }

        return count;
    }
}