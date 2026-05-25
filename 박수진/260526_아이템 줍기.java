import java.util.*;

class Solution {
    static int[][] map = new int[102][102];
    static boolean[][] visited = new boolean[102][102];

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public int solution(int[][] rectangle,
                        int characterX, int characterY,
                        int itemX, int itemY) {

        for (int[] r : rectangle) {
            int x1 = r[0] * 2;
            int y1 = r[1] * 2;
            int x2 = r[2] * 2;
            int y2 = r[3] * 2;

            for (int y = y1; y <= y2; y++) {
                for (int x = x1; x <= x2; x++) {
                    if (x == x1 || x == x2 || y == y1 || y == y2) {
                        if (map[y][x] != 2) {
                            map[y][x] = 1;
                        }
                    } else {
                        map[y][x] = 2;
                    }
                }
            }
        }

        return bfs(characterX * 2, characterY * 2, itemX * 2, itemY * 2) / 2;
    }

    int bfs(int startX, int startY, int itemX, int itemY) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startX, startY, 0});
        visited[startY][startX] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();

            int x = now[0];
            int y = now[1];
            int dist = now[2];

            if (x == itemX && y == itemY) {
                return dist;
            }

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx < 0 || ny < 0 || nx >= 102 || ny >= 102) {
                    continue;
                }

                if (visited[ny][nx]) {
                    continue;
                }

                if (map[ny][nx] != 1) {
                    continue;
                }

                visited[ny][nx] = true;
                q.offer(new int[]{nx, ny, dist + 1});
            }
        }

        return 0;
    }
}