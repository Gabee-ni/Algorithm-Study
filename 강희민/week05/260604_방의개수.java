import java.util.*;

class Solution {
    public int solution(int[] arrows) {
        int answer = 0;

        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

        Set<String> visitedNode = new HashSet<>();
        Set<String> visitedEdge = new HashSet<>();

        int x = 0;
        int y = 0;

        visitedNode.add(x + "," + y);

        for (int arrow : arrows) {

            // 교차 이동 처리하려면 2번씩 이동
            for (int i = 0; i < 2; i++) {
                int nx = x + dx[arrow];
                int ny = y + dy[arrow];

                String currentNode = x + "," + y;
                String nextNode = nx + "," + ny;

                String edge = currentNode + "->" + nextNode;
                String reverseEdge = nextNode + "->" + currentNode;
                if (visitedNode.contains(nextNode) && !visitedEdge.contains(edge)) {
                    answer++;
                }

                visitedNode.add(nextNode);

                visitedEdge.add(edge);
                visitedEdge.add(reverseEdge);

                x = nx;
                y = ny;

            }
        }
        return answer;
    }
}