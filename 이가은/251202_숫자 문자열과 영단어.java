import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String s) {
        int answer = 0;
        StringBuilder sb = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        Map<String, Integer> map = new HashMap<>();
        
        String[] dict = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        
        for (int i = 0; i < dict.length; i++) map.put(dict[i], i);

        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char c = arr[i];
            
            if ( c >= 47 && c <= 57) {
                sb.append(c);
                continue;
            } 
            
            temp.append(c);
            String word = temp.toString();
            
            if (map.keySet().contains(word)) {
                sb.append(map.get(word));
                temp.setLength(0);
            }
        }
        
        return Integer.parseInt(sb.toString());
    }
}