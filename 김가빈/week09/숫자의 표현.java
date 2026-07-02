import java.util.*;
class Solution {
    public int solution(int n) {
        int answer = 0;
        int sum = 0;

        int start = 1, end =1;

        while(start <= n){
            if (sum < n) {
                sum += end;
                end++;
            } else if (sum > n) {
                sum -= start;
                start++;
            } else {
                answer++;
                sum -= start;
                start++;
            }
        }

        return answer;
    }
}