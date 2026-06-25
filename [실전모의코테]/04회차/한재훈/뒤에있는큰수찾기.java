import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int n = numbers.length;
        int[] answer = new int[n];
        Arrays.fill(answer, -1);
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                answer[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }
        return answer;
    }
}
/**
 answer[] -1로 다 채움 numbers를 데크에 집어넣음 처음 빼서 max에 넣음 이후 빼고-> 직전 수 비교, 직전수 보다 크면 1. answer[i] = 직전수
 max와 비교 , 크면 교체 작으면 유지
 직전수 보다 작으면 -1 반복하고 answer 배열에 넣음 마지막에 answer 반전시킴
 **/

/**
 answer[] -1로 다 채움 못 찾으면 -1
 스택
 numbers 왼쪽부터 순회 i=0 끝
 스택 안 비었고 스택 top이 가리키는 값 < numbers[i] -> top 빼서 pop, answer[] = numbers[i]
 더 작은 거 없을 때까지 반복
 현재 i를 스택에 넣음
 끝나고 스택에 남은 인덱스들은 뒷큰수 없으면 -1 유지
 **/