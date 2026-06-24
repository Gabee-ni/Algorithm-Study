import java.util.*;

class Solution {

    Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query) {

        // 1. info 전처리
        for (String s : info) {
            String[] arr = s.split(" ");

            String[] attrs = {
                arr[0], arr[1], arr[2], arr[3]
            };

            int score = Integer.parseInt(arr[4]);

            dfs(0, "", attrs, score);
        }

        // 2. 점수 리스트 정렬
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        // 3. query 처리
        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {

            String q = query[i]
                    .replace(" and ", " ");

            String[] arr = q.split(" ");

            String key =
                    arr[0] +
                    arr[1] +
                    arr[2] +
                    arr[3];

            int targetScore =
                    Integer.parseInt(arr[4]);

            List<Integer> list =
                    map.getOrDefault(
                            key,
                            new ArrayList<>()
                    );

            int idx = lowerBound(
                    list,
                    targetScore
            );

            answer[i] =
                    list.size() - idx;
        }

        return answer;
    }

    private void dfs(int depth, String key, String[] attrs, int score) {

        if (depth == 4) {

            map.putIfAbsent(key, new ArrayList<>());

            map.get(key).add(score);

            return;
        }

        // 실제 값
        dfs(depth + 1, key + attrs[depth], attrs, score);

        // -
        dfs(depth + 1, key + "-", attrs, score);
    }

    private int lowerBound(List<Integer> list, int target) {

        int left = 0;
        int right = list.size();

        while (left < right) {

            int mid =
                    (left + right) / 2;

            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}