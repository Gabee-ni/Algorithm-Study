import java.util.Arrays;
import java.util.Map;
import java.util.HashMap;

class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        Map<String, String>[] processedFiles = new HashMap[files.length];
        
        for (int fileIndex = 0; fileIndex < files.length; fileIndex++) {
            char[] cArr = files[fileIndex].toCharArray();
            StringBuilder head = new StringBuilder();
            StringBuilder num = new StringBuilder();
            String tail = "";
            
            for (int i = 0; i < cArr.length; i++) {       
                if (cArr[i] >= '0' && cArr[i] <= '9') {
                    num.append(cArr[i]);
                } else if (head.length() > 0 && num.length() > 0) {
                    tail = files[fileIndex].substring(i);
                    break;
                } else {
                    head.append(cArr[i]);
                }
            }
            
            Map<String,String> map = new HashMap<>();
            map.put("head", head.toString());
            map.put("num", num.toString());
            map.put("tail", tail);
            
            processedFiles[fileIndex] = map;
        }
        
        Arrays.sort(processedFiles, (a, b) -> {
                String aHead = a.get("head").toLowerCase();
                String bHead = b.get("head").toLowerCase();
            
                if (aHead.equals(bHead)) {
                    return Integer.parseInt(a.get("num")) - Integer.parseInt(b.get("num"));
                } else {
                    return aHead.compareTo(bHead);
                }
            }
        );
        
        for (int i = 0; i < files.length; i++) {
            answer[i] = processedFiles[i].get("head") + processedFiles[i].get("num") + processedFiles[i].get("tail");
        }
      
        return answer;
    }
}