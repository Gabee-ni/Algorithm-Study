import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int[][] points = new int[n + 2][2]; // 0: 집, 1~n: 편의점, n+1: 페스티벌

            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                points[i][0] = Integer.parseInt(st.nextToken());
                points[i][1] = Integer.parseInt(st.nextToken());
            }

            // BFS
            boolean[] visited = new boolean[n + 2];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            visited[0] = true;

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next = 1; next < n + 2; next++) {
                    if (!visited[next]) {
                        int dist = Math.abs(points[cur][0] - points[next][0])
                                 + Math.abs(points[cur][1] - points[next][1]);
                        if (dist <= 1000) {
                            visited[next] = true;
                            queue.add(next);
                        }
                    }
                }
            }

            sb.append(visited[n + 1] ? "happy" : "sad").append("\n");
        }

        System.out.print(sb);
    }
}