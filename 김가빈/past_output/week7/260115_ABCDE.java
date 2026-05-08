import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static boolean found = false;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        // 그래프 초기화
        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }
        
        // 모든 노드에서 DFS 시작
        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            visited[i] = true;    //현재 노드 방문처리
            dfs(i, 1);            //현재 노드를 기준으로 DFS 
            if (found) break;     
        }
        
        System.out.println(found ? 1 : 0);
    }
    
    static void dfs(int now, int depth) {
        //종료조건 -> ABCDE 구조가 있냐니까 5번째 depth까지 왔는지 체크 
        if (depth == 5) { 
            found = true;
            return;
        }
        
        //현재 노드의 다음 노드를 탐색
        for (int next : graph[now]) {
            if (!visited[next]) {
                visited[next] = true;   //다음 노드 방문처리 
                dfs(next, depth + 1);   //다음 노드를 기준으로 DFS
                visited[next] = false;  //여기는 return되어서 온 거니까 백트래킹
                
                if (found) return;  // 이미 찾았으면 더 이상 탐색 안 하게 하기 위함
            }
        }
    }
}