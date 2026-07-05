import java.util.*;

class Solution {
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int[][] visited;
    static int[][] map;
    
    public int solution(String[] maps) {
        visited = new int[maps.length][maps[0].length()];
        
        for (int[] v : visited) {
            Arrays.fill(v, -1);
        }
        
        map = new int[maps.length][maps[0].length()];
        int[] start = new int[2];
        int[] lab = new int[2];
        
        for (int i = 0; i < maps.length; i++) {
            
            char[] m = maps[i].toCharArray();
            for (int j = 0; j < m.length; j++) {
                if (m[j] == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (m[j] == 'L') {
                    map[i][j] = 2;
                    lab[0] = i;
                    lab[1] = j;
                } else if (m[j] == 'E') {
                    map[i][j] = 3;
                } else if (m[j] == 'X') {
                    map[i][j] = -1;
                } 
            }
        }
        
        int d = bfs(start[0], start[1], 2);
        
        if (d == -1) {
            return -1;
        }
        
        for (int[] v : visited) {
            Arrays.fill(v, -1);
        }
        
        int di = bfs(lab[0], lab[1], 3);
        
        if (di == -1) {
            return -1;
        }
        
        return d + di;
    }
    
    int bfs(int sx, int sy, int type) {
        Queue<int[]> que = new LinkedList<>();
        
        que.offer(new int[] {sx, sy});
        visited[sx][sy] = 0;
        
        while (!que.isEmpty()) {
            int[] cur = que.poll();
            int cx = cur[0];
            int cy = cur[1];
            
            if (map[cx][cy] == type) {
                return visited[cx][cy];
            }
            
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                
                if (nx < 0 || ny < 0 || nx >= visited.length || ny >= visited[0].length) {
                    continue;
                }
                if (map[nx][ny] == -1) {
                    continue;
                } 
                if (visited[nx][ny] != -1){
                    continue;
                }
                
                visited[nx][ny] = visited[cx][cy] + 1;
                que.offer(new int[] {nx, ny});
            }
        }
        
        return -1;
    }
}