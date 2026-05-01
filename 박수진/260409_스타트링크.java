import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int F = sc.nextInt(); // 최고 층
        int S = sc.nextInt(); // 시작 층
        int G = sc.nextInt(); // 목표 층
        int U = sc.nextInt(); // 위로 U층
        int D = sc.nextInt(); // 아래로 D층

        int[] dist = new int[F + 1];
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        dist[S] = 0;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == G) {
                System.out.println(dist[G]);
                return;
            }

            // U버튼: 위로 U층
            int up = cur + U;
            if (up <= F && dist[up] == -1) {
                dist[up] = dist[cur] + 1;
                queue.offer(up);
            }

            // D버튼: 아래로 D층
            int down = cur - D;
            if (down >= 1 && dist[down] == -1) {
                dist[down] = dist[cur] + 1;
                queue.offer(down);
            }
        }

        System.out.println("use the stairs");
    }
}