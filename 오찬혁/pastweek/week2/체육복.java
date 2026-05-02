import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] clothes = new int[n + 1];

        for(int i = 1; i <= n; i++){
            clothes[i] = 1;
        }

        for(int i = 0; i < reserve.length; i++){
            clothes[reserve[i]] += 1;
        }

        for(int i = 0; i < lost.length; i++){
            clothes[lost[i]] -= 1;
        }

        for(int i = 1; i <= n; i++){
            if(clothes[i] == 0){
                if(i - 1 >= 1 && clothes[i - 1] == 2){
                    clothes[i] += 1;
                    clothes[i - 1] -= 1;
                }
            }

            if(clothes[i] == 0){
                if(i + 1 <= n && clothes[i + 1] == 2){
                    clothes[i] += 1;
                    clothes[i + 1] -= 1;
                }
            }
        }

        // System.out.println(Arrays.toString(clothes));

        for(int i = 1; i <= n; i++){
            if(clothes[i] >= 1){
                answer++;
            }
        }

        return answer;
    }
}