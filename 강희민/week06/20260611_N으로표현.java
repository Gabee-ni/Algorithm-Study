import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();

        for (int i = 0; i <= 8; i++) {
            dp.add(new HashSet<>());
        }

        for (int i = 1; i <= 8; i++) {
            // N, NN, NNN 만들기
            int repeated = 0;
            for (int j = 0; j < i; j++) {
                repeated = repeated * 10 + N;
            }
            dp.get(i).add(repeated);

            // dp[j] 와 dp[i-j] 조합
            for (int j = 1; j < i; j++) {
                Set<Integer> leftSet = dp.get(j);
                Set<Integer> rightSet = dp.get(i - j);

                for (int left : leftSet) {
                    for (int right : rightSet) {
                        dp.get(i).add(left + right);
                        dp.get(i).add(left - right);
                        dp.get(i).add(left * right);

                        if (right != 0) {
                            dp.get(i).add(left / right);
                        }
                    }
                }
            }

            // i개를 써서 number를 만들 수 있으면 바로 return
            if (dp.get(i).contains(number)) {
                return i;
            }
        }

        return -1;
    }
}