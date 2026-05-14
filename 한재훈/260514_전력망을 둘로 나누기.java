import java.util.*;
class Solution {
    public int solution(int n, int[][] wires) {
        int answer = n;

        for(int cut=0; cut<wires.length; cut++) {
            ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
            for(int i=0; i<=n; i++){
                graph.add(new ArrayList<>());
            }
            for(int i=0; i< wires.length; i++) {
                if (i==cut) continue;
                int a = wires[i][0];
                int b = wires[i][1];
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            int groupSize = bfs(1, n, graph);

            int diff = Math.abs(groupSize - (n-groupSize));
            answer = Math.min(answer, diff);
        }
        return answer;

    }
    int bfs(int start, int n, ArrayList<ArrayList<Integer>> graph){
        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(start);
        visited[start] = true;
        int count = 1;

        while(!queue.isEmpty()) {
            int now = queue.poll();
            for (int next:graph.get(now)) {
                if(!visited[next]) {
                    visited[next] = true;
                    queue.add(next);
                    count ++;
                }
            }
        }
        return count;
    }
}