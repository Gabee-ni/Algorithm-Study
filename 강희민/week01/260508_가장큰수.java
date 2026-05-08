import java.util.*;
class Solution {
    public String solution(int[] numbers) {
        String [] num = new String [numbers.length];
        String answer = "";

        for (int i = 0; i < numbers.length; i++) {
            num[i] = Integer.toString(numbers[i]);
        }

        Arrays.sort(num, (a,b) -> (b+a).compareTo(a+b));
        answer = String.join("", num);
        return answer.charAt(0) == '0' ? "0" : answer;
    }
}