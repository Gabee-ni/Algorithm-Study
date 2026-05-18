import java.util.*;
class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Deque<Character> deque = new ArrayDeque<>();

        if( s.charAt(0) == ')') return false;

        deque.push(s.charAt(0));

        for(int i=1; i<s.length(); i++){
            if(!deque.isEmpty() && deque.peek() == '('){
                if (s.charAt(i) == ')') deque.pop();
                else deque.push(s.charAt(i));
            } else deque.push(s.charAt(i));
        }
        if (deque.isEmpty()) return true;
        else return false;
    }
}