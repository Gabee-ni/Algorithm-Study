import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0, idx = 0;
        Deque<Integer> bridge = new ArrayDeque<>();

        for (int i = 0; i<bridge_length; i++) bridge.offer(0);
        int bridgeWeight = 0;

        while(idx < truck_weights.length){
            if (!bridge.isEmpty()) bridgeWeight -= bridge.poll();

            if (truck_weights[idx] + bridgeWeight <= weight){
                bridge.offer(truck_weights[idx]);
                bridgeWeight += truck_weights[idx++];
            } else {
                bridge.offer(0);
            }
            answer++;
        }
        return answer + bridge_length;
    }
}