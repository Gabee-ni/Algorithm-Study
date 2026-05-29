import java.util.*;

class Solution {

	int[] dx = {-1, 1, 0, 0};
	int[] dy = {0, 0, -1, 1};
	int n, m;

	public int solution(int[][] maps) {
		n = maps.length;
		m = maps[0].length;

		return bfs(maps);
	}

	int bfs(int[][] maps){
		Queue<int[]> q = new LinkedList<>();
		int[][] dist = new int[n][m];
		q.offer(new int[]{0, 0});
		dist[0][0] = 1;

		while(!q.isEmpty()){
			int[] cur = q.poll();
			int x = cur[0];
			int y = cur[1];

			for(int d = 0; d < 4; d++){
				int nx = x + dx[d];
				int ny = y + dy[d];

				if(nx < 0 || nx >= n || ny < 0 || ny >= m){
					continue;
				}
				if(maps[nx][ny] == 0){
					continue;
				}
				if(dist[nx][ny] != 0){
					continue;
				}

				dist[nx][ny] = dist[x][y] + 1;
				q.offer(new int[]{nx, ny});
			}
		}

		if(dist[n - 1][m - 1] == 0){
			return -1;
		}

		return dist[n - 1][m - 1];
	}
}