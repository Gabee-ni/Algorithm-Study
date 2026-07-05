import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        
        Arrays.sort(times);
        
        long start = 1;
        long end = (long)(times[times.length - 1]) * n;
        long answer = 0;
        
        while (start < end) {
            long mid = (start + end) / 2;
            long sum = 0;
            
            for (long t : times) {
                sum += mid / t;
            }
            
            if (sum >= n) {
                answer = mid;
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        
        return answer;
    }
}