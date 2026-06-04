class Solution {
    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i, computers, visited, n);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int current, int[][] computers, boolean[] visited, int n) {
        visited[current] = true;

        for (int next = 0; next < n; next++) {
            if (computers[current][next] == 1 && !visited[next]) {
                dfs(next, computers, visited, n);
            }
        }
    }
}