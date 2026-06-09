class Solution {
    static final int MOD = 1000000007;

    public int solution(int m, int n, int[][] puddles) {
        
        long[][] dp = new long[n+1][m+1];
        boolean[][] puddle = new boolean[n+1][m+1];
        
        for (int[] p : puddles) {
            puddle[p[1]][p[0]] = true;
        }
        
        dp[1][1] = 1;
        
        for (int y = 1; y <= n; y++) {
            for (int x = 1; x <= m; x++) {
                
                if (x == 1 && y == 1) {
                    continue;
                }
                
                if (puddle[y][x]) {
                    dp[y][x] = 0;
                    continue;
                }
                
                dp[y][x] = (dp[y-1][x] + dp[y][x-1]) % MOD;
            }
        }
        
        return (int)dp[n][m];
    }
}