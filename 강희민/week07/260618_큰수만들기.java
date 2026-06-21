class Solution {
    public String solution(String number, int k) {
        int resultLength = number.length() - k;

        char[] stack = new char[number.length()];

        int top = 0;

        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);


            // 스택의 마지막 숫자가 현재 숫자보다 작으면 제거
            while (top > 0
                    && k > 0
                    && stack[top - 1] < current) {

                top--;  // 마지막 숫자 제거
                k--;
            }

            stack[top] = current;
            top++;
        }

        return new String(stack, 0, resultLength);
    }
}