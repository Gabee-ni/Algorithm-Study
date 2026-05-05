import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        Map<String, String> nicknameMap = new HashMap<>();
        List<String> result = new ArrayList<>();

        // 아이디에 따라서 현재 닉네임 저장하기 
        for (String r : record) {
            String[] arr = r.split(" "); 
            String action = arr[0]; //나가는지 들어가는지
            String uid = arr[1];    //유저 아이디 

            
            //현재 방에 들어왔거나 닉네임 변경하면 현재 닉네임을 해당하는 유저에 맞게 저장하기 
            if (action.equals("Enter") || action.equals("Change")) {
                String nickname = arr[2];
                nicknameMap.put(uid, nickname);
            }
        }

        //출력문 생성 -> enter인지 leave인지에 따라 아이디랑 닉네임 출력 
        for (String r : record) {
            String[] arr = r.split(" ");
            String action = arr[0];
            String uid = arr[1];
    
            if (action.equals("Enter")) {
                result.add(nicknameMap.get(uid) + "님이 들어왔습니다.");
            } else if (action.equals("Leave")) {
                result.add(nicknameMap.get(uid) + "님이 나갔습니다.");
            }
        }

        return result.toArray(new String[0]);
    }
}