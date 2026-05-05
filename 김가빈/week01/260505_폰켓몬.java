import java.util.*;
class Solution {
    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
            set.add(num);
        }
        int answer = 0;

        if (set.size() >= nums.length/2) answer = nums.length/2;
        else answer = set.size();

        return answer;
    }
}