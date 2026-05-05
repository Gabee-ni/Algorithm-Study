import java.util.*;

class Solution {
    public int solution(int[] topping) {
        int cnt = 0;

        Set<Integer> left = new HashSet<>();
        Map<Integer, Integer> right = new HashMap<>();

        // 오른쪽 전체 빈도수 세팅 -> 오른쪽으로 이동하면서 set에 더해줄때 map에서 빼서 더해줌.
        for (int t : topping) { //-> 초기에 오른쪽에 남아 있는 토핑 종류 + 개수
            right.put(t, right.getOrDefault(t, 0) + 1);
        }

        for (int i = 0; i < topping.length - 1; i++) {
            int cur = topping[i];
        
            //왼쪽 조각
            left.add(cur);

            //오른쪽 조각에서 왼쪽으로 뺌. 그 때의 오른쪽 개수를 맵에 다시 저장
            right.put(cur, right.get(cur) - 1);
            if (right.get(cur) == 0) { //토핑이 없으면 해당 조각 제거 
                right.remove(cur);
            }
            // 같은 사이즈면 카운팅
            if (left.size() == right.size()) {
                cnt++;
            }
        }

        return cnt;
    }
}