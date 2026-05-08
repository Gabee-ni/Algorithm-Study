import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int x, y, broken, dist;

        Node(int x, int y, int broken, int dist) {
            this.x = x;
            this.y = y;
            this.broken = broken;
            this.dist = dist;
        }
    }

    static int N, M;
    static int[][] map;
    static boolean[][][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int bfs() {
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(0, 0, 0, 1));
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();

            if (cur.x == N - 1 && cur.y == M - 1) {
                return cur.dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = cur.x + dx[d];
                int ny = cur.y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

                // 다음 칸이 빈 칸인 경우
                if (map[nx][ny] == 0 && !visited[nx][ny][cur.broken]) {
                    visited[nx][ny][cur.broken] = true;
                    queue.offer(new Node(nx, ny, cur.broken, cur.dist + 1));
                }

                // 다음 칸이 벽이고, 아직 벽을 안 부쉈다면
                if (map[nx][ny] == 1 && cur.broken == 0 && !visited[nx][ny][1]) {
                    visited[nx][ny][1] = true;
                    queue.offer(new Node(nx, ny, 1, cur.dist + 1));
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new boolean[N][M][2];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }
}