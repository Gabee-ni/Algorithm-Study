import java.util.*;
class Solution {
    public int solution(int n) {
        //3진수로 변환
        String num = Integer.toString(n, 3)+"";
        StringBuilder sb = new StringBuilder();
        
        for(int i=num.length()-1; i>=0; i--){
            char s = num.charAt(i);
            sb.append(s);
        }
        //뒤집은 수 3진법을 10진수로 파싱
        int numtoTen = Integer.parseInt(sb.toString(),3);
        return numtoTen;
    }
}