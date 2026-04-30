import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> complete = new HashMap<>(); 
        for (String finisher : completion) {
            complete.put(finisher, complete.getOrDefault(finisher, 0) + 1);
        }
        
        for (String ptcp : participant) {
            if (complete.containsKey(ptcp)) {
                complete.put(ptcp, complete.get(ptcp) - 1);
                if (complete.get(ptcp) < 0) {
                    return ptcp;
                }
            } else {
                return ptcp;
            }
        }
        
        return " ";
    }
}