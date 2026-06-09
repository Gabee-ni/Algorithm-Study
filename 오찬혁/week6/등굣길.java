class Solution {
	public int solution(int m, int n, int[][] puddles) {
		int MOD = 1_000_000_007;
		int[][] dp = new int[n + 1][m + 1];

		for(int[] p : puddles){
			dp[p[1]][p[0]] = -1;
		}

		dp[1][1] = 1;

		for(int y = 1; y <= n; y++){
			for(int x = 1; x <= m; x++){
				if(dp[y][x] == -1){
					dp[y][x] = 0;
					continue;
				}
				if(x == 1 && y == 1) continue;
				dp[y][x] = (dp[y - 1][x] + dp[y][x - 1]) % MOD;
			}
		}

		return dp[n][m];
	}
}