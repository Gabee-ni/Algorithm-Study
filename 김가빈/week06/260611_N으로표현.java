import java.util.*;
class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> dp = new ArrayList<>();
        dp.add(new HashSet<>());

        int idx = 1;
        while (idx <= 8){
            Set<Integer> num = new HashSet<>();

            String strN = N+"";
            for(int i=0; i<idx-1; i++) strN += N;
            num.add(Integer.parseInt(strN));

            for(int i=1; i<idx; i++){
                Set<Integer> leftSet = dp.get(i);
                Set<Integer> rightSet = dp.get(idx - i);

                for(int left : leftSet){
                    for(int right : rightSet){
                        num.add(left + right);
                        num.add(left - right);
                        num.add(left * right);
                        if (right!=0) num.add(left / right);
                    }
                }
            }

            if(num.contains(number)) return idx;

            dp.add(num);
            idx++;
        }
        return -1;
    }
}