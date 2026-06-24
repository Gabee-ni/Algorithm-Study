import java.util.*;
class Solution {
    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        Deque<Integer> stack = new ArrayDeque<>();

        for(int i=numbers.length-1; i>=0; i--){
            while(!stack.isEmpty() && stack.peek() <= numbers[i]) stack.pop();
            if (stack.isEmpty()) answer[i] = -1;
            else answer[i] = stack.peek();

            stack.push(numbers[i]);
        }
        return answer;
    }
}

/*ㅁ든 원소에 대한 뒷 큰 수들을 차례로 담은 배열 리턴... 존재 안 하면 -1반환
뒷큰수 : 자신보다 뒤에 있는 수 중 본인보다 크면서 가장 가까이(idx차가 가장 작음)*/