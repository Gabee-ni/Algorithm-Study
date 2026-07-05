import java.util.*;

class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        List<Integer> win = new ArrayList<>();
        
        for(int i = 0; i < lottos.length; i++) {
            win.add(win_nums[i]);
        }
        
        int match = 0;
        int zero = 0;
        for (int l : lottos) {
            if (l == 0) {
                zero++;
            }
            
            if (win.contains(l)) {
                match++;
            }
        }
        
        if (match == lottos.length) {
            return new int[] {1, 1};
        }
        
        if (zero == 0 && match == 0) {
            return new int[] {6, 6};
        }
        
        if (match == 0) {
            return new int[] {6 - zero + 1, 6};
        }
        
        int min = lottos.length - (match + zero) + 1;
        int max = lottos.length - match + 1;
        
        return new int[] {min, max};
    }
}
