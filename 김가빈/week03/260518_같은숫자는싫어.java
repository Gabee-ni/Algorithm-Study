import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();

        for(int n : arr){
            deque.offer(n);
        }

        while(!deque.isEmpty()){
            int top = deque.poll();
            if(!deque.isEmpty() && top == deque.peek()) continue;
            list.add(top);
        }
        return list.stream().mapToInt(i->i).toArray();
    }
}