import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        Queue<int[]> q = new LinkedList<>();

        // [인덱스, 우선순위]
        for(int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{i, priorities[i]});
        }

        int answer = 0;

        while(!q.isEmpty()) {

            int[] cur = q.poll();

            boolean hasHigher = false;

            // 현재보다 큰 우선순위가 있는지 확인
            for(int[] next : q) {
                if(next[1] > cur[1]) {
                    hasHigher = true;
                    break;
                }
            }

            // 더 큰 게 있으면 뒤로
            if(hasHigher) {
                q.offer(cur);
            }
            // 출력
            else {
                answer++;

                // 내가 찾는 문서면 종료
                if(cur[0] == location) {
                    return answer;
                }
            }
        }

        return answer;
    }
}