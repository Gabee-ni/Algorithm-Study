import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        
        List<int[]>[] graph = new List[n];
        
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int[] c : costs) {
            graph[c[0]].add(new int[] {c[1], c[2]});
            graph[c[1]].add(new int[] {c[0], c[2]});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[] {0, 0});
        
        boolean[] visited = new boolean[n];
        
        int answer = 0;
        int cnt = 0;
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int land = cur[0];
            int cost = cur[1];
            
            if (visited[land]) continue;
            
            visited[land] = true;
            
            answer += cost;
            cnt++;
            
            if (cnt == n) break;
            
            for (int[] next : graph[land]) {
                if (!visited[next[0]]) {
                    pq.offer(new int[] {next[0], next[1]});
                }
            }
        }
        
        return answer;
    }
}