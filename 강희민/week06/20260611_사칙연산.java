import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int n = arr.length / 2 + 1;

        int[] nums = new int[n];
        String[] ops = new String[n - 1];

        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                nums[i / 2] = Integer.parseInt(arr[i]);
            } else {
                ops[i / 2] = arr[i];
            }
        }

        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(maxDp[i], Integer.MIN_VALUE);
            Arrays.fill(minDp[i], Integer.MAX_VALUE);
        }

        // 숫자 하나만 있는 구간
        for (int i = 0; i < n; i++) {
            maxDp[i][i] = nums[i];
            minDp[i][i] = nums[i];
        }

        for (int len = 2; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                int end = start + len - 1;

                // mid를 기준으로 왼, 오 나누기
                for (int mid = start; mid < end; mid++) {
                    String op = ops[mid];

                    if (op.equals("+")) {
                        int maxValue = maxDp[start][mid] + maxDp[mid + 1][end];
                        int minValue = minDp[start][mid] + minDp[mid + 1][end];

                        maxDp[start][end] = Math.max(maxDp[start][end], maxValue);
                        minDp[start][end] = Math.min(minDp[start][end], minValue);
                    }
                    else { // "-"
                        int maxValue = maxDp[start][mid] - minDp[mid + 1][end];
                        int minValue = minDp[start][mid] - maxDp[mid + 1][end];

                        maxDp[start][end] = Math.max(maxDp[start][end], maxValue);
                        minDp[start][end] = Math.min(minDp[start][end], minValue);
                    }
                }
            }
        }

        return maxDp[0][n - 1];
    }
}