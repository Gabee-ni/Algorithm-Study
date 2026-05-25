class Solution {
    
    static int targ;
    static int[] nums;
    static int cnt = 0;
    public int solution(int[] numbers, int target) {
        
        nums = numbers.clone();
        targ = target;
        
        int sum = 0;
        int dept = 0;
        
        dfs(dept, sum);
        
        return cnt;
        
    }
    
    static void dfs(int dept, int sum) {
        
        if (dept == nums.length) {
            if (sum == targ) {
                cnt++;
            }
            return;
        }
        
        for(int i = 0; i < 2; i++) {
            if (i == 0) {
                sum += nums[dept];
                dfs(dept + 1, sum);
                sum -= nums[dept];
            } else if (i == 1) {
                sum -= nums[dept];
                dfs(dept + 1, sum);
                sum += nums[dept];
            }
        }
    }
}