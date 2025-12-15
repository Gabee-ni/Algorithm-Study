import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;

        Arrays.sort(lost);
        Arrays.sort(reserve);
        
        for(int i=0; i<lost.length;i++){
            for(int j=0; j<reserve.length; j++){
                if(lost[i]==reserve[j]){
                    answer++;
                    lost[i]=0;
                    reserve[j]=0;
                    break;
                }
            }
        }
        
        for(int i=0; i<lost.length;i++){
            if(lost[i]==0) continue;
            for(int j=0; j<reserve.length; j++){
                if(reserve[j]==0) continue;
                if(lost[i]==reserve[j]-1||lost[i]==reserve[j]+1){
                    answer++;
                    lost[i]=0;
                    reserve[j]=0;
                    break;
                } 
            }
        }
        
        return n-(lost.length-answer);
    }
}