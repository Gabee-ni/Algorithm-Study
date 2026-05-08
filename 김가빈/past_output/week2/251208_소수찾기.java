import java.util.*;
class Solution {
    
    public boolean isPrime(int num) {
        if(num < 2) return false;
        for(int i=2; i<=(int)Math.sqrt(num); i++) {
            if(num % i == 0) return false;
        }        
        return true;
    }
    
    public void getPrime(int depth, String numbers, StringBuilder num, HashSet<String> set, boolean[] visited) {
        if (depth == numbers.length()) return;
        
        for (int i=0; i< numbers.length(); i++) {
            if(depth == 0 && numbers.charAt(i)=='0') continue;
            if (visited[i]) continue;
            
            visited[i] = true;
            num.append(String.valueOf(numbers.charAt(i)));
            
            if(isPrime(Integer.parseInt(num.toString()))) set.add(num.toString()); 
            getPrime(depth+1, numbers, num, set, visited);
            
            visited[i] = false;
            num.delete(num.length()-1, num.length());
        }
        return;
    }
    
    
    public int solution(String numbers) {
        HashSet<String> set = new HashSet<String>();
        getPrime(0, numbers, new StringBuilder(), set, new boolean[numbers.length()]);  
        return set.size();
    }
}