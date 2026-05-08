import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int n = 0 ; n < commands.length; n++) {
            int[] cmd = commands[n];
            
            int i = cmd[0];
            int j = cmd[1];
            int k = cmd[2];
            
            int[] cp = Arrays.copyOfRange(array, i - 1, j);
            
            Arrays.sort(cp);
            
            answer[n] = cp[k - 1];
        }
        
        return answer;
    }
}