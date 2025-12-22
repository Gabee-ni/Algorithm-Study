
package algorithm.boj.ex3079;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static boolean can(long T, long[] tk, long M) {
		long processed = 0;
		for (long time : tk) {
			processed += T / time;
			if (processed >= M)
				return true; // 조기 종료(시간 절약 + 오버플로 방지)
		}
		return false;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long M = Long.parseLong(st.nextToken());

		long[] tk = new long[N];
		long minTk = Long.MAX_VALUE;

		for (int i = 0; i < N; i++) {
			tk[i] = Long.parseLong(br.readLine().trim());
			if (tk[i] < minTk)
				minTk = tk[i];
		}

		long left = 0;
		long right = minTk * M; // 최악: 가장 빠른 심사대 1개가 M명 처리
		long answer = right;

		while (left <= right) {
			long mid = left + (right - left) / 2;

			if (can(mid, tk, M)) {
				answer = mid;
				right = mid - 1; // 더 작은 시간 가능한지
			} else {
				left = mid + 1; // 더 큰 시간 필요
			}
		}

		System.out.println(answer);
	}
}