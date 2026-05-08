import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Queue<Integer> queue = new LinkedList<>();
        
        for(int i=0; i<prices.length; i++){
            queue.offer(prices[i]);
        }
        
        //큐가 빌 때까지 인덱스를 하나씩 조회(하나씩 뽑으면서) 
        //각 인덱스를 기준으로 큐를 조회하면서 가격이 떨어지기 전까지 해당 인덱스의 값을 증가. 
        int idx = 0;
        while(!queue.isEmpty()){
            int num = queue.poll();
            for(int q: queue){
                answer[idx]++; //1초는 무조건 유지니까 일단 증가
                if(q< num) break;
            }
            idx++;
        }
        return answer;
    }
}