import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {

        PriorityQueue<Integer> pq =  new PriorityQueue<>();
        for(int s : scoville) {
            pq.offer(s);
        }
        int count = 0;
        while( pq.peek() < K ) {

            if(pq.size() < 2)  {
                return -1;
            }
            if(pq.size() >= 2){
                int a = pq.poll();
                int b = pq.poll();

                int mix = 0;
                mix = a + b*2;
                pq.offer(mix);
                count++;
            }

        }

        return count;

    }
}

/** 우선순위 힙
 k 작고 2개 -> a + b*2
 -1
 **/