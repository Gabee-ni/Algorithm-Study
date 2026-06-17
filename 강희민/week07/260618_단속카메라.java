import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        int answer = 0;

        // 진출 지점 기준 정렬
        Arrays.sort(routes, (a, b) ->
                Integer.compare(a[1], b[1])
        );

        int camera = Integer.MIN_VALUE;

        for (int[] route : routes) {
            int enter = route[0];
            int exit = route[1];

            if (enter > camera) {
                // 진출 지점에 카메라 설치
                camera = exit;
                answer++;
            }
        }

        return answer;
    }
}