import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book, (o1,o2)->{
            return o1.compareTo(o2);
        });

        for (int i=1; i<phone_book.length; i++){
            if(phone_book[i].startsWith(phone_book[i-1])){
                answer = false;
                break;
            }
        }

        return answer;
    }
}