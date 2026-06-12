import java.util.*;

class Solution {
    
    static boolean found = false;
    static int min = Integer.MAX_VALUE;
    static List<Integer>[] graph;
    static int[] dist;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        
        graph= new List[n + 1];
        dist = new int[n + 1];
        
        for (int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < roads.length; i++) {
            graph[roads[i][0]].add(roads[i][1]);
            graph[roads[i][1]].add(roads[i][0]);
        }
        
        int[] answer = new int[sources.length];
        
        bfs(destination);
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
    
    
    static void bfs(int destination) {
        
        Arrays.fill(dist, -1);
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(destination);
        dist[destination] = 0;
        
        while(!q.isEmpty()) {
            
            int cur = q.poll();
            
            for (int next : graph[cur]) {
                
                if (dist[next] == -1) {
                    q.offer(next);
                    dist[next] = dist[cur] + 1;
                }
            }
            
        }
        
        return;
    }
}