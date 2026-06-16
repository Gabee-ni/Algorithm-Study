import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;

        Arrays.sort(d); // 문법 틀려서 안 돌아갔었음

        for (int depBud : d) {
            budget -= depBud;
            if (budget >= 0) { // = 을 빼먹어서 결과 보고 고침
                answer ++;
            }
        }

        return answer;
    }
}