import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wanted = new HashMap<>();
        
        int day = 0;
        for (int i = 0; i < want.length; i++) {
            wanted.put(want[i], number[i]);
            day += number[i];
        }
        
        int cnt = 0;
        
        for (int i = 0; i < discount.length - day + 1; i++) {
            
            Map<String, Integer> w = new HashMap<>(wanted);
            boolean right = true;
            
            for (int j = i; j < i + day; j++) {
                if (w.containsKey(discount[j])) {
                    w.put(discount[j], w.get(discount[j]) - 1);
                }
            }
            
            for (int a = 0; a < want.length; a++) {
                if (w.get(want[a]) > 0) {
                    right = false;
                    break;
                }
            }
            if (right) {
                cnt++;   
            }
        }
        
        return cnt;
    }
}