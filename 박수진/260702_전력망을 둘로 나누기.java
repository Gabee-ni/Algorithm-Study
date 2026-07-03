import java.util.*;

class Solution {

    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;

        for (int cut = 0; cut < wires.length; cut++) {
            List<Integer>[] graph = new ArrayList[n + 1];

            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            // cut번째 전선을 제외하고 그래프 생성
            for (int i = 0; i < wires.length; i++) {

                if (i == cut) continue;

                int a = wires[i][0];
                int b = wires[i][1];

                graph[a].add(b);
                graph[b].add(a);
            }

            int cnt = bfs(1, graph, n);

            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
        }

        return answer;
    }

    private int bfs(int start, List<Integer>[] graph, int n) {
        boolean[] visited = new boolean[n + 1];

        Queue<Integer> queue = new ArrayDeque<>();

        queue.offer(start);

        visited[start] = true;

        int count = 1;

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph[now]) {
                if (visited[next]) continue;

                visited[next] = true;

                queue.offer(next);

                count++;
            }
        }

        return count;
    }
}