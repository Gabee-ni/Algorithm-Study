import java.util.*;
class Solution {
    public String solution(int[] numbers) {

        String[] strNum = new String[numbers.length];
        for (int i=0; i < numbers.length; i++) {
            strNum[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(strNum, (a,b) -> {
            String stay = a+b;
            String change = b+a;
            return change.compareTo(stay);
        });

        StringBuilder sb = new StringBuilder();
        for (String s : strNum) {
            sb.append(s);
        }

        if ( sb.charAt(0) == '0') {
            return "0";
        }
        return sb.toString();
    }
}

/** int -> string
두 수 비교 후 정렬
appand
**/

/** 000 인 테스트 케이스를 고려 하지 않아서 fail
 if ( sb.charAt(0) == '0') {
            return "0";
        }
        **/