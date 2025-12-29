import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());
				
				// 노드와 직접 연결된 모든 노드 목록
        List<Integer>[] g = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
	        g[i] = new ArrayList<>();
	      }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            g[a].add(b); // 간선 입력 처리
            g[b].add(a);
        }

        int[] parent = new int[N + 1]; // 부모 노드
        boolean[] visited = new boolean[N + 1]; // 이미 방문한 노드인지 확인

        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.add(1); // 탐색 시작점은 루트(1)
        visited[1] = true;
        parent[1] = 0; // 루트는 부모 없음
				
				// BFS 탐색 과정
        while (!q.isEmpty()) {
				    int cur = q.poll(); // 현재 노드 꺼내기
				
				    for (int nxt : g[cur]) { // 연결된 모든 이웃 탐색
				        if (visited[nxt]) {
					        continue; // 이미 방문했으면 건너뜀
								}
				        visited[nxt] = true; // 처음 방문한 노드라면
				        parent[nxt] = cur; // 부모 기록
				        q.add(nxt); // 다음 탐색 대상으로 큐에 추가
				    }
				}

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            sb.append(parent[i]).append('\n');
        }
        System.out.print(sb);
    }
}
