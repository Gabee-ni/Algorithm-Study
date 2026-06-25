import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>(Arrays.asList(gems));
        int totalKinds = set.size();

        Map<String, Integer> map = new HashMap<>();

        int left = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < gems.length; right++) {
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);

            while (map.size() == totalKinds) {
                int len = right - left + 1;

                if (len < minLen) {
                    minLen = len;
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }

                String leftGem = gems[left];
                map.put(leftGem, map.get(leftGem) - 1);

                if (map.get(leftGem) == 0) {
                    map.remove(leftGem);
                }

                left++;
            }
        }

        return answer;
    }
}