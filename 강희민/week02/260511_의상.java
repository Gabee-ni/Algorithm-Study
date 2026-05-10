import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        // 의상 종류별 개수
        for (String[] cloth : clothes) {
            String type = cloth[1];

            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        // 안 입음 포함
        int answer = 1;

        for (int count : map.values()) {
            answer *= (count + 1);
        }

        // 아무것도 안 입음 제외
        return answer - 1;
    }
}