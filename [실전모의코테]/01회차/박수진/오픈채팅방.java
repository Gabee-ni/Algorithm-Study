import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> user = new HashMap<>();
        int idx = 0;
        
        for (String r : record) {
            String[] cur = r.split(" ");
            
            if (cur[0].equals("Enter")) {
                user.put(cur[1], cur[2]);
                idx++;
            } else if (cur[0].equals("Leave")) {
                idx++;
            } else {
                user.put(cur[1], cur[2]);
            }
        }
        
        String[] answer = new String[idx];
        idx = 0;
        
        for (String s : record) {
            String[] cur = s.split(" ");

            if (cur[0].equals("Enter")) {
                answer[idx] = user.get(cur[1]) + "님이 들어왔습니다.";
            } else if (cur[0].equals("Leave")) {
                answer[idx] = user.get(cur[1]) + "님이 나갔습니다.";
            } else {
                continue;
            }

            idx++;
        }
        
        return answer;
    }
}