import java.util.Stack;

class Solution {
    public int solution(int[] order) {
        Stack < Integer > stack = new Stack < > (); // 메인 컨테이너 벨트
        Stack < Integer > temp = new Stack < > (); // 보조 컨테이너 벨트
        int cnt = 0; // 트럭에 실은 상자 수

        // 메인 컨테이너 벨트에 상자 배치 (1부터 꺼내지도록)
        for (int i = order.length; i > 0; i--) {
            stack.push(i);
        }


        // 트럭에 상자 모두 실으면 종료
        while (cnt < order.length) {
            // 메인 컨테이너 벨트가 비어 있다면
            // 보조 컨테이너 벨트만 확인하면 되므로
            // 루프 종료
            if (stack.isEmpty()) break;
            

            // 메인 컨테이너 벨트 가장 앞에 놓인 상자와 실어야 할 상자인 경우
            if (stack.peek() == order[cnt]) {
                    stack.pop();
                    cnt++;
                    continue;
                } 

            // 보조 컨테이너 벨트 가장 앞에 놓인 상자와 실어야 할 상자인 경우
            if (!temp.isEmpty() && temp.peek() == order[cnt]) {
                temp.pop();
                cnt++;
                continue;
            } 
        
            // 메인, 보조 컨테이너 벨트 가장 앞의 상자가 실어야 할 상자가 아닌 경우
            // 메인 컨테이너 벨트의 가장 앞 상자를 보조 컨테이너 벨트에 놓음
            temp.push(stack.pop());  
        }
        
        //  보조 컨테이너 벨트 가장 앞 상자 비교
        while (!temp.isEmpty()) {
            if (temp.peek() == order[cnt]) {
                temp.pop();
                cnt++;
                continue;
            }
            
            return cnt;
        }
        return cnt;
    }
}