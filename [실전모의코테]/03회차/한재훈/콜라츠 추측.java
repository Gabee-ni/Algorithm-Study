import java.util.*;
class Solution {
    public int solution(int num) {
        int answer = 0;
        long number = num;
        while(number != 1) {
            if (answer == 500) {
                return -1;
            }

            if (number % 2 == 0) {
                number = number / 2;
                answer++;
            } else {
                number = number *3 +1;
                answer++;
            }

        }
        return answer;

    }
}

/**
 짝수 -> /2 반복
 홀수 -> *3 -1 반복
 1 될 때까지 반복
 **/