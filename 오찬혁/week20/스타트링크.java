import java.io.*;
import java.util.*;

public class Main{

	static int F, S, G, U, D;

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());

		bfs();
	}

	static void bfs(){
		Queue<Integer> q = new LinkedList<>();
		int[] dist = new int[F + 1];

		Arrays.fill(dist, -1);
		q.add(S);
		dist[S] = 0;

		while(!q.isEmpty()){
			int cur = q.poll();

			if(cur == G){
				System.out.println(dist[G]);
				return;
			}

			int[] next = new int[]{cur + U, cur - D};
			for(int nxt : next){
				if(nxt < 1 || nxt > F || dist[nxt] != -1) continue;
				dist[nxt] = dist[cur] + 1;
				q.add(nxt);
			}
		}

		System.out.println("use the stairs");
	}
}