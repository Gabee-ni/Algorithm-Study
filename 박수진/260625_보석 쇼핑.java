import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        Set<String> kinds = new HashSet<>(Arrays.asList(gems));
        int totalKinds = kinds.size();
        
        Map<String, Integer> window = new HashMap<>();

        int left = 0;

        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        
        for (int right = 0; right < gems.length; right++) {

            window.put(
                gems[right],
                window.getOrDefault(gems[right], 0) + 1
            );

            while (window.size() == totalKinds) {

                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                    end = right;
                }

                window.put(gems[left], window.get(gems[left]) - 1);

                if (window.get(gems[left]) == 0) {
                    window.remove(gems[left]);
                }

                left++;
            }
        }

        return new int[]{start + 1, end + 1};
    }
}