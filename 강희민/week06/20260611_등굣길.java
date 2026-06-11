import java.util.*;

class Solution {
    public int solution(int m, int n, int[][] puddles) {
        int MOD = 1_000_000_007;

        int[][] dp = new int[n + 1][m + 1];
        boolean[][] blocked = new boolean[n + 1][m + 1];

        // puddles는 [x, y] 형태로 들어옴
        for (int[] puddle : puddles) {
            int x = puddle[0];
            int y = puddle[1];
            blocked[y][x] = true;
        }

        dp[1][1] = 1;

        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {

                // 시작점은 이미 1로 설정했으므로 넘어감
                if (x == 1 && y == 1) {
                    continue;
                }

                // 물웅덩이면 경로 수 0
                if (blocked[y][x]) {
                    dp[y][x] = 0;
                    continue;
                }

                dp[y][x] = (dp[y - 1][x] + dp[y][x - 1]) % MOD;
            }
        }

        return dp[n][m];
    }
}