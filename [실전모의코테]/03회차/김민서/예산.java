import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int sum = 0;
        int idx = 0;
        
        while (sum < budget && idx < d.length) {
            sum += d[idx];
            
            if (sum > budget) {
                return idx;
            }
            idx++;
        }
        
        return idx;
    }
}