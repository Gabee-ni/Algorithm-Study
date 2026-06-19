import java.util.*;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        
        List<Integer> lo = new ArrayList<>();
        for (int i : lost) lo.add(i);
        
        List<Integer> re = new ArrayList<>();
        for (int i : reserve) re.add(i);
        
        Collections.sort(lo);
        Collections.sort(re);
        
        int cnt = 0;
        
        for (int i : lost) {
            if (re.contains(i)) {
                re.remove(Integer.valueOf(i));
                lo.remove(Integer.valueOf(i));
                cnt++;
            }
        }
        
        for (int i : lo) {
            
            if (re.contains(i - 1)) {
                cnt++;
                re.remove(Integer.valueOf(i - 1));
            } else if (re.contains(i + 1)) {
                cnt++;
                re.remove(Integer.valueOf(i + 1));
            } 
        }
        
        return n - (lost.length - cnt);
    }
}