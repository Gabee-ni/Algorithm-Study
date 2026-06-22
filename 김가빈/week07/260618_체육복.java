import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] gymCloth = new int[n];

        Arrays.fill(gymCloth, 1);
        Arrays.sort(lost);
        Arrays.sort(reserve);

        for(int num : reserve) gymCloth[num-1]++;
        for(int num : lost) gymCloth[num-1]--;

        for(int i=0; i<n; i++){
            if (gymCloth[i]==2){
                if(i>0 && gymCloth[i-1] == 0) {
                    gymCloth[i]--;
                    gymCloth[i-1]++;
                } else if( i<n-1 && gymCloth[i+1] == 0) {
                    gymCloth[i]--;
                    gymCloth[i+1]++;
                }
            }
        }

        for(int num : gymCloth){
            if (num > 0) answer++;
        }
        return answer;
    }
}