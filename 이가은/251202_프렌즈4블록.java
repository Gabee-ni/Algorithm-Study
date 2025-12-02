import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


class Solution {
    static char[][] map;
	static List<Character>[] colList;

	static int Y; static int X;

	public static int solution(int m, int n, String[] board) {
		int fourBlocksCnt = 0;
		Y = m;
		X = n;
		map = new char[m][n];
		colList = new List[n];

		for (int i = 0; i < n; i++)
			colList[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			char[] str = board[i].toCharArray();
			for (int j = 0; j < n; j++) {
				map[i][j] = str[j];
			}
		}

		do {
			fourBlocksCnt = 0;

			char[][] removeMap = new char[Y][X];
			for (int i = 0; i < m - 1; i++) {
				for (int j = 0; j < n - 1; j++) {
					if (map[i][j] == 'x')
						continue;
					if (find4Blocks(i, j, removeMap))
						fourBlocksCnt++;
				}
			}
			rearrangeBlocks(removeMap);
		} while (fourBlocksCnt > 0);

		return (int)IntStream.range(0, map.length)
		        .flatMap(i -> IntStream.range(0, map[i].length)
		                .filter(j -> map[i][j] == 'x'))
		        .count();
	}

	static boolean find4Blocks(int y, int x, char[][] removeMap) {
		char c = map[y][x];
		int[] dy = { 0, 1, 1 };
		int[] dx = { 1, 0, 1 };

		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			if (c != map[ny][nx])
				return false;
		}

		removeMap[y][x] = 'x';
		for (int i = 0; i < 3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];

			removeMap[ny][nx] = 'x';
		}

		return true;

	}

	static void rearrangeBlocks(char[][] removeMap) {
		for (int y = 0; y < Y; y++) {
			for (int x = 0; x < X; x++) {
				if (removeMap[y][x] != 'x') {
					colList[x].add(map[y][x]);
				}
			}
		}

		for (int y = Y - 1; y >= 0; y--) {
			for (int x = 0; x < X; x++) {
				if (colList[x].size() == 0) {
					map[y][x] = 'x';
					continue;
				}
				map[y][x] = colList[x].get(colList[x].size() - 1);
				colList[x].remove(colList[x].size() - 1);
			}
		}

	}
}