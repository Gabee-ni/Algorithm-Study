import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> q = new ArrayDeque<>();

        for(int i=0; i<priorities.length; i++){
            q.offer(new int[]{priorities[i], i});
        }

        int cnt = 0;
        while(!q.isEmpty()){
            int[] process = q.poll();
            boolean isMax = false;

            for(int[] p : q){
                if(p[0] > process[0]) {
                    isMax = true;
                    break;
                }
            }

            if (isMax) q.offer(process);
            else{
                cnt++;
                if (process[1] == location) return cnt;

            }

        }

        return 0;
    }
}