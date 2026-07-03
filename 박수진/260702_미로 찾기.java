import java.util.*;

class Solution {
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(String[] maps) {
        int n = maps.length;
        int m = maps[0].length();

        int[] start = new int[2];
        int[] lever = new int[2];
        int[] end = new int[2];

        // S, L, E 위치 찾기
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < m; j++) {
                char c = maps[i].charAt(j);

                if (c == 'S') {
                    start[0] = i;
                    start[1] = j;

                } else if (c == 'L') {
                    lever[0] = i;
                    lever[1] = j;

                } else if (c == 'E') {
                    end[0] = i;
                    end[1] = j;
                }
            }
        }

        int dist1 = bfs(maps, start, lever);
        if (dist1 == -1) return -1;

        int dist2 = bfs(maps, lever, end);
        if (dist2 == -1) return -1;

        return dist1 + dist2;
    }

    private int bfs(String[] maps, int[] start, int[] target) {
        int n = maps.length;
        int m = maps[0].length();

        boolean[][] visited = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[]{start[0], start[1], 0});

        visited[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0];
            int y = cur[1];
            int dist = cur[2];

            if (x == target[0] && y == target[1]) {
                return dist;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m)
                    continue;

                if (visited[nx][ny])
                    continue;

                if (maps[nx].charAt(ny) == 'X')
                    continue;

                visited[nx][ny] = true;
                q.offer(new int[]{nx, ny, dist + 1});
            }
        }
        return -1;
    }
}