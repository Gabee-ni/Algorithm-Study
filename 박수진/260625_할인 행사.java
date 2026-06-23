import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> basket = new HashMap<>();
        
        for (int i = 0; i < want.length; i++) {
            basket.put(want[i], number[i]);
        }
        
        for (int i = 0; i < 10; i++) {
            if (basket.containsKey(discount[i])) {
                basket.put(discount[i], basket.get(discount[i]) - 1);
            }
        }
        
        int answer = 0;
        
        for (int i = 9; i < discount.length; i++) {
            
            if (i > 9) {
                if (basket.containsKey(discount[i])) {
                    basket.put(discount[i], basket.get(discount[i]) - 1);
                }
                
                if (basket.containsKey(discount[i-10])) {
                    basket.put(discount[i-10], basket.get(discount[i-10]) + 1);
                }
            }
            
            if (check(want, basket)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private boolean check(String[] want, Map<String, Integer> basket) {
        for (String w : want) {
            if (basket.get(w) > 0) {
                return false;
            }
        }
        
        return true;
    }
}