import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        
        Arrays.sort(routes, (a, b) -> a[1] - b[1]);
        
        int camera = 0;
        int cameraPos = Integer.MIN_VALUE;
        
        for (int[] car : routes) {
            if (cameraPos < car[0]) {
                camera++;
                cameraPos = car[1];
            }
        }
        
        return camera;
    }
}