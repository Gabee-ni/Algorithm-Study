import java.util.*;
import java.io.*;

class Main{
    static class Pos{
        int i,j;
        Pos(int i, int j){
            this.i = i;
            this.j = j;

        }
    }
    static int distance (Pos a, Pos b){
        return Math.abs(a.i - b.i) + Math.abs(a.j - b.j);
    }

    static String bfs(Pos home, Pos[] stores, Pos festival) {
        Queue<Pos> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[stores.length];

        queue.offer(home);

        while (!queue.isEmpty()) {
            Pos cur = queue.poll();

            if (distance(cur, festival) <= 1000) {
                return "happy";
            }

            for (int i = 0; i < stores.length; i++) {
                if (!visited[i] && distance(cur, stores[i]) <= 1000) {
                    visited[i] = true;
                    queue.offer(stores[i]);
                }
            }
        }

        return "sad";
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());

            Pos home = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            Pos[] stores = new Pos[n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                stores[i] = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            st = new StringTokenizer(br.readLine());
            Pos festival = new Pos(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));

            sb.append(bfs(home, stores, festival)).append("\n");
        }
        System.out.println(sb);
    }
}