import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();
        
        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf((char)('A' + i)), i + 1);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        int nextIdx = 27;
        
        for (int i = 0; i < msg.length(); ) {
            int j = i + 1;
            
            while (j <= msg.length() && dict.containsKey(msg.substring(i, j))) {
                j++;
            }
            
            String w = msg.substring(i, j-1);
            
            answer.add(dict.get(w));
            
            if (j <= msg.length()) {
                dict.put(msg.substring(i, j), nextIdx++);
            }
            
            i += w.length();
        }
        
        return answer.stream().mapToInt(i->i).toArray();
    }
}