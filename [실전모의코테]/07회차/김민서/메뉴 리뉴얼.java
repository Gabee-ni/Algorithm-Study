import java.util.*;

class Solution {
    
    static Map<String, Integer> way = new HashMap<>();
    static Set<String> key = new HashSet<>();
    static char[] st;
    static char[] order;
    
    public String[] solution(String[] orders, int[] course) {
        
        List<String> answer = new ArrayList<>();
        
        for (int c : course) {
            way = new HashMap<>();
            key = new HashSet<>();
            st = new char[c];
            
            for (String o : orders) {
                order = o.toCharArray();
                Arrays.sort(order);
                if (order.length < c) {
                    continue;
                }
                
                dfs(c, 0, 0);
            }
            
            int max = 0;
            for (String k : key) {
                if (way.get(k) > max) {
                    max = way.get(k);
                }
            }

            for (String k : key) {
                if (max >= 2 && way.get(k) == max) {
                    answer.add(k);
                }
            }
        }
        
        Collections.sort(answer);
        String[] ans = new String[answer.size()];
        
        for (int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        
        return ans;
    }
    
    void dfs(int c, int idx, int dept) {
        if (dept == c) {
            String r = new String(st);
            way.put(r, way.getOrDefault(r, 0) + 1);
            key.add(r);
            return;
        }
        
        for (int i =  idx; i < order.length; i++) {
            st[dept] = order[i];
            dfs(c, i + 1, dept + 1);
        }
    }
}