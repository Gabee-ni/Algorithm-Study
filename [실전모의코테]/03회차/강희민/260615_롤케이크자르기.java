import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;

        Set<Integer> left = new HashSet<>();
        Map<Integer, Integer> right = new HashMap<>();

        // 오른쪽에 종류별 개수 전부 저장
        for (int t : topping) {
            right.put(t, right.getOrDefault(t, 0) + 1);
        }

        for (int i = 0; i < topping.length - 1; i++) {
            int t = topping[i];

            left.add(t); // 왼쪽에 하나씩 추가

            right.put(t, right.get(t) - 1); // 해당 종류의 토핑 개수 줄이기
            if (right.get(t) == 0) {
                right.remove(t);
            }

            if (left.size() == right.size()) {
                answer++;
            }
        }

        return answer;
    }
}