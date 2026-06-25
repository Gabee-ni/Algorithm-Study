import java.util.*;
class Solution {
    public int solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
/**
 스택
 s 왼쪽부터 돌기
 스택 안 비었고 top이 지금 글자랑 같으면
 짝 맞음 -> top 빼냄
 다르거나 스택 비었으면 지금 글자 push
 스택 비었으면 다 지워진 거 -> 1
 뭐 남아있으면 -> 0
 */