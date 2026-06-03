import java.util.PriorityQueue;
import java.util.LinkedList;
import java.util.Arrays;

class Solution {
    static int newFood = 0;
    
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int size = scoville.length;
        int answer = 0;
        
        for (int i = 0; i < size; i++) {
            pq.offer(scoville[i]);
        }
        
        if (pq.peek() >= K)
            return 0;
        
        int newFood = 0;
        while(pq.size() >= 2) {
            newFood = (pq.poll() + pq.poll()*2);
            pq.offer(newFood);
            answer++;
            
            if (pq.peek() >= K) {
                return answer;
            }
        }

        return -1;
    }
}