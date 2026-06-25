import java.util.*;

class Solution {
    public int[] solution(String msg) {
        Map<String, Integer> dict = new HashMap<>();

        for (int i = 0; i < 26; i++) {
            dict.put(String.valueOf((char)('A' + i)), i + 1);
        }

        List<Integer> result = new ArrayList<>();
        int nextIndex = 27;

        int idx = 0;

        while (idx < msg.length()) {
            String w = "";

            int end = idx;

            while (end < msg.length()
                    && dict.containsKey(msg.substring(idx, end + 1))) {
                w = msg.substring(idx, end + 1);
                end++;
            }

            result.add(dict.get(w));

            if (end < msg.length()) {
                dict.put(msg.substring(idx, end + 1), nextIndex++);
            }

            idx += w.length();
        }

        return result.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }
}