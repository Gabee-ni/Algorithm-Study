import java.util.*;
class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Deque<Integer> q = new ArrayDeque<>();

        for(int i=0; i<speeds.length; i++){
            int amount = (int) Math.ceil((double)(100 -progresses[i]) / speeds[i]);
            q.offer(amount);
        }
        int cnt = 1;
        int day = q.poll();

        while(!q.isEmpty()){
            if (!q.isEmpty() && day >= q.peek()) {
                q.poll();
                cnt++;
            } else {
                answer.add(cnt);
                day = q.poll();
                cnt = 1;
            }
        }
        answer.add(cnt);
        return answer.stream().mapToInt(i->i).toArray();
    }
}
