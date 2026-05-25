import java.util.*;

class Solution {

	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int n;

	public int solution(int[][] game_board, int[][] table) {
		n = game_board.length;

		List<List<int[]>> empties = extract(game_board, 0);
		List<List<int[]>> pieces = extract(table, 1);

		boolean[] used = new boolean[pieces.size()];
		int filled = 0;

		for(List<int[]> emp : empties){
			List<int[]> empNorm = normalize(emp);

			for(int i = 0; i < pieces.size(); i++){
				if(used[i]){
					continue;
				}
				List<int[]> cur = pieces.get(i);
				for(int r = 0; r < 4; r++){
					if(sameShape(empNorm, normalize(cur))){
						used[i] = true;
						filled += emp.size();
						break;
					}
					cur = rotate(cur);
				}
				if(used[i]){
					break;
				}
			}
		}

		return filled;
	}

	List<List<int[]>> extract(int[][] grid, int target){
		boolean[][] visited = new boolean[n][n];
		List<List<int[]>> map = new ArrayList<>();

		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				if(!visited[i][j] && grid[i][j] == target){
					Queue<int[]> q = new ArrayDeque<>();
					List<int[]> reg = new ArrayList<>();

					q.offer(new int[]{i, j});
					visited[i][j] = true;

					while(!q.isEmpty()){
						int[] cur = q.poll();
						reg.add(cur);

						for(int d = 0; d < 4; d++){
							int nx = cur[0] + dx[d];
							int ny = cur[1] + dy[d];

							if(nx < 0 || ny < 0 || nx >= n || ny >= n) continue;
							if(!visited[nx][ny] && grid[nx][ny] == target){
								visited[nx][ny] = true;
								q.add(new int[]{nx, ny});
							}
						}
					}

					map.add(reg);
				}
			}
		}

		return map;
	}

	List<int[]> normalize(List<int[]> coords){
		int mx = Integer.MAX_VALUE, my = Integer.MAX_VALUE;
		for(int[] c : coords){
			mx = Math.min(mx, c[0]);
			my = Math.min(my, c[1]);
		}

		List<int[]> out = new ArrayList<>();
		for(int[] c : coords){
			out.add(new int[]{c[0] - mx, c[1] - my});
		}
		out.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

		return out;
	}

	List<int[]> rotate(List<int[]> coords){
		List<int[]> out = new ArrayList<>();
		for(int[] c : coords){
			out.add(new int[]{c[1], -c[0]});
		}
		return out;
	}

	boolean sameShape(List<int[]> a, List<int[]> b){
		if(a.size() != b.size()){
			return false;
		}
		for(int i = 0; i < a.size(); i++){
			if(a.get(i)[0] != b.get(i)[0] || a.get(i)[1] != b.get(i)[1]){
				return false;
			}
		}
		return true;
	}
}