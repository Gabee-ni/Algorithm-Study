package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class N_Queen {

	static int N;
	static int[] col;
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		col = new int[N];

		dfs(0);
		System.out.println(cnt);
	}

	static void dfs(int row) {
		if (row == N) {
			cnt++;
			System.out.println("성공 배치: " + Arrays.toString(col));
			return;
		}

		for (int i = 0; i < N; i++) {
			col[row] = i;
			if (isPossible(row)) {
				System.out.printf("row=%d, col=%d로 두고 다음 행으로%n", row, i);
				dfs(row + 1);
			}
		}
	}

	static boolean isPossible(int row) {
		for (int i = 0; i < row; i++) {
			// 열 비교
			if (col[row] == col[i]) {
				return false;
			}

			// 대각선 비교 (두 칸의 행 차이와 열 차이가 같으면 대각선)
			if (Math.abs(row - i) == Math.abs(col[row] - col[i])) {
				return false;
			}
		}
		return true;
	}
}
