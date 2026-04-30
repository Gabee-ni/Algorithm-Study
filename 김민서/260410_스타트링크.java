import java.io.*;
import java.util.*;

class Main {
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int F = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int G = Integer.parseInt(st.nextToken());
        int U = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());
        
        boolean[] visited = new boolean[F + 1];
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {S, 0});
        
        while(!q.isEmpty()) {
            int[] now = q.poll();
            int cur = now[0];
            int dist = now[1];
            
            if(cur == G) {
                System.out.println(dist);
                return;
            }
            
            if((cur + U) <= F && !visited[cur + U]) {
                visited[cur + U] = true;
                q.offer(new int[] {cur + U, dist + 1});
            }
            
            if((cur - D) >= 1 && !visited[cur - D]) {
                visited[cur - D] = true;
                q.offer(new int[] {cur - D, dist + 1});
            }
        }
        
        System.out.println("use the stairs");
    }
}