class Solution {

    int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {

        boolean[] visited = new boolean[words.length];

        dfs(begin, target, words, visited, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private void dfs(String current,
                     String target,
                     String[] words,
                     boolean[] visited,
                     int count) {

        if (current.equals(target)) {
            answer = Math.min(answer, count);
            return;
        }

        for (int i = 0; i < words.length; i++) {

            if (visited[i]) continue;

            if (canChange(current, words[i])) {

                visited[i] = true;

                dfs(words[i],
                        target,
                        words,
                        visited,
                        count + 1);

                visited[i] = false;
            }
        }
    }

    private boolean canChange(String a, String b) {

        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }
}