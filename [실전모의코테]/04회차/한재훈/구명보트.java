import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        Deque<Integer> dq = new ArrayDeque<>();
        for (int p : people) {
            dq.add(p);
        }
        int answer = 0;

        while (!dq.isEmpty()) {
            int heavy = dq.pollLast();
            if (!dq.isEmpty() && dq.peekFirst() + heavy <= limit) {
                dq.pollFirst();
            }
            answer++;
        }
        return answer;
    }
}

/**
 people 정렬-> 전부 덱에
 덱 뒤에서 제일 무거운 사람 poolLast , answer++
 덱 앞 제일 가벼운 사람 peekFirst와 합 비교
 합 <= limit 가벼운 사람도 빼서 같이 태움 pollFirst
 크면 무거운 사람 혼자 보냄 (앞 사람 안 뺌)
 덱 빌 때까지 반복
 **/