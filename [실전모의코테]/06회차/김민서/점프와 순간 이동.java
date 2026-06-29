import java.util.*;

public class Solution {
    public int solution(int n) {
        
        int jump = 0;
        
        while (n >= 1) {
            if (n % 2 == 1) {
                jump++;
                n -= 1;
            } else {
                n /= 2;
            }
        }
        
        return jump;
    }
    
}