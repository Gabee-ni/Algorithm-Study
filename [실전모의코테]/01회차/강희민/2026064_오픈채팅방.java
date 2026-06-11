import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nicknameMap = new HashMap<>();
        ArrayList<String[]> logs = new ArrayList<>();

        // uid별 최종 닉네임 저장
        for (String r : record) {
            String[] split = r.split(" ");

            String command = split[0];
            String uid = split[1];

            if (command.equals("Enter")) {
                String nickname = split[2];
                nicknameMap.put(uid, nickname);
                logs.add(new String[]{uid, "Enter"});
            }
            else if (command.equals("Leave")) {
                logs.add(new String[]{uid, "Leave"});
            }
            else if (command.equals("Change")) {
                String nickname = split[2];
                nicknameMap.put(uid, nickname);
            }
        }

        String[] answer = new String[logs.size()];

        for (int i = 0; i < logs.size(); i++) {
            String uid = logs.get(i)[0];
            String command = logs.get(i)[1];
            String nickname = nicknameMap.get(uid);

            if (command.equals("Enter")) {
                answer[i] = nickname + "님이 들어왔습니다.";
            } else {
                answer[i] = nickname + "님이 나갔습니다.";
            }
        }

        return answer;
    }
}