import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reporter = new HashMap<>();
        
        for (String id : id_list) {
            reporter.put(id, new HashSet<>());
        }
        
        for (String r : report) {
            String[] arr = r.split(" ");
            reporter.get(arr[1]).add(arr[0]);
        }
        
        Map<String, Integer> cnt = new HashMap<>();
        
        for (String id : id_list) {
            cnt.put(id, 0);
        }
        
        for (String reported : id_list) {
            Set<String> set = reporter.get(reported);
            
            if (set.size() >= k) {
                
                for (String r : set) {
                    cnt.put(r, cnt.get(r) + 1);
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            answer[i] = cnt.get(id_list[i]);
        }
        
        return answer;
    }
}