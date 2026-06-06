import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int n = jobs.length;
        Arrays.sort(jobs, (a,b) -> a[0] -b[0]);

        PriorityQueue<int[]> waiting = new PriorityQueue<>((a,b) -> a[1] - b[1]);

        int currentTime = 0;  //현재
        int jobIndex = 0;  //다음 작업 인덱스
        int totalResponse = 0; //응답시간 합

        while (jobIndex < n || !waiting.isEmpty()) {

            while (jobIndex < n && jobs[jobIndex][0] <= currentTime) {
                waiting.offer(jobs[jobIndex]);
                jobIndex++;
            }

            if (waiting.isEmpty()) {
                currentTime = jobs[jobIndex][0];
            } else{
                int[] current = waiting.poll();
                int requestTime = current[0]; // 요청시각
                int duration = current[1]; // 소요 시간

                currentTime += duration;
                totalResponse += currentTime - requestTime;
            }
        }

        return totalResponse / n;
    }
}

/** 요청시작 시간 오름차순 정렬
 최소 힙 -> 소요시간
 도착한 작업 -> 대기큐
 대기큐에서 소요시간 가장 짧은 것 poll
 작업 남아있으면 반복
 끝나면 평균 구하기
 **/
