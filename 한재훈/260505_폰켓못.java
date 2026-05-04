import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> pon = new HashSet<>();

        for (int n : nums) {
            pon.add(n);
        }

        int pick = nums.length/2;

        int type = pon.size();

        return Math.min(pick, type);
    }
}

/** 최대한 많은 종류 = 중복 제거 -> HashSet
    전체 개수 / 2 와 종류 중 작은 값
**/