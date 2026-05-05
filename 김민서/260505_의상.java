import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, List<String>> clo = new HashMap<>();
        
        for(int i = 0; i < clothes.length; i++) {
            clo.computeIfAbsent(clothes[i][1], k -> new ArrayList<>()).add(clothes[i][0]);
        }
        
        int answer = 1;
        
        for (List<String> list : clo.values()) {
            int size = list.size();
            answer *= size + 1;
        }
        
        return answer - 1;
    }
}