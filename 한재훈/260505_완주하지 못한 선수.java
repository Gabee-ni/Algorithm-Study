import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> end = new HashMap<>();

        for (String p : participant) {
            end.put(p, end.getOrDefault(p,0) + 1);
        }

        for (String c : completion) {
            end.put(c, end.get(c) - 1);
        }

        for (String giveUp : end.keySet()) {
            if (end.get(giveUp) !=0 ) {
                return giveUp;
            }
        }

        return "";
    }
}
