class Solution {
    public String solution(String s) {
        
        StringBuilder sb = new StringBuilder();
        
        s = s.toLowerCase();
        
        char[] c = s.toCharArray();
        boolean change = true;
        
        for (int i = 0; i < c.length; i++) {
            
            if(change) {
                if (c[i] >= 'a' && c[i] <= 'z') {
                    char up = Character.toUpperCase(c[i]);
                    c[i] = up;    
                } 
                
                change = false;
            }
            if (c[i] == ' ') {
                change = true;
            }
        }
        
        return String.valueOf(c);
    }
}