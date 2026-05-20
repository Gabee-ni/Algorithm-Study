import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public static int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        List<Integer>[] connection = new List[n + 1];
        for (int i = 0; i <= n; i++)  connection[i] = new ArrayList<>();
        
        for (int[] wire: wires) {
            int a = wire[0];
            int b = wire[1];
            connection[a].add(b);
            connection[b].add(a);
        }
        
        for (int[] wire : wires) {
            boolean visited[] = new boolean[n + 1];
            int a = wire[0]; int b = wire[1];
            int cnt = 0;
            
            connection[a].remove(Integer.valueOf(b));
            connection[b].remove(Integer.valueOf(a));
            
            Queue<Integer> queue = new LinkedList<>();
            
            queue.add(1);
            visited[1] = true;

            while(!queue.isEmpty()) {
               int q = queue.poll();
                cnt++;
                for (int next : connection[q]) {
                    if (visited[next]) continue;
                    visited[next] = true;
                    queue.add(next);
                }
            }
            
            answer = Math.min(Math.abs(cnt - (n - cnt)), answer);
            
            connection[a].add(b);
            connection[b].add(a);
        }
        
        return answer;
    }
    
}