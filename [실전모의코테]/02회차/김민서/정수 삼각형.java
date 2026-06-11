class Solution {
    public int solution(int[][] triangle) {
        int[][] dp = new int[triangle.length][];
        
        for (int i = triangle.length - 1; i > 0; i--) {
            dp[i] = new int[triangle[i].length - 1];
            
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = Math.max(triangle[i][j], triangle[i][j + 1]);
                triangle[i - 1][j] += dp[i][j];
            }
            
        }
        
        return triangle[0][0];
    }
}