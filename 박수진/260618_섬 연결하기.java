import java.util.*;

class Solution {

    int[] parent;

    public int solution(int n, int[][] costs) {

        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        int answer = 0;

        for(int[] edge : costs) {
            if(find(edge[0]) != find(edge[1])) {
                union(edge[0], edge[1]);
                answer += edge[2];
            }
        }

        return answer;
    }

    private int find(int x) {

        if(parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    private void union(int a, int b) {

        int rootA = find(a);
        int rootB = find(b);

        if(rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}