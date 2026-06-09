import java.util.*;

class Solution {
    public int solution(String[] arr) {

        List<Integer> nums = new ArrayList<>();
        List<Character> ops = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                nums.add(Integer.parseInt(arr[i]));
            } else {
                ops.add(arr[i].charAt(0));
            }
        }

        int n = nums.size();

        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(maxDp[i], Integer.MIN_VALUE);
            Arrays.fill(minDp[i], Integer.MAX_VALUE);

            maxDp[i][i] = nums.get(i);
            minDp[i][i] = nums.get(i);
        }

        // len = 구간 길이
        for (int len = 2; len <= n; len++) {

            for (int i = 0; i <= n - len; i++) {

                int j = i + len - 1;

                for (int k = i; k < j; k++) {

                    char op = ops.get(k);

                    if (op == '+') {

                        maxDp[i][j] = Math.max(
                            maxDp[i][j],
                            maxDp[i][k] + maxDp[k + 1][j]
                        );

                        minDp[i][j] = Math.min(
                            minDp[i][j],
                            minDp[i][k] + minDp[k + 1][j]
                        );

                    } else { // '-'

                        maxDp[i][j] = Math.max(
                            maxDp[i][j],
                            maxDp[i][k] - minDp[k + 1][j]
                        );

                        minDp[i][j] = Math.min(
                            minDp[i][j],
                            minDp[i][k] - maxDp[k + 1][j]
                        );
                    }
                }
            }
        }

        return maxDp[0][n - 1];
    }
}