// 처음 코드 - 효율성 테스트 전부 실패
import java.util.*;

class Solution
{
    public int solution(String s)
    {
        int answer = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i+1)) {
                s = s.substring(0, i) + s.substring(i + 2);
                i = -1;
            }
        }
        if (s.isEmpty()) {
            answer = 1;
        }

        return answer;
    }
}

// 개선 코드
class Solution {
    public int solution(String s) {
        char[] stack = new char[s.length()];
        int top = -1;

        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);

            if (top >= 0 && stack[top] == current) {
                top--;
            } else {
                stack[++top] = current;
            }
        }

        return top == -1 ? 1 : 0;
    }
}