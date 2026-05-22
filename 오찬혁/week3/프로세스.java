import java.util.*;

class Solution {
	public int solution(int[] priorities, int location) {
		Queue<int[]> queue = new LinkedList<>();
		int result = 0;

		// 큐에 우선순위아 인덱스 삽입
		for(int i = 0; i < priorities.length; i++){
			queue.offer(new int[]{priorities[i], i});
		}

		while(!queue.isEmpty()){
			int cur[] = queue.poll(); // 현재 우선순위
			boolean hasHighPriority = false;

			for(int[] item : queue){ // 큐 탐색해서 가장 높은 우선순위 찾기
				if(cur[0] < item[0]){
					hasHighPriority = true;
				}
			}

			if(hasHighPriority){ // cur보다 큰 우선순위가 있다면
				queue.offer(cur); // 큐 뒤에 다시 추가
			}
			else{ // cur의 우선순위가 가장 크다면
				result++;
				if(location == cur[1]){ // 찾고자하는 loc이랑 인덱스가 같으면
					return result;
				}
			}
		}

		return result;
	}
}