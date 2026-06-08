import java.util.*;

class Solution {

	static class UserInfo{
		String id;
		String nickname;

		UserInfo(String id, String nickname){
			this.id = id;
			this.nickname = nickname;
		}

		void changeNickname(String nickname){
			this.nickname = nickname;
		}

		String enterMessage(){
			return nickname + "님이 들어왔습니다.";
		}
		String leaveMessage(){
			return nickname + "님이 나갔습니다.";
		}
	}

	public String[] solution(String[] record) {
		HashMap<String, UserInfo> map = new HashMap<>();

		for(String rec : record){
			String[] cmd = rec.split(" ");
			if("Leave".equals(cmd[0])){
				continue;
			}

			String uid = cmd[1];
			String nickname = cmd[2];

			map.computeIfAbsent(uid, k -> new UserInfo(k, nickname))
				.changeNickname(nickname);
		}

		List<String> result = new ArrayList<>();
		for(String rec : record){
			String[] cmd = rec.split(" ");
			if("Enter".equals(cmd[0])){
				result.add(map.get(cmd[1]).enterMessage());
			} else if("Leave".equals(cmd[0])){
				result.add(map.get(cmd[1]).leaveMessage());
			}
		}

		return result.toArray(new String[0]);
	}
}