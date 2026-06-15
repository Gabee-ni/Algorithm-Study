import java.util.Arrays;

class Solution {
    public int solution(int[] d, int budget) {
        Arrays.sort(d);
        
        int answer = 0;
        for (int require : d) {
            if (require <= budget) {
                budget -= require;
                answer++;
            }
        }
        
        return answer;
    }
}