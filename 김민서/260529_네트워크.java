import java.util.*;

class Solution {
    
    static List<Integer>[] graph;
    static boolean[] visited;
    static int cnt = 0;
    
    public int solution(int n, int[][] computers) {
        
        visited = new boolean[n + 1];
        
        graph = new ArrayList[n + 1];
        
        for(int i = 1; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == j) {
                    continue;
                }
                
                if (computers[i][j] == 1) {
                    graph[i + 1].add(j + 1);
                    graph[j + 1].add(i + 1);
                }
            }
        }
        
        for (int i = 1; i < n + 1; i++) {
            if (!visited[i]) {
                cnt++;
                dfs(i);
            }
        }
        
        return cnt;
    }
    
    static void dfs(int idx) {
        
        for (int next : graph[idx]) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
        
        return;
    }
}