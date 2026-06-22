import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        int left = 0;
        int right = people.length - 1;
        
        int cnt = 0;
        
        while (left <= right) {
            
            int sum = people[left] + people[right];
            
            if (sum <= limit) {
                cnt++;
                left++;
                right--;
            } else if (sum > limit) {
                cnt++;
                right--;
            }
        }
        
        return cnt;
    }
}