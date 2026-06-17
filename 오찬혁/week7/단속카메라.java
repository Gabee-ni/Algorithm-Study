import java.util.*;

class Solution {
	public int solution(int[][] routes) {
		int answer = 0;

		Arrays.sort(routes, (a, b) -> a[1] - b[1]);

		// System.out.println(Arrays.deepToString(routes));

		int prevCmr = routes[0][1];
		answer = 1;
		for(int i = 1; i < routes.length; i++){
			if(routes[i][0] > prevCmr){
				answer++;
				prevCmr = routes[i][1];
			}
		}

		return answer;
	}
}