import java.util.*;

class Solution {
    boolean[] visited;
    
    class Node{
        String word;
        int count;
        
        Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(begin, 0));
        
        visited = new boolean[words.length];
        
        while(!q.isEmpty()) {
            Node now = q.poll();
            
            if (now.word.equals(target)) {
                return now.count;
            }
            
            for (int i = 0; i < words.length; i++) {
                
                if (!visited[i] && canChange(now.word, words[i])) {
                    visited[i] = true;
                    q.offer(new Node(words[i], now.count + 1));
                }
            }
        }
        
        return 0;
    }
    
    
    
    private boolean canChange(String now, String target) {
        if (now.length() != target.length()) {
            return false;
        }
        
        int cnt = 0;
        for (int i = 0; i < now.length(); i++) {
            if (now.charAt(i) != target.charAt(i)) {
                cnt++;
            }
        }
        
        return cnt == 1;
    }
}