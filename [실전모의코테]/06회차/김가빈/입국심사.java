import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        long answer = Integer.MAX_VALUE;
        Arrays.sort(times);

        long start = 0;
        long end = (long)n * times[times.length-1];

        while(start < end){
            long mid = (start + end)/2;
            long total = 0;

            for (int time : times) {
                total += mid / time;
            }

            if(total >= n) {
                end = mid;
            } else if (total < n){
                start = mid+1;
            }

        }

        return start;
    }
}