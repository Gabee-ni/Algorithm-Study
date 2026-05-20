import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        for(int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        int time = 0;
        int bridgeWeight = 0;
        int idx = 0;

        while(idx < truck_weights.length || bridgeWeight > 0) {
            time++;
            bridgeWeight -= bridge.poll();

            if(idx < truck_weights.length && bridgeWeight + truck_weights[idx] <= weight){
                bridge.add(truck_weights[idx]);
                bridgeWeight += truck_weights[idx];
                idx++;
            } else {
                bridge.add(0);
            }

        }
        return time;
    }
}

/**
 다리 0으로 채움
 대기중 트럭이 있거나 다리 무게가 0 이상이면 진행
 다리 = 큐
 큐 맨앞 poll , poll 만큼 다리 무게 뺴기
 대기 트럭 있고 트럭이 올라갈 수 있으면 add
 아니면 다시 0 넣기
 false시 retur time
 **/