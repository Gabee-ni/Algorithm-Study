import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        StringBuilder answer = new StringBuilder();
        
        String[] strArr = new String[numbers.length];
        
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = numbers[i] + "";
        }
        
        Arrays.sort(strArr, (a, b) -> (b + a).compareTo(a + b));
        
        if (strArr[0].equals("0")) {
            return "0";
        }
        
        for (String str: strArr) {
            answer.append(str);
        }
        
        return answer.toString();
    }
}