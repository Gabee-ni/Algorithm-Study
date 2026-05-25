import java.util.*;

class Solution {
    int n;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int solution(int[][] game_board, int[][] table) {
        n = game_board.length;

        List<List<int[]>> blanks = new ArrayList<>();
        List<List<int[]>> blocks = new ArrayList<>();

        boolean[][] visitedBoard = new boolean[n][n];
        boolean[][] visitedTable = new boolean[n][n];

        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (!visitedBoard[y][x] && game_board[y][x] == 0) {
                    blanks.add(bfs(game_board, visitedBoard, y, x, 0));
                }

                if (!visitedTable[y][x] && table[y][x] == 1) {
                    blocks.add(bfs(table, visitedTable, y, x, 1));
                }
            }
        }

        boolean[] used = new boolean[blocks.size()];
        int answer = 0;

        for (List<int[]> blank : blanks) {
            for (int i = 0; i < blocks.size(); i++) {
                if (used[i]) continue;

                if (isSame(blank, blocks.get(i))) {
                    used[i] = true;
                    answer += blank.size();
                    break;
                }
            }
        }

        return answer;
    }

    List<int[]> bfs(int[][] board, boolean[][] visited, int sy, int sx, int target) {
        Queue<int[]> q = new LinkedList<>();
        List<int[]> list = new ArrayList<>();

        q.offer(new int[]{sy, sx});
        visited[sy][sx] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int y = now[0];
            int x = now[1];

            list.add(new int[]{y, x});

            for (int i = 0; i < 4; i++) {
                int ny = y + dy[i];
                int nx = x + dx[i];

                if (ny < 0 || nx < 0 || ny >= n || nx >= n) continue;
                if (visited[ny][nx]) continue;
                if (board[ny][nx] != target) continue;

                visited[ny][nx] = true;
                q.offer(new int[]{ny, nx});
            }
        }

        return normalize(list);
    }

    List<int[]> normalize(List<int[]> shape) {
        shape.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int minY = shape.get(0)[0];
        int minX = Integer.MAX_VALUE;

        for (int[] p : shape) {
            minX = Math.min(minX, p[1]);
        }

        List<int[]> result = new ArrayList<>();

        for (int[] p : shape) {
            result.add(new int[]{p[0] - minY, p[1] - minX});
        }

        result.sort((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        return result;
    }

    boolean isSame(List<int[]> blank, List<int[]> block) {
        if (blank.size() != block.size()) return false;

        List<int[]> rotated = block;

        for (int r = 0; r < 4; r++) {
            rotated = rotate(rotated);

            if (equals(blank, rotated)) {
                return true;
            }
        }

        return false;
    }

    List<int[]> rotate(List<int[]> shape) {
        List<int[]> result = new ArrayList<>();

        for (int[] p : shape) {
            int y = p[0];
            int x = p[1];

            result.add(new int[]{x, -y});
        }

        return normalize(result);
    }

    boolean equals(List<int[]> a, List<int[]> b) {
        for (int i = 0; i < a.size(); i++) {
            if (a.get(i)[0] != b.get(i)[0]) return false;
            if (a.get(i)[1] != b.get(i)[1]) return false;
        }

        return true;
    }
}