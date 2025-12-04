import java.util.Stack;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // ( 일 경우 스택에 push
            if (c == '(') stack.push(c); 
            // ) 일 경우 peek이 ( 면 (을 pop
            else if ( !stack.isEmpty() && stack.peek() == '(') stack.pop();
            else return false;
        }      
      
        return stack.isEmpty();
    }
}