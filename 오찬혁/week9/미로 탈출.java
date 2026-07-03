import java.util.*;

class Solution {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static char[][] grid;
	static int xlen, ylen;
	static int sx, sy, lx, ly;

	public int solution(String[] maps) {
		int answer = 0;
		xlen = maps.length;
		ylen = maps[0].length();
		grid = new char[xlen][ylen];

		for(int i = 0; i < xlen; i++){
			for(int j = 0; j < ylen; j++){
				char ch = maps[i].charAt(j);
				grid[i][j] = ch;
				if(ch == 'S'){
					sx = i;
					sy = j;
				} else if(ch == 'L'){
					lx = i;
					ly = j;
				}
			}
		}
		int LDist = bfs(sx, sy, 'L');
		if(LDist == -1){
			return -1;
		}
		answer += LDist;

		int EDist = bfs(lx, ly, 'E');
		if(EDist == -1){
			return -1;
		}

		return answer += EDist;
	}

	static int bfs(int start, int dest, char target){
		Queue<int[]> q = new LinkedList<>();
		int[][] dist = new int[xlen][ylen];

		for(int i = 0; i < xlen; i++){
			Arrays.fill(dist[i], -1);
		}
		q.offer(new int[]{start, dest});
		dist[start][dest] = 0;

		while(!q.isEmpty()){
			int[] cur = q.poll();
			int x = cur[0], y = cur[1];

			for(int d = 0; d < 4; d++){
				int nx = x + dx[d];
				int ny = y + dy[d];

				if(nx < 0 || ny < 0 || nx >= xlen || ny >= ylen) continue;
				if(grid[nx][ny] == 'X') continue;

				if(dist[nx][ny] == -1){
					q.offer(new int[]{nx, ny});
					dist[nx][ny] = dist[x][y] + 1;
					if(grid[nx][ny] == target){
						return dist[nx][ny];
					}
				}
			}
		}

		return -1;
	}
}