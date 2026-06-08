import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        
        List<Integer>[] graph= new List[n + 1];
        
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        
        Queue<Integer> q = new LinkedList<>();
        int[] visited = new int[n + 1];

        Arrays.fill(visited, -1);
        visited[1] = 0;
        
        q.offer(1);

        while (!q.isEmpty()) {
            int cur = q.poll();

            for (int next : graph[cur]) {
                if (visited[next] == -1) {
                    visited[next] = visited[cur] + 1;
                    q.offer(next);
                }
            }
        }
        
        int max = 0;
        int cnt = 0;

        for (int d : visited) {
            if (d > max) {
                max = d;
                cnt = 1;
            } else if (d == max) {
                cnt++;
            }
        }
        return cnt;
    }
}