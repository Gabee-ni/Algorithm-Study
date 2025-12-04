import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

class Solution {
    public int solution(int bridge_length, int limit, int[] truck_weights) {
        int answer = 0;
        Queue<Integer> queue = new ArrayDeque();
        int time = 0;
        int totalWeight = 0;
        int[] bridge = new int[bridge_length]; // 인덱스에 현재 위치한 트럭 저장
        int success = 0;
        
        for (int truck: truck_weights) queue.add(truck);
        
        
        
        while (success < truck_weights.length) {
            
            // 도착 트럭 처리
            if (bridge[bridge_length-1] > 0) {                
                totalWeight -= bridge[bridge_length - 1];
                success += 1;
            }
            
            
            if (time > 0) {
                // 이전 인덱스의 값을 알고 있어야 하므로
                // 마지막 인덱스부터 값 업데이트
                for (int i = bridge_length - 1; i >= 1; i--) {
                    bridge[i] = bridge[i-1]; 
                }
                bridge[0] = 0;
            }
           
            if (!queue.isEmpty()) {
                int readyTruck = queue.peek();
            
                // 다음 트럭 올라가도 되는 경우
                if (totalWeight + readyTruck <= limit) {
                    queue.poll();
                    totalWeight += readyTruck;
                    // 다음 트럭 배치
                    bridge[0] = readyTruck;
                } 
            }
            
            time++;
        }
        return time;
    }
}