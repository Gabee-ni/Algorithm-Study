import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] result = new int[prices.length];
        Stack<Integer> stack = new Stack<Integer>();
        
        for(int i = 0; i < prices.length; i++) {
            while(!stack.isEmpty() && prices[stack.peek()] > prices[i]){
                int idx = stack.pop();
                result[idx] = i - idx;
            }
            stack.add(i);
        }
        for(int i : stack) {
            result[i] = prices.length - i - 1;
        }
        return result;
    }
}