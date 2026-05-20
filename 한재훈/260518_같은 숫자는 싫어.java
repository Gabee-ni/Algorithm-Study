import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[0]);

        for(int i=1; i<arr.length; i++) {
            if(arr[i] != arr[i-1]) {
                list.add(arr[i]);
            }
        }

        return list.stream().mapToInt(i->i).toArray();

    }
}

/** 중복제거 x 연속만아니면 됨
 첫 번째는 넣음
 이후 n-1숫자랑 다른 수면 넣음
 **/