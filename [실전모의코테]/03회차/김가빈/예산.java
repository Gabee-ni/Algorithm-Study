import java.util.*;

class Solution {
    int answer = 0;

    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        int sum = 0;
        for(int money : d){
            if(sum + money <= budget){
                sum += money;
                answer++;
            } else break;
        }

        return answer;
    }

}