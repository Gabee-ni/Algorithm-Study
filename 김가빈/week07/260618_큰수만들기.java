import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Stack<Integer> stack = new Stack<>();
        int popCount = 0;

        stack.push(number.charAt(0) - '0');

        for (int i = 1; i < number.length(); i++) {
            int cur = number.charAt(i) - '0';

            while (!stack.isEmpty()
                    && popCount < k
                    && stack.peek() < cur) {
                stack.pop();
                popCount++;
            }

            stack.push(cur);

            if (popCount == k) {
                for (int j = i + 1; j < number.length(); j++) {
                    stack.push(number.charAt(j) - '0');
                }
                break;
            }
        }

        while (popCount < k) {
            stack.pop();
            popCount++;
        }

        StringBuilder sb = new StringBuilder();
        for (int num : stack) {
            sb.append(num);
        }

        return sb.toString();
    }
}