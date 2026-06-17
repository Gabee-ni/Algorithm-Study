import java.util.*;

class Solution {
    public int solution(int[][] routes) {

        Arrays.sort(routes, (a, b) -> a[1] - b[1]);

        int camera = Integer.MIN_VALUE;
        int answer = 0;

        for (int[] route : routes) {

            if (camera < route[0]) {
                answer++;
                camera = route[1];
            }
        }

        return answer;
    }
}