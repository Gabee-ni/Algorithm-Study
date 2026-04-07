import java.io.*;
import java.util.*;

class Main {
    
    static int[][] map;
    static boolean[] visited;
    static int M;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < N; i++) {
            M = Integer.parseInt(br.readLine());
            map = new int[M + 2][2];
            visited = new boolean[M + 2];
            
            for(int j = 0; j < M + 2; j++) {
                st = new StringTokenizer(br.readLine());
                
                map[j][0] = Integer.parseInt(st.nextToken());
                map[j][1] = Integer.parseInt(st.nextToken());
            }
            
            visited[0] = true;
            boolean canGo = bfs(0);
            
            if(!canGo) {
                System.out.println("sad");
            } else {
                System.out.println("happy");
            }
            
        }
    }
    
    static boolean bfs(int idx) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(idx);
            
        while(!q.isEmpty()) {
            int cur = q.poll();
            int cx = map[cur][0];
            int cy = map[cur][1];
                
            if(cur == M + 1) {
                return true;
            }
                
            for(int i = 1; i < M + 2; i++) {
                if(visited[i]) {
                    continue;
                }
                
                int dist = Math.abs(map[i][0] - cx) + Math.abs(map[i][1] - cy);
                
                if(dist <= 1000) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
            
        return false;
    }
}