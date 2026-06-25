import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];

        Map<String, Integer> indexMap = new HashMap<>();
        Map<String, Integer> reportedCount = new HashMap<>();
        Map<String, Set<String>> reportMap = new HashMap<>();

        for (int i = 0; i < id_list.length; i++) {
            indexMap.put(id_list[i], i);
            reportMap.put(id_list[i], new HashSet<>());
        }

        for (String r : report) {
            String[] parts = r.split(" ");
            String reporter = parts[0];
            String reported = parts[1];

            if (reportMap.get(reporter).add(reported)) {
                reportedCount.put(reported, reportedCount.getOrDefault(reported, 0) + 1);
            }
        }

        for (String reporter : reportMap.keySet()) {
            for (String reported : reportMap.get(reporter)) {
                if (reportedCount.getOrDefault(reported, 0) >= k) {
                    answer[indexMap.get(reporter)]++;
                }
            }
        }

        return answer;
    }
}