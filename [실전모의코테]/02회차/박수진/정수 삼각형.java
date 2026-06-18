class Solution {
    public int solution(int[][] triangle) {
        int height = triangle.length;
        
        for (int n = 1; n < height; n++) {
            for (int i = 0; i <= n; i++) {
                if (i == 0) { // 가장 좌측
                    triangle[n][0] += triangle[n-1][0];
                } else if (i == n) { // 가장 우측
                    triangle[n][n] += triangle[n-1][n-1];
                } else {
                    triangle[n][i] += Math.max(triangle[n-1][i-1], triangle[n-1][i]);
                }
            }
        }
        
        int answer = 0;
        for (int i = 0; i < height; i++) {
            answer = Math.max(answer, triangle[height-1][i]);
        }
        return answer;
    }
}