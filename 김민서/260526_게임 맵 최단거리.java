import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][] dist = new int[n][m];
        Queue<int[]> road = new LinkedList<int[]>();
        int[] dn = {0, 0, 1, -1};
        int[] dm = {1, -1, 0, 0};
        
        road.offer(new int[]{0, 0});
        visited[0][0] = true;
        dist[0][0] = 1;
        
        while(!road.isEmpty()) {
            int[] now = road.poll();
            int cn = now[0];
            int cm = now[1];
            
            for(int i = 0; i < 4; i++) {
                int nn = cn + dn[i];
                int nm = cm + dm[i];
                
                if (nn < 0 || nm < 0 || nn >= n || nm >= m) continue;
                if (maps[nn][nm] == 0) continue;
                if (visited[nn][nm]) continue;
                
                visited[nn][nm] = true;
                if(nn == n - 1 && nm == m - 1){
                    return dist[cn][cm] + 1;
                }
                dist[nn][nm] = dist[cn][cm] + 1;
                road.offer(new int[]{nn, nm});
            }
        }

        return -1;
    }
}