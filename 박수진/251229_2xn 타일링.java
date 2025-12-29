class Solution {
    public int solution(int n) {
        final int MOD = 1_000_000_007;

        if (n == 1) return 1;
        if (n == 2) return 2;

        long a = 1; // dp[1]
        long b = 2; // dp[2]

        for (int i = 3; i <= n; i++) {
            long c = (a + b) % MOD; // dp[i] = dp[i-2] + dp[i-1]
            a = b;
            b = c;
        }

        return (int) b;
    }
}
