import java.util.*;

class Solution {
    boolean[] visited;
    int N;
    String[] answer;
    
    public String[] solution(String[][] tickets) {
        N = tickets.length;
        visited = new boolean[N];
        answer = new String[N+1];
        answer[0] = "ICN";
        
        Arrays.sort(tickets, (o1, o2) -> {
            if (o1[0].equals(o2[0])) {
                return o1[1].compareTo(o2[1]);
            }
            
            return o1[0].compareTo(o2[0]);
        });
        
        dfs("ICN", 1, tickets);
        
        return answer;
    }
    
    private boolean dfs(String current, int depth, String[][] tickets) {
        if (depth == N+1) return true;
        
        for (int i = 0; i < N; i++) {
            if (!visited[i] && tickets[i][0].equals(current)) {
                answer[depth] = tickets[i][1];
                visited[i] = true;
                
                if (dfs(tickets[i][1], depth+1, tickets)) {
                    return true;
                }
                
                // 백트래킹
                answer[depth] = null;
                visited[i] = false;
            }
        }
        
        return false;
    }
}