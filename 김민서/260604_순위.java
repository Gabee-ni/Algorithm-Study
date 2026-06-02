import java.util.*;

class Solution {

    public int solution(int n, int[][] results) {

        List<Integer>[] winGraph = new ArrayList[n + 1];
        List<Integer>[] loseGraph = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            winGraph[i] = new ArrayList<>();
            loseGraph[i] = new ArrayList<>();
        }

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];

            winGraph[winner].add(loser);
            loseGraph[loser].add(winner);
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {

            int winCount = bfs(i, winGraph, n);
            int loseCount = bfs(i, loseGraph, n);

            if (winCount + loseCount == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    private int bfs(int start, List<Integer>[] graph, int n) {

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;

        int count = 0;

        while (!q.isEmpty()) {

            int cur = q.poll();

            for (int next : graph[cur]) {

                if (!visited[next]) {
                    visited[next] = true;
                    q.offer(next);
                    count++;
                }
            }
        }

        return count;
    }
}