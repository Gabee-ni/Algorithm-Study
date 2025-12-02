import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i : tangerine){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<Integer> values = new ArrayList<Integer>(map.values());
        values.sort(Collections.reverseOrder());
        int cnt = 0;
        for(int i=0; i<values.size(); i++){
            cnt += values.get(i);
            answer++;
            if(cnt>=k){
                break;
            }
        }
        return answer;
    }
}