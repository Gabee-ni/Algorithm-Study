import java.util.*;

class Solution {
    public int solution(String s) {
        Deque<Character> str = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (str.isEmpty()) {
                str.offer(s.charAt(i));
                continue;
            }
            
            if (str.peekLast() == s.charAt(i)) {
                str.pollLast();
            } else {
                str.offer(s.charAt(i));
            }
        }


        if (str.isEmpty()) {
            return 1;
        }
        
        return 0;
    }
}