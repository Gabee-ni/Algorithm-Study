import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> sums = new HashSet<>();
        
        for (int i = 1; i < elements.length + 1; i++) {
            
            for (int j = 0; j < elements.length; j++) {
                
                int sum = 0;
                
                for (int a = j; a < j + i; a++) {
                    sum += elements[a % elements.length];
                }
                
                sums.add(sum);
            }
        }
        
        return sums.size();
        
//         Queue<Integer> que = new LinkedList<>();
        
//         for (int i : elements) {
//             que.offer(i);
//         }
        
//         HashSet<Integer> sums = new HashSet<>();
        
//         for (int i = 1; i <= elements.length; i++) {
            
//             int sum = 0;
//             for (int j = 0; j < i; j++) {
//                 int out = que.poll();
//                 sum += out;
                
//                 que.offer(out);
                
//                 if (j == i - 1) {
//                     sums.add(sum);
//                     sum = 0;
//                 }
//             }
//         }
        
//         return sums.size();
    }
}


/**
첫번째 for문 -> 더할 개수 설정
두번째 for문 ->
**/