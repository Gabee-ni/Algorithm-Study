import java.util.*;
class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minQ = new PriorityQueue<>();
        PriorityQueue<Integer> maxQ = new PriorityQueue<>(Collections.reverseOrder());
        for(String op : operations){
            String[] parts = op.split(" ");
            String command = parts[0];
            int number = Integer.parseInt(parts[1]);

            if (command.equals("I")){
                minQ.offer(number);
                maxQ.offer(number);
            } else if (command.equals("D")){
                if(minQ.isEmpty() || maxQ.isEmpty()) continue;
                if(number == 1){
                    int max = maxQ.poll();
                    minQ.remove(max);
                } else if ( number == -1){
                    int min = minQ.poll();
                    maxQ.remove(min);
                }
            }
        }
        if(minQ.isEmpty() || maxQ.isEmpty()){
            return new int[]{0,0};
        } else return new int[]{maxQ.peek(), minQ.peek()};

    }
}