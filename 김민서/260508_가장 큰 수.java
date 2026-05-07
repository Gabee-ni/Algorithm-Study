import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        String[] maxNum = new String[numbers.length];
        
        for(int i = 0; i < numbers.length; i++) {
            maxNum[i] = String.valueOf(numbers[i]);
        }
        
        Arrays.sort(maxNum, (a, b) -> (b + a).compareTo(a + b));
        
        if(maxNum[0].equals("0")) return "0";
        
        StringBuilder sb = new StringBuilder();

        for(String s : maxNum) {
            sb.append(s);
        }
        
        return sb.toString();
    }
}