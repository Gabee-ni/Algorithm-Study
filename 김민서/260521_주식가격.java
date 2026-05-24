import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        
        int[] answer = new int[prices.length];
        
        for(int i = 0; i < prices.length; i++) {
            int sec = 1;
            
            for (int  j = i + 1; j < prices.length; j++) {
                
                if(j == prices.length - 1) {
                    answer[i] = sec;
                } 
                
                if(prices[i] <= prices[j]) {
                    sec++;
                } else {
                    answer[i] = sec;
                    break;
                }
            }
        }
        
        return answer;
    }
}