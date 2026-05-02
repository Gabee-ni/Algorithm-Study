package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 퇴사 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] T = new int[N + 1];
		int[] P = new int[N + 1];
		int[] dp = new int[N + 2];

		for (int i = 1; i <= N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.parseInt(st.nextToken());
			P[i] = Integer.parseInt(st.nextToken());
		}

		// i보다 큰 인덱스의 dp 값들을 먼저 알고 있어야 dp[i]를 채울 수 있음
		for (int i = N; i >= 1; i--) {
			int end = i + T[i]; // i일부터 시작한 상담이 끝나는 날

			if (end > N + 1) { // 퇴사 이후까지
				dp[i] = dp[i + 1]; // 그냥 넘김
			} else {
				dp[i] = Math.max(dp[i + 1], P[i] + dp[end]);
			}
		}

		System.out.println(dp[1]);
	}
}
