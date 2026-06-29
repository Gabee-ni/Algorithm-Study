import java.util.*;

class Solution {
    public int[] solution(String[] info, String[] query) {
        Map<String, List<Integer>> map = new HashMap<>();

        for (String in : info) {
            String[] sp = in.split(" ");

            String lang = sp[0];
            String job = sp[1];
            String career = sp[2];
            String food = sp[3];
            int score = Integer.parseInt(sp[4]);

            String[] langs = {lang, "-"};
            String[] jobs = {job, "-"};
            String[] careers = {career, "-"};
            String[] foods = {food, "-"};

            for (String l : langs) {
                for (String j : jobs) {
                    for (String c : careers) {
                        for (String f : foods) {
                            String key = l + j + c + f;

                            map.putIfAbsent(key, new ArrayList<>());
                            map.get(key).add(score);
                        }
                    }
                }
            }
        }

        for (List<Integer> list : map.values()) {
            Collections.sort(list);
        }

        int[] answer = new int[query.length];

        for (int i = 0; i < query.length; i++) {
            String q = query[i].replace(" and ", " ");
            String[] sp = q.split(" ");

            String key = sp[0] + sp[1] + sp[2] + sp[3];
            int score = Integer.parseInt(sp[4]);

            if (!map.containsKey(key)) {
                answer[i] = 0;
            } else {
                List<Integer> list = map.get(key);
                answer[i] = list.size() - lowerBound(list, score);
            }
        }

        return answer;
    }

    int lowerBound(List<Integer> list, int target) {
        int left = 0;
        int right = list.size();

        while (left < right) {
            int mid = (left + right) / 2;

            if (list.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}