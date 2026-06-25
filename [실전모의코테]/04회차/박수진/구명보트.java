import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        
        boolean[] exited = new boolean[people.length];
        
        int answer = 0;
        
        for (int i = people.length-1; i >= 0; i--) {
            if (exited[i])
                continue;
            
            exited[i] = true;
            boolean flag = false;
            
            for (int j = 0; j < i; j++) {
                if (exited[j]) {
                    continue;
                }
                
                if (people[j] + people[i] <= limit) {
                    exited[j] = true;
                    flag = true;
                    break;
                } else {
                    break;
                }
            }
            
            answer++;
        }
        
        return answer;
    }
}