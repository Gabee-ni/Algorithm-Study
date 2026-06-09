import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>());

        for (int k = 1; k <= 8; k++) {
            Set<Integer> set = new HashSet<>();
            // 이어붙이는 경우
            int repeated = Integer.parseInt(String.valueOf(N).repeat(k));
            set.add(repeated);

            //dp[i], dp[k-i] 
            for (int i = 1; i < k; i++) {
                for (int a : dp.get(i)) {
                    for (int b : dp.get(k - i)) {
                        set.add(a + b);
                        set.add(a - b);
                        set.add(a * b);
                        if (b != 0) set.add(a / b);
                    }
                }
            }

            if (set.contains(number)) {
                return k;
            }
            dp.add(set);
        }

        return -1;
    }
}