import java.util.*;
class Solution {
    public int solution(String word) {
        int[] skip = {781, 156, 31, 6, 1};

        String alpha = "AEIOU";
        int answer = 0;

        for (int i=0; i<word.length(); i++) {
            int idx = alpha.indexOf(word.charAt(i));
            answer += idx * skip[i] + 1;
        }
        return answer;

    }
}

/** 1
 1 5
 1 5 25
 1 5 25 125
 1 5 25 125 625
 **/