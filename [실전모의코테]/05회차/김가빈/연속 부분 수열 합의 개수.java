import java.util.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> set = new HashSet<>();
        int answer = 0;

        int[] arr = new int[elements.length*2];
        for(int i=0; i<elements.length *2 ;i++){
            arr[i]=elements[i%elements.length];
        }

        int len = elements.length;

        while(len > 0){
            for(int i=0; i<elements.length; i++){
                int sum = 0;
                for(int j=i; j<i+len; j++){
                    sum += arr[j];
                }
                set.add(sum);
            }
            len--;
        }

        return set.size();
    }
}