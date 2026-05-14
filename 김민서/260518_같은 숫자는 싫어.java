import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        
        Stack<Integer> num = new Stack<>();
        num.push(arr[0]);
        
        for(int i = 1; i < arr.length; i++) {
            
            if(num.peek() != arr[i]) {
                num.push(arr[i]);
            } else {
                continue;
            }
        }
        
        int[] answer = new int[num.size()];
        
        for(int i = num.size() - 1; i >= 0; i--) {
            answer[i] = num.pop();
        }
        
        return answer;
    }
}