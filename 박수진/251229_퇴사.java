import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine().trim());

        int[] T = new int[N + 1];
        int[] P = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            T[i] = Integer.parseInt(st.nextToken());
            P[i] = Integer.parseInt(st.nextToken());
        }

        // dp[i] = i일 시작 시점까지(= i일에 도착했을 때) 얻을 수 있는 최대 이익
        long[] dp = new long[N + 2]; // dp[N+1]까지 사용

        for (int i = 1; i <= N; i++) {
            // 1) 오늘 상담을 안 하고 내일로 넘어가기
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);

            // 2) 오늘 상담을 하는 경우: 끝나는 날(next)로 점프
            int next = i + T[i];
            if (next <= N + 1) {
                dp[next] = Math.max(dp[next], dp[i] + P[i]);
            }
        }

        System.out.println(dp[N + 1]);
    }
}
