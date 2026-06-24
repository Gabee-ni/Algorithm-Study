import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            char ch = (char) ('A' + i);
            dict.put(String.valueOf(ch), i + 1);
        }

        int nextIndex = 27;
        List<Integer> result = new ArrayList<>();

        int i = 0;

        while (i < msg.length()) {
            String w = "";
            int j = i;

            // 사전에 있는 가장 긴 문자열 찾기
            while (j < msg.length()) {
                String temp = msg.substring(i, j + 1);

                if (dict.containsKey(temp)) {
                    w = temp;
                    j++;
                } else {
                    break;
                }
            }

            result.add(dict.get(w));

            // w + 다음 문자가 있으면 사전에 등록
            if (j < msg.length()) {
                String newWord = msg.substring(i, j + 1);
                dict.put(newWord, nextIndex++);
            }

            i += w.length();
        }

        // List<Integer> -> int[] 변환
        int[] answer = new int[result.size()];

        for (int k = 0; k < result.size(); k++) {
            answer[k] = result.get(k);
        }

        return answer;
    }
}