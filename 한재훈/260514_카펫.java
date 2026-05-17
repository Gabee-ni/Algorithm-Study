import java.util.*;
class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;

        for(int h=3; h<=sum; h++) {
            int w = sum / h;
            if (w<h){
                break;
            }

               if(total % h =!0) {
                continue;
            }

            if((w-2) * (h-2) == yellow ) {
                return new int[]{w,h};
            }


        }
        return new int[]{}

    }
}

/**
yellow = (w-2) * (h-2)
total / h == 0
w >= h
**/