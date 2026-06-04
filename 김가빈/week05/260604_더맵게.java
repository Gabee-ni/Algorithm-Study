import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        //최소힙에 넣어서 낮은 스코빌 지수를 새로운 지수로 만들고 다시 넣음. 힙에서 꺼낸 애가 K이상이면 -> 최소가 K이상인 것이니까 종료
        for(int n : scoville){
            heap.offer(n);
        }

        int answer = 0;
        while(!heap.isEmpty()){
            int score = heap.poll();
            if(score >= K) break;

            if(!heap.isEmpty()){
                int newScore = score + (heap.poll() * 2);
                heap.offer(newScore);
                answer++;
            } else return -1;
        }
        return answer;
    }
}