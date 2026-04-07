import java.io.*;
import java.util.*;

public class Main {

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int safeMaxCnt = 1;


        Map<Integer, List<int[]>> hMap = new TreeMap<>();

        for (int y = 0; y < N; y++) {
            st = new StringTokenizer(br.readLine());

            for (int x = 0; x < N; x++) {
                int num = Integer.parseInt(st.nextToken());
                map[y][x] = num;

                hMap.computeIfAbsent(num, k -> new ArrayList<>()).add(new int[]{y, x});
            }
        }

        List<Integer> hKeys = hMap.keySet().stream().collect(Collectors.toList());


        for (int i = 0; i < hKeys.size(); i++) {
            int k = hKeys.get(i);
            boolean[][] visited = new boolean[N][N];
            for (int[] position : hMap.get(k)) {
                int y = position[0], x = position[1];

                map[y][x] = -1;
            }

            int safeCnt = 0;

            for (int j = i + 1; j < hKeys.size(); j++) {
                int r = hKeys.get(j);
                for (int[] position : hMap.get(r)) {
                    int y = position[0], x = position[1];
                    if (visited[y][x]) continue;
                    safeCnt++;
                    visited[y][x] = true;
                    ArrayDeque<int[]> queue = new ArrayDeque<>();
                    queue.add(new int[]{y, x});
                    while (!queue.isEmpty()) {
                        int[] next = queue.pollFirst();
                        int qy = next[0], qx = next[1];
                        bfs(qy, qx, map, visited, queue);
                    }
                }
            }

            safeMaxCnt = Math.max(safeCnt, safeMaxCnt);
        }

        System.out.println(safeMaxCnt);

    }

    static void bfs(int y, int x, int[][] map, boolean[][] visited, ArrayDeque<int[]> queue) {

        int[] dy = {0, 1, 0, -1};
        int[] dx = {1, 0, -1, 0};

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;

            if (map[ny][nx] == -1 || visited[ny][nx]) continue;

            visited[ny][nx] = true;
            queue.add(new int[]{ny, nx});
        }

    }

}