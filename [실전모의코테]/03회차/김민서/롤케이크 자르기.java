import java.util.*;

class Solution {
    public int solution(int[] topping) {
        
        Map<Integer, Integer> me = new HashMap<>();
        HashSet<Integer> bro = new HashSet<>();
        
        int cnt = 0;
        
        for (int t : topping) { 
            me.put(t, me.getOrDefault(t, 0) + 1);
        } 
        
        for (int t : topping) {
            bro.add(t);
            
            me.put(t, me.get(t) - 1);
            if (me.get(t) == 0) {
                me.remove(t);
            }
            
            if (me.size() == bro.size()) {
                cnt++;
            }
        }
        return cnt;
    }
}