import java.util.*;

class Solution {

	static int[] dy = {1, -1, 0, 0};
	static int[] dx = {0, 0, 1, -1};

	public int solution(int[][] maps) {
		int answer = 0;
		int n = maps.length;
		int m = maps[0].length;

		int[][] dist = new int[n][m];
		Queue<int[]> q = new LinkedList<>();

		dist[0][0] = 1;
		q.offer(new int[]{0, 0});

		// bfs
		while(!q.isEmpty()){
			int[] cur = q.poll();
			int y = cur[0];
			int x = cur[1];

			for(int dir = 0; dir < 4; dir++){
				int ny = y + dy[dir];
				int nx = x + dx[dir];

				if(ny < 0 || nx < 0 || ny >= n || nx >= m) {
					continue;
				}
				if(maps[ny][nx] == 0){
					continue;
				}
				if(dist[ny][nx] != 0){
					continue;
				}

				dist[ny][nx] = dist[y][x] + 1;
				q.offer(new int[]{ny, nx});
			}
		}

		answer = dist[n - 1][m - 1];

		return answer == 0 ? -1 : answer;
	}
}