import java.util.*;

class Solution {
	public String[] solution(String[] record) {
		Map<String, String> nick = new HashMap<>();
		List<String[]> logs = new ArrayList<>();

		// Enter uid1234 Muzi
		// Leave uid1234
		// Change uid4567 Ryan
		for(String line : record){
			String[] temp = line.split(" ");
			String cmd = temp[0];
			String uid = temp[1];

			if("Enter".equals(cmd)){
				String name = temp[2];
				nick.put(uid, name);
				logs.add(new String[]{uid, "Enter"});
			} else if("Leave".equals(cmd)){
				logs.add(new String[]{uid, "Leave"});
			} else if("Change".equals(cmd)){
				String name = temp[2];
				nick.put(uid, name);
			}
		}

		String[] answer = new String[logs.size()];
		int idx = 0;
		for(String[] log : logs){
			String uid = log[0];
			String cmd = log[1];
			String name = nick.get(uid);

			if("Enter".equals(cmd)){
				answer[idx++] = name + "님이 들어왔습니다.";
			} else {
				answer[idx++] = name + "님이 나갔습니다.";
			}
		}

		return answer;
	}
}