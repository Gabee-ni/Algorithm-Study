import java.util.*;

class Solution {
    public int solution(int[] nums) {
        
        HashSet<Integer> num = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++) {
            num.add(nums[i]);
        }
        
        int m = nums.length / 2;
        
        if (num.size() >= m) {
            return m;
        } else {
            return num.size();
        }
    }
}