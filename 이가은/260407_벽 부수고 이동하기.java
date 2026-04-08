import java.io.*;
import java.util.*;

public class Main {
    static int Y, X;
    static int[][] map;
    static boolean[][][] visited;

    static int[] dy = {0, 0, -1, 1};
    static int[] dx = {1, -1, 0, 0};

    static class Node {
        int y;
        int x;
        int broken;
        int dist;

        Node(int y, int x, int broken, int dist) {
            this.y = y;
            this.x = x;
            this.broken = broken;
            this.dist = dist;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Y = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        map = new int[Y][X];
        visited = new boolean[Y][X][2];

        for (int i = 0; i < Y; i++) {
            String line = br.readLine();
            for (int j = 0; j < X; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(bfs());

    }

    static int bfs() {
        Queue<Node> q = new ArrayDeque<>();
        visited[0][0][0] = true;
        q.offer(new Node(0, 0, 0, 1));


        while (!q.isEmpty()) {
            Node cur = q.poll();

            if (cur.x == X-1 && cur.y == Y-1) {
                return cur.dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];

                if (nx < 0 || ny < 0 || nx >= X || ny >= Y) continue;

                if (map[ny][nx] == 0 && !visited[ny][nx][cur.broken]) {
                    visited[ny][nx][cur.broken] = true;
                    q.offer(new Node(ny, nx, cur.broken, cur.dist + 1));
                }

                if (map[ny][nx] == 1 && cur.broken == 0 && !visited[ny][nx][1]) {
                    visited[ny][nx][1] = true;
                    q.offer(new Node(ny, nx, 1, cur.dist + 1));
                }
            }


        }

        return -1;
    }
}