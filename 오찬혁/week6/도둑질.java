class Solution {

	static int n;

	public int solution(int[] money) {
		n = money.length;

		int caseA = rob(money, 0, n - 2);
		int caseB = rob(money, 1, n - 1);

		return Math.max(caseA, caseB);
	}

	static int rob(int[] money, int start, int end){
		int[] dp = new int[n];
		dp[start] = money[start];
		dp[start + 1] = Math.max(money[start], money[start + 1]);

		for(int i = start + 2; i <= end; i++){
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + money[i]);
		}

		return dp[end];
	}
}