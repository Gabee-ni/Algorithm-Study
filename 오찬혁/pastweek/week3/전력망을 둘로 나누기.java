import java.util.*;

class Solution {

    static List<Integer>[] graph;

    public int solution(int n, int[][] wires) {
        int answer = n;
        graph = new ArrayList[n + 1];

        for(int i = 1; i <= n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < wires.length; i++){
            int a = wires[i][0];
            int b = wires[i][1];
            graph[a].add(b);
            graph[b].add(a);
        }

        // 간선 하나씩 끊어보기
        for(int i = 0; i < wires.length; i++){
            int v1 = wires[i][0];
            int v2 = wires[i][1];

            // 간선 제거
            graph[v1].remove(Integer.valueOf(v2));
            graph[v2].remove(Integer.valueOf(v1));

            // DFS로 한쪽 전력망 크기 구하기
            boolean[] visited = new boolean[n + 1];
            int cnt = dfs(1, visited);

            // 두 전력망 차이 계산
            int diff = Math.abs(cnt - (n - cnt));
            answer = Math.min(answer, diff);

            // 간선 복구
            graph[v1].add(v2);
            graph[v2].add(v1);
        }

        //System.out.println(Arrays.toString(graph));

        return answer;
    }

    private int dfs(int node, boolean[] visited){
        visited[node] = true;
        int cnt = 1;

        for(int next : graph[node]){
            if(!visited[next]){
                cnt += dfs(next, visited);
            }
        }

        return cnt;
    }
}