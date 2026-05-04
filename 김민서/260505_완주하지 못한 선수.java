import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> com = new HashMap<>();
        
        for(int i = 0; i < completion.length; i++) {
            com.put(completion[i], com.getOrDefault(completion[i], 0) + 1);
        }
        
        for (String name : participant) {
            if (!com.containsKey(name) || com.get(name) == 0) {
                return name;
            }
            com.put(name, com.get(name) - 1);
        }
        
        return "";
    }
}