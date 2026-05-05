import java.io.*;
import java.util.*;

class Edge implements Comparable<Edge> {
    int node;    // 목적지 노드
    int cost;    // 가중치 비용
    
    Edge(int node, int cost) {
        this.node = node;
        this.cost = cost;
    }
    
    // 우선순위 큐에서 비용이 작은 것부터 나오도록 정렬
    @Override
    public int compareTo(Edge other) {
        return this.cost - other.cost;
    }
}

public class Main {
    static final int INF = Integer.MAX_VALUE;  //무한대 값
    static ArrayList<Edge>[] graph;            
    static int[] dist;    //시작~ 각 노드까지의 최단거리를 담을 배열
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int V = Integer.parseInt(st.nextToken());  // 정점 개수
        int E = Integer.parseInt(st.nextToken());  // 간선 개수
        int K = Integer.parseInt(br.readLine());   // 시작 정점
        
        graph = new ArrayList[V + 1];
        dist = new int[V + 1];
        
        for (int i = 1; i <= V; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = INF;  // 최단거리 처음에는 무한대로 초기화 
        }
        
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());  // 출발
            int v = Integer.parseInt(st.nextToken());  // 도착
            int w = Integer.parseInt(st.nextToken());  // 가중치
            graph[u].add(new Edge(v, w));
        }
      
        dijkstra(K);
        
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= V; i++) {
            if (dist[i] == INF) {
                sb.append("INF\n");
            } else {
                sb.append(dist[i]).append("\n");
            }
        }
        System.out.print(sb);
    }
    
    static void dijkstra(int start) {
        // 우선순위 큐이기에 비용 작은 것부터 꺼내짐
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        
        // 시작점
        pq.offer(new Edge(start, 0));
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            // 현재 노드 -> 비용 가장 작은 애 
            Edge current = pq.poll();
            int now = current.node;
            int nowCost = current.cost;
            
            // 지금 비용이 이전의 최단거리 배열에 저장된 비용보다 크면 다음으로
            if (nowCost > dist[now]) continue;
            
            // 현재 노드의 다음 노드들을 탐색
            for (Edge next : graph[now]) {
                int nextNode = next.node;
                int nextCost = nowCost + next.cost;  // 현재까지 비용 + 다음 간선 비용
                
                // 더 짧은 경로를 발견했다면 갱신
                if (nextCost < dist[nextNode]) {
                    dist[nextNode] = nextCost;
                    pq.offer(new Edge(nextNode, nextCost));
                }
            }
        }
    }
}