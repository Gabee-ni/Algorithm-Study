class Solution {
    public int solution(String name) {
        int answer = 0;
        int length = name.length();

        int move = length - 1;

        for (int i = 0; i < length; i++) {
            char ch = name.charAt(i);

            int up = ch - 'A';
            int down = 'Z' - ch + 1;

            answer += Math.min(up, down);

            // 옆에 A 몇 개 있는지 확인
            int next = i + 1;

            while (next < length && name.charAt(next) == 'A') {
                next++;
            }

            // 오른쪽으로 갔다가 되돌아가 왼쪽 끝으로 이동
            int rightThenLeft = i * 2 + length - next;

            // 왼쪽으로 먼저 갔다가 되돌아와 오른쪽으로 이동
            int leftThenRight = (length - next) * 2 + i;

            move = Math.min(move, rightThenLeft);
            move = Math.min(move, leftThenRight);
        }

        return answer + move;
    }
}