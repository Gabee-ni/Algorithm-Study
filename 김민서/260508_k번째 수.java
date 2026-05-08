import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0];
            int end = commands[i][1];
            int idx = commands[i][2];
            
            int[] part = Arrays.copyOfRange(array, start - 1, end);
            
            Arrays.sort(part);
            
            answer.add(part[idx - 1]);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}