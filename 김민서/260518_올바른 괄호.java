import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> open = new Stack<>();
        
        for(char i : s.toCharArray()) {
            
            if (i == ')' && open.isEmpty()) {
                return false;
            } else if (i == ')' && !open.isEmpty()) {
                open.pop();
            } else {
                open.push(i);
            }
        }
        
        if (!open.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}