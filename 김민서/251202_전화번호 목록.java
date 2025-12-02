class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        for(String i : phone_book){
            for(String j : phone_book){
                if(i.equals(j)) continue;
                String str = "";
                if(i.length() > j.length())
                    str = i.substring(0, j.length());
                else str = i;
                if(j.startsWith(str)){
                    answer = false;
                    break;
                }
            }
        }
        return answer;
    }
}
//해쉬
import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        Map<Integer, String> map = new HashMap<>();
        for(int i=0; i<phone_book.length; i++){
            map.put(i, phone_book[i]);
        }
        for(int a=0; a<map.size(); a++){
            for(int b=1; b<phone_book[a].length(); b++){
                if(map.containsValue(phone_book[a].substring(0,b))){
                    return false;
                }
            }
        }
        return true;
    }
}