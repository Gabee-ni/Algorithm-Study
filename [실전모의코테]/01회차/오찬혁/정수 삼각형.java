class Solution {
	public int solution(int[][] triangle) {
		int len = triangle.length;
		int[][] dp = new int[len][len];

		dp[0][0] = triangle[0][0];

		for(int i = 1; i < len; i++){
			for(int j = 0; j <= i; j++){

				if(j == 0){ // 왼쪽없는 경우
					dp[i][j] = dp[i - 1][0] + triangle[i][j];

				} else if(j == triangle[i].length - 1){ // 오른쪽 없는 경우
					dp[i][j] = dp[i - 1][triangle[i - 1].length - 1] + triangle[i][j];

				} else { // 중간위치
					dp[i][j] = Math.max(dp[i - 1][j - 1] + triangle[i][j], dp[i - 1][j] + triangle[i][j]);
				}
			}
		}

		int max = 0;
		for(int d : dp[len - 1]){
			max = Math.max(d, max);
		}

		return max;
	}
}
/**

 7 -> 10, 15

 (0, 0)
 (1, 0) (1, 1)
 (2, 0)  (2, 1)  (2, 2)
 (3, 0)  (3, 1)  (3, 2)  (3, 3)
 **/