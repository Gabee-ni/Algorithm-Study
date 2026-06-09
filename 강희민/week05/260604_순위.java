import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        boolean[][] graph = new boolean[n + 1][n + 1];

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];

            graph[winner][loser] = true;
        }

        // 간접 승리 계산
        for (int mid = 1; mid <= n; mid++) {
            for (int start = 1; start <= n; start++) {
                for (int end = 1; end <= n; end++) {
                    if (graph[start][mid] && graph[mid][end]) {
                        graph[start][end] = true;
                    }
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            int winCount = 0;
            int loseCount = 0;

            for (int j = 1; j <= n; j++) {
                if (graph[i][j]) {
                    winCount++;
                }

                if (graph[j][i]) {
                    loseCount++;
                }
            }

            if (winCount + loseCount == n - 1) {
                answer++;
            }
        }

        return answer;
    }
}