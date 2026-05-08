import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        
        for (int i = 0; i < n; i++) {
            if (n - i <= citations[i]) {
                return n - i;
            }
        }
        
        return 0;
    }
}