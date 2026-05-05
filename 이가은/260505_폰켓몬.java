import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        
        for (int n : nums) {
            set.add(n);
        }
        
        int k = nums.length / 2;
        
        int tSize = set.size();
        
        return tSize >= k ? k : tSize; 
    }
}