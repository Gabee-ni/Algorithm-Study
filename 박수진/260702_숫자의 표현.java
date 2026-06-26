class Solution {
    public int solution(int n) {
        int answer = 0;
        
        for (int i = 1; i <= n/2; i++) {
            int now = 0;
            
            for (int j = i; now <= n; j++) {
                now += j;
                
                if (now == n) {
                    answer++;
                }
            }
        }
        
        return answer+1;
    }
}