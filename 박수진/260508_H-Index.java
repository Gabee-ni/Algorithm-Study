import java.util.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        
        int size = citations.length;
        int left = 0;
        int right = citations[size - 1];
        
        int answer = 0;
        
        while (left <= right) {
            int mid = (left + right) / 2;
            int cnt = 0;
            
            for (int c : citations) {
                if (c >= mid) {
                    cnt++;
                }
            }
            
            if (cnt >= mid) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
}