import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        HashSet<String> type = new HashSet<>();
        Map<String, Integer> count = new HashMap<>();
        for (String g : gems) {
            type.add(g);
        }
        
        int types = type.size();
        int min = Integer.MAX_VALUE;
        int minLeft = 0;
        int minRight = 0;
        int right = 0;
        int left = 0;
        
        while (right < gems.length) {

            // 오른쪽 추가
            count.put(gems[right], count.getOrDefault(gems[right], 0) + 1);
            right++;

            // 모든 종류 포함?
            while (count.size() == types) {

                if (right - left < min) {
                    min = right - left;
                    minLeft = left;
                    minRight = right;
                }
                
                count.put(gems[left], count.get(gems[left]) - 1);

                if (count.get(gems[left]) == 0) {
                    count.remove(gems[left]);
                }

                left++;
            }
        }
        
        return new int[] {minLeft + 1, minRight};
    }
}