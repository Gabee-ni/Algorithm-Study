import java.util.*;

class Solution {
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> set = new HashSet<>();

        for (int len = 1; len <= n; len++) {
            
            for (int start = 0; start < n; start++) {

                int sum = 0;
                
                for (int k = 0; k < len; k++) {
                    sum += elements[(start + k) % n];
                }

                set.add(sum);
            }
        }

        return set.size();
    }
}