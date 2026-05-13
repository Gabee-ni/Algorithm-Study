import java.util.*;

class Solution {

    static boolean[] visited;

    public int solution(int n, int[][] wires) {

        // 최소 차이를 저장할 변수
        int answer = n;

        // 전선을 하나씩 끊어보기
        for (int i = 0; i < wires.length; i++) {

            // 그래프 생성
            ArrayList<Integer>[] graph = new ArrayList[n + 1];

            // 각 번호마다 연결 리스트 생성
            for (int j = 1; j <= n; j++) {
                graph[j] = new ArrayList<>();
            }

            // i번째 전선을 제외하고 그래프 연결
            for (int j = 0; j < wires.length; j++) {

                // 현재 끊을 전선이면 건너뜀
                if (i == j) continue;

                int a = wires[j][0];
                int b = wires[j][1];

                // 양방향 연결
                graph[a].add(b);
                graph[b].add(a);
            }

            // 방문 배열 초기화
            visited = new boolean[n + 1];

            // 1번 송전탑 기준으로 연결된 개수 세기
            int count = dfs(1, graph);

            int other = n - count;

            int diff = Math.abs(count - other);

            answer = Math.min(answer, diff);
        }

        return answer;
    }

    static int dfs(int node, ArrayList<Integer>[] graph) {

        visited[node] = true;

        // 자기 자신 포함하므로 1부터 시작
        int count = 1;

        for (int next : graph[node]) {

            // 아직 방문 안 했으면 DFS 진행
            if (!visited[next]) {

                count += dfs(next, graph);
            }
        }

        return count;
    }
}