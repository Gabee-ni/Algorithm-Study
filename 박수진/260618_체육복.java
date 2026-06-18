import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] closet = new int[n+1];
        Arrays.fill(closet, 1);

        for (int stolen : lost) {
            closet[stolen] -= 1;
        }
        
        for (int spare : reserve) {
            closet[spare] += 1;
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (closet[i] >= 1) {
                answer++;
            } else {
                if (i != 1 && closet[i-1] > 1) {
                    closet[i-1]--;
                    closet[i]++;
                    answer++;
                } else if (i != n && closet[i+1] > 1) {
                    closet[i+1]--;
                    closet[i]++;
                    answer++;
                } 
            }
        }
        
        return answer;
    }
}