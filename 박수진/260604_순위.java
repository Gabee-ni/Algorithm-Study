import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {

        List<Integer>[] win = new ArrayList[n + 1];
        List<Integer>[] lose = new ArrayList[n + 1];

        for (int i = 1; i <= n; i++) {
            win[i] = new ArrayList<>();
            lose[i] = new ArrayList<>();
        }

        for (int[] r : results) {
            win[r[0]].add(r[1]);
            lose[r[1]].add(r[0]);
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {

            int winCnt = bfs(win, i, n);
            int loseCnt = bfs(lose, i, n);

            if (winCnt + loseCnt == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    private int bfs(List<Integer>[] graph, int start, int n) {

        boolean[] visited = new boolean[n + 1];
        Queue<Integer> q = new LinkedList<>();

        q.offer(start);
        visited[start] = true;

        int count = 0;

        while (!q.isEmpty()) {

            int cur = q.poll();

            for (int next : graph[cur]) {

                if (visited[next]) continue;

                visited[next] = true;
                q.offer(next);
                count++;
            }
        }

        return count;
    }
}