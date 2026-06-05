import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        
        PriorityQueue<int[]> waiting = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[2] != o2[2]) {
                    return o1[2] - o2[2];
                }
                
                if (o1[1] != o2[1]) {
                    return o1[1] - o2[1];
                }
                
                return o1[0] - o2[0];
            }
        });
        
        int[][] job = new int[jobs.length][3];
        
        for (int i = 0; i < jobs.length; i++) {
            job[i][0] = i;
            job[i][1] = jobs[i][0];
            job[i][2] = jobs[i][1];
        }
        
        Arrays.sort(job, (a, b) -> a[1] - b[1]);
        
        int seconds = 0;
        int[] times = new int[jobs.length];
        int[] cur = new int[3];
        int curEnd = 0;
        boolean isWorking = false;
        int idx = 0;
        
        while (idx < jobs.length) {
            
            for (int i = 0; i < jobs.length; i++) {
                if (seconds == job[i][1]) {
                    waiting.offer(job[i]);
                }
            }
            
            if (isWorking && curEnd != 0 && curEnd == seconds) {
                isWorking = false;
                times[idx] = curEnd - cur[1];
                idx++;
            }
            
            if (!isWorking && !waiting.isEmpty()) { // 작업중 아니고 대기중인게 있음
                cur = waiting.poll();
                curEnd = seconds + cur[2];
                isWorking = true;
            } 
            
            seconds++;      
        }
        
        int sum = 0;
        
        for (int t : times) {
            sum += t;    
        }
        
        return sum / job.length;
    }
}
