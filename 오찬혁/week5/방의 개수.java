import java.util.*;

class Solution {

	static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
	static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

	public int solution(int[] arrows) {
		Set<String> dots = new HashSet<>();
		Set<String> lines = new HashSet<>();
		int x = 0, y = 0, rooms = 0;

		dots.add(x + "," + y);

		for(int dir : arrows){
			for(int i = 0; i < 2; i++){
				int nx = x + dx[dir], ny = y + dy[dir];
				String from = x + "," + y, to = nx + "," + ny;

				String line = from.compareTo(to) < 0 ? from + "_" + to : to + "_" + from;

				if(dots.contains(to) && !lines.contains(line)){
					rooms++;
				}
				dots.add(to);
				lines.add(line);
				x = nx;
				y = ny;
			}
		}

		return rooms;
	}
}