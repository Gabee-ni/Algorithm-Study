class Solution {
    public int solution(String name) {

        int answer = 0;
        int n = name.length();

        // 좌우 이동 기본값: 끝까지 오른쪽으로만 가는 경우
        int move = n - 1;

        for (int i = 0; i < n; i++) {

            char c = name.charAt(i);

            // 위/아래 조작 횟수
            answer += Math.min(c - 'A', 'Z' - c + 1);

            // 연속된 A 구간 찾기
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            // 오른쪽 갔다가 돌아오기
            move = Math.min(move, i * 2 + n - next);

            // 왼쪽 먼저 갔다가 돌아오기
            move = Math.min(move, (n - next) * 2 + i);
        }

        return answer + move;
    }
}
