import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> send = new HashMap<>();
        
        for (String id : id_list) {
            map.put(id, new HashSet<>());
            send.put(id, 0);
        }
        
        for (String re : report) {
            
            String[] mem = re.split(" ");
            
            map.get(mem[1]).add(mem[0]);
            
        }
        
        for (String u : id_list) {
            if (map.get(u).size() >= k) {
                for (String s : map.get(u)) {
                    send.put(s, send.get(s) + 1);
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        
        for (int i = 0; i < answer.length; i++) {
            answer[i] = send.get(id_list[i]);
        }
        
        return answer;
    }
}
