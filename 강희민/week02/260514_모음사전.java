class Solution {
    public int solution(String word) {
        int answer = 0;

        String vowels = "AEIOU";
        int[] weight = {781, 156, 31, 6, 1};

        for (int i = 0; i < word.length(); i++) {

            // 현재 알파벳이 AEIOU 중 몇 번째인지 찾기
            int index = vowels.indexOf(word.charAt(i));

            answer += index * weight[i] + 1;
        }

        return answer;
    }
}