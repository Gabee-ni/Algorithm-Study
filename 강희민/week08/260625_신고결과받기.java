import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Integer> reportCnt = new HashMap<>();
        Map<String, Integer> mailCnt = new HashMap<>();

        for (String id : id_list) {
            reportCnt.put(id, 0);
            mailCnt.put(id, 0);
        }

        // asList: 배열을 리스트로 바꿔줌
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));

        for (String r : reportSet) {
            String[] sp = r.split(" ");

            String reported = sp[1];
            reportCnt.put(reported, reportCnt.get(reported) + 1);
        }

        for (String r : reportSet) {
            String[] sp = r.split(" ");

            String reporter = sp[0];
            String reported = sp[1];

            if (reportCnt.get(reported) >= k) {
                mailCnt.put(reporter, mailCnt.get(reporter) + 1);
            }
        }

        int[] answer = new int[id_list.length];

        for (int i = 0; i < id_list.length; i++) {
            answer[i] = mailCnt.get(id_list[i]);
        }

        return answer;
    }
}