class Solution {
	public String solution(String s) {
		String answer = "";
		boolean flag = false;

		s = s.toLowerCase();

		for(int i = 0; i < s.length(); i++){
			if(i == 0){
				answer += String.valueOf(s.charAt(0)).toUpperCase();
				continue;
			}

			char ch = s.charAt(i);

			if(ch == ' '){
				answer += " ";
				flag = true;
			} else {
				if(flag){
					answer += String.valueOf(ch).toUpperCase();
					flag = false;
				} else {
					answer += String.valueOf(ch);
				}
			}
		}

		return answer;
	}
}