import java.util.*;

class Solution {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long low = 1;
        long high = (long) times[times.length - 1] * n;

        while (low < high) {
            long mid = (low + high) / 2;
            long people = 0;
            for (int t : times) {
                people += mid / t;
            }
            if (people >= n) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}

/**
 low=1, high=가장 오래 걸리는 심사관 * n
 mid분 사람 = 각 심사관 mid/t 합산
 people >= n -> 시간 줄임 (high = mid)
 people < n  -> 시간 늘림 (low = mid+1)
 low == high 로 수렴한 값 = 최소 시간
 **/