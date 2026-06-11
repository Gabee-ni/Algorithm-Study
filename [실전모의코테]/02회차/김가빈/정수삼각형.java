import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        if(triangle.length == 1) return triangle[0][0];
        else if(triangle.length == 2) return Math.max(triangle[1][0], triangle[1][1]) + triangle[0][0];

        //[-1][-1] or [-1][1]에서 온 값들 중 최댓값을 담는 배열
        List<int[]> dp = new ArrayList<>();
        for(int[] arr : triangle){
            dp.add(new int[arr.length]);
        }
        dp.get(0)[0] = triangle[0][0];
        dp.get(1)[0] = triangle[1][0] + dp.get(0)[0];
        dp.get(1)[1] = triangle[1][1] + dp.get(0)[0];

        for(int i=2; i<triangle.length; i++){
            for(int j=0; j<triangle[i].length; j++){
                if(j==0) dp.get(i)[j] = dp.get(i-1)[j] + triangle[i][j];
                else if(j==triangle[i].length-1) dp.get(i)[j] = dp.get(i-1)[j-1] + triangle[i][j];
                else {
                    dp.get(i)[j] = Math.max(dp.get(i-1)[j-1], dp.get(i-1)[j]) + triangle[i][j];
                }
            }
        }

        int answer = 0;
        for(int num : dp.get(dp.size()-1)){
            answer = Math.max(answer, num);
        }
        return answer;
    }
}