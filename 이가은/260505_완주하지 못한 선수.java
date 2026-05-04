import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        HashMap<String, Integer> pMap = new HashMap<>();
        
        for (String p: participant) {
            pMap.put(p, pMap.getOrDefault(p, 0) + 1);
        }
        
        for (String c: completion) {
            pMap.put(c, pMap.get(c) - 1);
            if (pMap.get(c) == 0) {
                pMap.remove(c);
            }
        }        
        
        for (String p: pMap.keySet()) {
            return p;
        }
        
        return answer;
    }
}