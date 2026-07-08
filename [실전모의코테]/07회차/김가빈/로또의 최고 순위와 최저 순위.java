import java.util.*;
class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {

        int cnt = 0, unknown = 0;
        // Arrays.sort(lottos);
        // Arrays.sort(win_nums);

        for (int i=0; i<lottos.length; i++) {
            if (lottos[i] == 0) unknown+=1;
            for(int j=0; j<win_nums.length; j++){
                if(lottos[i] == win_nums[j]) cnt+=1;
            }
        }

        int best = cnt + unknown ;
        best = (best > 0) ? best : 1;
        cnt = (cnt > 1) ? cnt : 1;

        int[] answer = new int[]{Math.abs(best-7), Math.abs(cnt-7)};

        return answer;
    }
}