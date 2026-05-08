import java.util.*;
class Solution {
    public int solution(int[] citations) {
        int answer = 0;

        Arrays.sort(citations);

        //논문 개수
        int start = 0;
        int end = citations.length;

        while (start <= end) {
            int h = (start+end)/2;
            int uses =0;

            for (int i=0; i<citations.length; i++) {
                if(citations[i] >= h) uses++;
            }

            if(uses >= h && citations.length - uses <= h ) {
                answer = Math.max(answer,h);
                start = h+1;
            } else end = h-1;
        }

        return answer;
    }
}