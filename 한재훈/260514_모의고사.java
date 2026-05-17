import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int[] s1 = {1,2,3,4,5};
        int[] s2 = {2,1,2,3,2,4,2,5};
        int[] s3 = {3,3,1,1,2,2,4,4,5,5};

        int c1 = 0, c2=0, c3=0;

        for(int i=0; i<answers.length; i++) {
            if(answers[i] == s1[i % s1.length]) {
                c1++;
            }
            if(answers[i] == s2[i % s2.length]) {
                c2++;
            }
            if(answers[i] == s3[i % s3.length]) {
                c3++;
            }

        }

        int max = Math.max(c1, Math.max(c2, c3));

        ArrayList<Integer> list = new ArrayList<>();

        if(c1 == max) {
            list.add(1);
        }
        if(c2 == max) {
            list.add(2);
        }
        if(c3 == max) {
            list.add(3);
        }
        return list.stream().mapToInt(i -> i).toArray();

    }
}