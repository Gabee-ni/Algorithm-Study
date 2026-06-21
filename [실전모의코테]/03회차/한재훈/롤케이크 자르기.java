import java.util.*;

class Solution {
    public int solution(int[] topping) {
        Map<Integer, Integer> right = new HashMap<>();
        for (int t : topping) {
            right.put(t, right.getOrDefault(t, 0) + 1);
        }

        Set<Integer> left = new HashSet<>();
        int answer = 0;

        for (int t : topping) {
            left.add(t);
            right.put(t, right.get(t) - 1);
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

/**
 hashset?
 반복
 오른쪽 토핑 전부 카운트 -> Map
 왼쪽 추가 -> HashSet
 한 칸씩 이동 왼쪽 add 오른쪽 -1 (0이면 remove)
 왼쪽 종류 수 == 오른쪽 종류 수 -> answer++
 **/