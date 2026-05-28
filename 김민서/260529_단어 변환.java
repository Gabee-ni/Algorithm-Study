import java.util.*;

class Solution {
    
    static int cnt = Integer.MAX_VALUE;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        
        visited = new boolean[words.length];
        
        dfs(begin, target, words, 0);
        
        if(cnt == Integer.MAX_VALUE) return 0;
        
        return cnt;
    }
    
    static void dfs(String begin, String target, String[] words, int dept) {
        
        if (begin.equals(target)) {
            cnt = Math.min(cnt, dept);
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            
            if(oneGap(words[i], begin) && !visited[i]) {
                
                visited[i] = true;
                dfs(words[i], target, words, dept + 1);
                visited[i] = false;
            }
        }
        
        return;
    }
    
    static boolean oneGap(String w, String begin) {
        
        int num = 0;
        
        for(int i = 0; i < w.length(); i++) {
            
            if (w.charAt(i) != begin.charAt(i)) {
                num++;
            }
            
            if (num > 1) {
                return false;
            }
        }
        
        if (num == 1) {
            return true;
        }
        
        return false;
    }
}