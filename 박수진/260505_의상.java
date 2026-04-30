import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> closet = new HashMap<>();
        
        for (int i = 0; i < clothes.length; i++) {
            closet.put(clothes[i][1], closet.getOrDefault(clothes[i][1], 0) + 1);
        }
        
        int answer = 1;
        Set<String> keySet = closet.keySet();
        for (String key : keySet) {
            answer *= (closet.get(key) + 1);
        }

        return answer - 1;
    }
}