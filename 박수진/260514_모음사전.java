class Solution {
    int answer = 0;
    int count = 0;
    String target;
    char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    
    public int solution(String word) {
        target = word;
        dfs("");
        return answer;
    }
    
    private void dfs(String current) {
        if (current.equals(target)) {
            answer = count;
            return;
        }

        if (current.length() == 5) {
            return;
        }

        for (char vowel : vowels) {
            count++;
            dfs(current + vowel);

            if (answer != 0) return;
        }
    }
}