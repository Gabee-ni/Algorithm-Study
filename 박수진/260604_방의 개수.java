import java.util.*;

class Solution {

    public int solution(int[] arrows) {

        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

        Set<String> visitedNode = new HashSet<>();
        Set<String> visitedEdge = new HashSet<>();

        int x = 0, y = 0;
        visitedNode.add("0,0");

        int answer = 0;

        for (int dir : arrows) {

            for (int i = 0; i < 2; i++) { // 핵심: 2배 이동

                int nx = x + dx[dir];
                int ny = y + dy[dir];

                String cur = x + "," + y;
                String next = nx + "," + ny;

                // 이미 방문한 "간선"인데 처음 지나가는 경우 → 방 생성
                if (visitedNode.contains(next) &&
                    !visitedEdge.contains(cur + "-" + next)) {
                    answer++;
                }

                visitedEdge.add(cur + "-" + next);
                visitedEdge.add(next + "-" + cur);

                visitedNode.add(next);

                x = nx;
                y = ny;
            }
        }

        return answer;
    }
}