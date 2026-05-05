import java.util.*;
import java.io.*;

class Main {
    static int[] move;
    static int[] dir = new int[2];
    static int f,s,g;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        f = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        g = Integer.parseInt(st.nextToken());

        dir[0] = Integer.parseInt(st.nextToken());
        dir[1] = -Integer.parseInt(st.nextToken());

        move = new int[f+1];

        bfs(s);

    }

    static void bfs(int start){
        Queue<Integer> q = new ArrayDeque<>();
        boolean[] checkList = new boolean[f+1];

        q.add(start);
        checkList[start] = true;
        move[start] = 0;

        while(!q.isEmpty()) {
            int pos = q.poll();

            if(pos == g) {
                System.out.println(move[pos]);
                return;
            }

            for (int d=0; d<2; d++){
                int next = pos + dir[d];

                if(next > f || next < 1) continue;
                if (!checkList[next]) {
                    checkList[next] = true;
                    move[next] = move[pos]+1;
                    q.add(next);
                }


            }
        }
        System.out.println("use the stairs");
    }
}