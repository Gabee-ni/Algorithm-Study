import java.util.*;

class Solution {
    public int solution(int[] arrows) {
        int answer = 0;

        // 0,1,2,3,4,5,6,7 방향
        int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
        int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};

        Set<String> visitedNode = new HashSet<>();
        Set<String> visitedEdge = new HashSet<>();

        int x = 0;
        int y = 0;

        visitedNode.add(getNodeKey(x, y));

        for (int dir : arrows) {
            // 대각선 교차를 잡기 위해 한 방향을 2번 이동
            for (int step = 0; step < 2; step++) {
                int nx = x + dx[dir];
                int ny = y + dy[dir];

                String curNode = getNodeKey(x, y);
                String nextNode = getNodeKey(nx, ny);

                String edge = getEdgeKey(x, y, nx, ny);
                String reverseEdge = getEdgeKey(nx, ny, x, y);

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

    private String getNodeKey(int x, int y) {
        return x + "," + y;
    }

    private String getEdgeKey(int x1, int y1, int x2, int y2) {
        return x1 + "," + y1 + "->" + x2 + "," + y2;
    }
}