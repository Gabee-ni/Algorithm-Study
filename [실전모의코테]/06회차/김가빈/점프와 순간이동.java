import java.util.*;

public class Solution {
    int ans = Integer.MAX_VALUE;

    public int solution(int n) {
        dfs(n, 0);
        return ans;
    }

    public void dfs (int n, int percent){
        if(n == 0){
            ans = Math.min(ans, percent);
            return;
        }

        //순간이동 한 경우
        if(n%2==0) dfs(n/2, percent);
        else dfs(n-1, percent+1);

    }
}