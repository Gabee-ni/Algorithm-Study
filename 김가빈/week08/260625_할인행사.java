import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> map = new HashMap<>();

        int num  = 0;
        for(int i=0; i<want.length; i++){
            map.put(want[i], number[i]);
            num += number[i];
        }

        int days = 0;
        for(int i=0; i<=discount.length-num; i++){

            Map<String, Integer> candidateMap = new HashMap<>();

            for (int j=i; j<i+num; j++){
                candidateMap.put(discount[j], candidateMap.getOrDefault(discount[j], 0)+1);
            }

            boolean flag = true;

            for(String key : candidateMap.keySet()){
                if(candidateMap.get(key) != map.get(key)) {
                    flag = false;
                    break;
                }
            }

            if(flag) days++;
        }
        return days;
    }
}