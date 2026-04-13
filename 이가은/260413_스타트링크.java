import java.io.*;
import java.util.*;

public class Main {

    static int F, S, G;
    static int[] move = new int[2];
    static ArrayDeque<int[]> queue = new ArrayDeque<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        move[0] = Integer.parseInt(st.nextToken());
        move[1] = Integer.parseInt(st.nextToken()) * -1;

        visited = new boolean[F + 1];

        queue.addLast(new int[] {S, 0});
        visited[S] = true;

        bfs();
    }

    static void bfs() {
        while (!queue.isEmpty()) {
            int[] arr = queue.pollFirst();
            int current = arr[0];
            int cnt = arr[1];

            if (current == G) {
                System.out.println(cnt);
                return;
            }

            for (int m : move) {
                int next = current + m;

                if (next < 1 || next > F) {
                    continue;
                }

                if (visited[next]) {
                    continue;
                }

                visited[next] = true;
                queue.addLast(new int[] {next, cnt + 1});
            }
        }

        System.out.println("use the stairs");
    }
}