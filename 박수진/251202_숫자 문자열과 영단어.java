import java.util.Map;

class Solution {
    public int solution(String s) {
        Map<Integer, String> alphabet = Map.of(
            0, "zero",
            1, "one",
            2, "two",
            3, "three",
            4, "four",
            5, "five",
            6, "six",
            7, "seven",
            8, "eight",
            9, "nine"
        );

        for (int i=0; i<=9; i++) {
            if (s.contains(alphabet.get(i))) {
                s = s.replace(alphabet.get(i), Integer.toString(i));
            }
        }

        int answer = Integer.parseInt(s);
        return answer;
    }
}