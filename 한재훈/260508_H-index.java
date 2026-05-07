import java.util.*;
class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);

        int n = citations.length;

        for(int i=0; i < n; i++) {
            int hIndex = n-i;
            if(n - i <= citations[i]) {
                return hIndex;
            }
        }
        return 0;
    }
}

/** 논문 오름차순 정렬
 h번 이상 인용된 논문 수 = citation.length보다 높을 수 없음
 citation.length - i =< citation[i] 인 순간
 **/