class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder("");
        
        s = s.toLowerCase();
        
        boolean flag = false;
        for (int i = 0; i < s.length(); i++) {
            if (i == 0) {
                answer.append((s.charAt(i) + "").toUpperCase());
                continue;
            }
            
            if (s.charAt(i) == ' ') {
                flag = true;
                answer.append(s.charAt(i) + "");
            } else if (flag) {
                answer.append((s.charAt(i) + "").toUpperCase());
                flag = false;
            } else {
                answer.append(s.charAt(i) + "");
            }
        }
        
        return answer.toString();
    }
}