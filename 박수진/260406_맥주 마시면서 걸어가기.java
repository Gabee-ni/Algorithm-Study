import java.util.*;
import java.io.*;

public class Main {
    static int[] dr = {-1, 1, 0, 0};
    static int[] dc = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        // visited[r][c][k]: k=0 벽 안 부숨, k=1 벽 부숨
        boolean[][][] visited = new boolean[N][M][2];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 1}); // {r, c, 벽사용여부, 거리}
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1], k = cur[2], dist = cur[3];

            if (r == N - 1 && c == M - 1) {
                System.out.println(dist);
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nr = r + dr[d];
                int nc = c + dc[d];
                if (nr < 0 || nr >= N || nc < 0 || nc >= M) continue;

                if (map[nr][nc] == 0 && !visited[nr][nc][k]) {
                    // 빈 칸: 벽 사용 여부 그대로
                    visited[nr][nc][k] = true;
                    queue.add(new int[]{nr, nc, k, dist + 1});
                } else if (map[nr][nc] == 1 && k == 0 && !visited[nr][nc][1]) {
                    // 벽 칸: 벽을 아직 안 부쉈을 때만 부수기
                    visited[nr][nc][1] = true;
                    queue.add(new int[]{nr, nc, 1, dist + 1});
                }
            }
        }

        System.out.println(-1);
    }
}