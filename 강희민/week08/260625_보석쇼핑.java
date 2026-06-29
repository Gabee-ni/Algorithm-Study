import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];

        Set<String> gemSet = new HashSet<>();
        for (String gem : gems) {
            gemSet.add(gem);
        }

        int totalKinds = gemSet.size();

        Map<String, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;

        while (right < gems.length) {
            // 오른쪽 포인터의 보석을 구간에 추가
            map.put(gems[right], map.getOrDefault(gems[right], 0) + 1);
            right++;

            // 현재 구간이 모든 보석 종류를 포함하면 left를 줄여봄
            while (map.size() == totalKinds) {
                if (right - left < minLength) {
                    minLength = right - left;
                    start = left;
                    end = right - 1;
                }

                // left 위치의 보석을 구간에서 제거
                map.put(gems[left], map.get(gems[left]) - 1);

                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }

                left++;
            }
        }

        answer[0] = start + 1;
        answer[1] = end + 1;

        return answer;
    }
}