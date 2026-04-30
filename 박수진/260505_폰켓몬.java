import java.util.*;

class Solution {
    public int solution(int[] nums) {
        int size = nums.length / 2;
        
        Map<Integer, Integer> monBox = new HashMap<>();
        for (int n : nums) {
            monBox.put(n, monBox.getOrDefault(n, 0) + 1);
        }
        
        Set<Integer> keySet = monBox.keySet();
        if (keySet.size() >= size) {
            return size;
        } else {
            return keySet.size();
        }
    }
}