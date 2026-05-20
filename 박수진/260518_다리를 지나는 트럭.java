import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        bridge.offer(truck_weights[0]);
        
        int sec = 1;
        int totalW = truck_weights[0];
        
        for (int i = 1; i < truck_weights.length; sec++) {
            if (bridge.size() == bridge_length) {
                totalW -= bridge.poll();
            }
            
            if (totalW + truck_weights[i] <= weight) {
                bridge.offer(truck_weights[i]);
                totalW += truck_weights[i];
                i++;
                continue;
            }
            
            bridge.offer(0);
        }
        
        sec += bridge_length;
        return sec;
    }
}