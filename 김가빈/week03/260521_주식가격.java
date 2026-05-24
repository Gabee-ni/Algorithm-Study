import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> q = new ArrayDeque<>();

        for(int i=0; i<prices.length; i++){
            q.offer(prices[i]);
        }

        int idx = 0;
        while (!q.isEmpty()){
            int stock = q.poll();

            for(int p : q){
                answer[idx]++;
                if (p < stock) break;
            }
            idx++;
        }
        return answer;
    }
}