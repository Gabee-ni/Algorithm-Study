import java.util.*;

class Solution {
    public int solution(int[] money) {
        if (money.length==1) return money[0];

        int case1 = rob(money, 0, money.length-2);
        int case2 = rob(money, 1, money.length-1);

        return Math.max(case1, case2);
    }

    public int rob(int[] money, int start, int end){
        int len = end - start + 1;

        int[] dp = new int[len];

        dp[0] = money[start];
        dp[1] = Math.max(money[start], money[start+1]);

        for(int i=2; i<len; i++){
            int curMoney = money[start+i];

            dp[i] = Math.max(dp[i-1], dp[i-2] + curMoney);
        }
        return dp[len-1];
    }
}