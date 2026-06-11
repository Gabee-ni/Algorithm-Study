import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int n = arr.length / 2 + 1;
        
        int[][] maxDp = new int[n][n];
        int[][] minDp = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            Arrays.fill(maxDp[i], Integer.MIN_VALUE);
            Arrays.fill(minDp[i], Integer.MAX_VALUE);
        }
        
        // 길이 1 초기화
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(arr[i * 2]);
            maxDp[i][i] = num;
            minDp[i][i] = num;
        }
        
        for (int len = 2; len <= n; len++) {
            for (int start = 0; start <= n - len; start++) {
                int end = start + len - 1;
                
                for (int k = start; k < end; k++) {
                    String op = arr[k * 2 + 1];
                    
                    if (op.equals("+")) {
                        int maxCandidate = maxDp[start][k] + maxDp[k+1][end];
                        int minCandidate = minDp[start][k] + minDp[k+1][end];
                        
                        maxDp[start][end] = Math.max(maxDp[start][end], maxCandidate);
                        minDp[start][end] = Math.min(minDp[start][end], minCandidate);
                    } else {
                        int maxCandidate = maxDp[start][k] - minDp[k+1][end];
                        int minCandidate = minDp[start][k] - maxDp[k+1][end];
                        
                        maxDp[start][end] = Math.max(maxDp[start][end], maxCandidate);
                        minDp[start][end] = Math.min(minDp[start][end], minCandidate);
                    }
                }
            }
        }
        
        return maxDp[0][n-1];
    }
}