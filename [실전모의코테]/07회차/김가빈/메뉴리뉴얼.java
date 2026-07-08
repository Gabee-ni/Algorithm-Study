import java.util.*;

class Solution {
    static Map<String, Integer> map;

    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();

        // 각 주문을 정렬
        for (int i = 0; i < orders.length; i++) {
            char[] arr = orders[i].toCharArray();
            Arrays.sort(arr);
            orders[i] = new String(arr);
        }

        // course 길이별로 조합 생성
        for (int size : course) {
            map = new HashMap<>();

            for (String order : orders) {
                if (order.length() >= size) {
                    combination(order, 0, size, new StringBuilder());
                }
            }

            int max = 0;

            // 가장 많이 주문된 조합 횟수 찾기
            for (int count : map.values()) {
                max = Math.max(max, count);
            }

            // 최소 2명 이상 주문했고, 최댓값인 조합만 정답에 추가
            if (max >= 2) {
                for (String key : map.keySet()) {
                    if (map.get(key) == max) {
                        answer.add(key);
                    }
                }
            }
        }

        Collections.sort(answer);

        return answer.toArray(new String[0]);
    }

    private void combination(String order, int start, int size, StringBuilder sb) {
        if (sb.length() == size) {
            String course = sb.toString();
            map.put(course, map.getOrDefault(course, 0) + 1);
            return;
        }

        for (int i = start; i < order.length(); i++) {
            sb.append(order.charAt(i));

            combination(order, i + 1, size, sb);

            sb.deleteCharAt(sb.length() - 1);
        }
    }
}