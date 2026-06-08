import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        
        PriorityQueue<Integer> minQue = new PriorityQueue<>();
        PriorityQueue<Integer> maxQue = new PriorityQueue<>(Collections.reverseOrder());
        
        for (String s : operations) {
            
            String[] arr = s.split(" ");
            int i = Integer.parseInt(arr[1]);
            
            if (arr[0].equals("I")) {
                
                minQue.offer(i);
                maxQue.offer(i);
            
            } else if (arr[0].equals("D")) {
                
                if (minQue.isEmpty()) continue;
                
                if (i < 0) {
                    int min = minQue.poll();
                    maxQue.remove(min);
                } else {
                    int max = maxQue.poll();
                    minQue.remove(max);
                }
            }
        }
        
        if (maxQue.isEmpty()) {
            return new int[] {0, 0};
        }
        
        return new int[] {maxQue.poll(), minQue.poll()};
    }
}