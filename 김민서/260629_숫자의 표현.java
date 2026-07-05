class Solution {
    public int solution(int n) {
        int cnt = 0;
        
        for (int i = 1; i < n; i++) {
             cnt += dfs(i, 0, n); 
        }
        
        return cnt + 1;
    }
    
    int dfs(int i, int sum, int n) {
        if (sum > n) {
            return 0;
        }
        
        if (sum == n) {
            return 1;
        }
        
        return dfs(i + 1, sum + i, n);
    }
}