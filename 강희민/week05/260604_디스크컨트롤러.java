import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        Arrays.sort(jobs, (a, b) -> a[0] - b[0]);

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);

        int time = 0;      // 현재 시각
        int index = 0;     // jobs 배열에서 아직 큐에 넣지 않은 작업 위치
        int count = 0;     // 처리한 작업 수
        int total = 0;     // 반환 시간 총합

        while (count < jobs.length) {

            while (index < jobs.length && jobs[index][0] <= time) {
                pq.add(jobs[index]);
                index++;
            }

            // 처리할 수 있는 작업이 있다면
            if (!pq.isEmpty()) {
                int[] job = pq.poll();

                int requestTime = job[0];
                int workingTime = job[1];

                time += workingTime;

                total += time - requestTime;

                count++;
            }
            // 아직 요청된 작업이 없다면 시간을 다음 작업 요청 시각으로 이동
            else {
                time = jobs[index][0];
            }
        }

        return total / jobs.length;
    }
}