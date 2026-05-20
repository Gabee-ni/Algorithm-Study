import java.util.*;
class Solution {
    boolean solution(String s) {
        int count=0;

        for(int i =0; i<s.length(); i++) {
            if (s.charAt(i)== '(') {
                count++;
            } else {
                count --;
            }
            if (count < 0) {
                return false;
            }
        }
        return count ==0;
    }
}

/** 괄호 찾기
 ( = +1,
 ) -1
 count가 0이면 true
 **/