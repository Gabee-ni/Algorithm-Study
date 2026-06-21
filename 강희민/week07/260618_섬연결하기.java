import java.util.*;

class Solution {
    private int[] parent;

    public int solution(int n, int[][] costs) {
        int answer = 0;

        Arrays.sort(costs, (a, b) ->
                Integer.compare(a[2], b[2])
        );

        // 처음에는 각 섬이 자기 자신만의 그룹에 속함
        parent = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int bridgeCount = 0;

        for (int[] cost : costs) {
            int islandA = cost[0];
            int islandB = cost[1];
            int bridgeCost = cost[2];

            // 다른 그룹이면 다리 설치
            if (union(islandA, islandB)) {
                answer += bridgeCost;
                bridgeCount++;

                if (bridgeCount == n - 1) {
                    break;
                }
            }
        }

        return answer;
    }

    // 그룹의 대표 번호 찾기
    private int find(int island) {
        if (parent[island] == island) {
            return island;
        }

        // 대표 번호 바로 저장
        return parent[island] = find(parent[island]);
    }

    // 두 섬의 그룹을 합침
    private boolean union(int islandA, int islandB) {
        int rootA = find(islandA);
        int rootB = find(islandB);

        // 사이클 방지
        if (rootA == rootB) {
            return false;
        }

        parent[rootB] = rootA;

        return true;
    }
}