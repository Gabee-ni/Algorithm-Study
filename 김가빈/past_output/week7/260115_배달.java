import java.util.*;

class Solution {
    static class Edge implements Comparable<Edge> {
        int node;   // 도착 마을
        int time;   // 걸리는 시간
        
        Edge(int node, int time) {
            this.node = node;
            this.time = time;
        }
        
        // 시간이 짧은 것부터 꺼내지게 정렬
        @Override
        public int compareTo(Edge other) {
            return this.time - other.time;
        }
    }
    
    public int solution(int N, int[][] road, int K) {
        ArrayList<Edge>[] graph = new ArrayList[N + 1];
        
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] r : road) {
            int a = r[0];
            int b = r[1];
            int time = r[2];
            graph[a].add(new Edge(b, time));
            graph[b].add(new Edge(a, time));
        }
        
        int[] dist = dijkstra(N, graph);
        
        // 기준보다 더 적게 걸린 배달들 개수 구하기
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                answer++;
            }
        }
        
        return answer;
    }
    
    // 다익스트라 알고리즘
    public int[] dijkstra(int N, ArrayList<Edge>[] graph) {
        final int INF = Integer.MAX_VALUE;
        int[] dist = new int[N + 1];
        
        //무한대로 초기화
        Arrays.fill(dist, INF);
        
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        // 시작저으로 1번 마을부터 큐에 넣고 배달 시간 0으로 초기화
        pq.offer(new Edge(1, 0));
        dist[1] = 0;
        
        while (!pq.isEmpty()) {
            Edge current = pq.poll();
            int now = current.node;
            int nowTime = current.time;
            
            // 이전 노드에서 배달간 시간이 더 작으면 넘김
            if (nowTime > dist[now]) continue;
            
            // 현재 마을과 연결된 다른 마을들 확인
            for (Edge next : graph[now]) {
                int nextNode = next.node;
                int nextTime = nowTime + next.time;
                
                // 걔네가 더 배달시간이 적으면 갱신 
                if (nextTime < dist[nextNode]) {
                    dist[nextNode] = nextTime;
                    pq.offer(new Edge(nextNode, nextTime));
                }
            }
        }
        
        return dist;
    }
}