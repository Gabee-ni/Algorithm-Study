import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int seconds = 0;
        
        for(int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }
        
        int cw = 0;
        int second = 0;
        int truck = 0;
        
        while(truck < truck_weights.length) {
            second++;
            
            cw -= bridge.poll();
            
            if(cw + truck_weights[truck] <= weight) {
                bridge.add(truck_weights[truck]);
                
                cw += truck_weights[truck];
                
                truck++;
            } else {
                bridge.add(0);
            }
        }
        
        return second + bridge_length;
    }
}