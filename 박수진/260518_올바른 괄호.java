import java.util.*;

class Solution {
    boolean solution(String s) {
        Deque<Character> que = new ArrayDeque<>();
        int size = s.length();
        
        for (int i = 0; i < size; i++) {
            if (s.charAt(i) == '(') {
                que.offer('(');
            } else {
                try {
                    que.pop();
                } catch (Exception e) {
                    return false;
                }
            }
        }
        
        return que.isEmpty() ? true : false;        
    }
}