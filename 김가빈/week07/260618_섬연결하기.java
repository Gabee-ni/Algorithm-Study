import java.util.*;

class Solution {
    static class Edge{
        int start;
        int end;
        int cost;

        Edge(int start, int end, int cost){
            this.start = start;
            this.end = end;
            this.cost = cost;
        }
    }
    int[] parent;

    public int find (int n){
        if(parent[n]==n) return n;
        return parent[n] = find(parent[n]);
    }

    public boolean union (int start, int end){
        int ps = find(start);
        int pe = find(end);

        if(ps == pe) return false;
        parent[ps] = pe;
        return true;
    }


    public int solution(int n, int[][] costs) {
        int answer = 0;

        List<Edge> graph = new ArrayList<>();
        for(int[] c : costs){
            graph.add(new Edge(c[0],c[1],c[2]));
        }

        Collections.sort(graph, (a,b)-> {
            return a.cost - b.cost;
        });

        parent = new int[n];

        for(int i =0; i<n ;i++){
            parent[i] =i;
        }

        int totalCost = 0;
        int used = 0;

        for (Edge e : graph ){
            if(union(e.start, e.end)){
                totalCost += e.cost;
                used++;

                if(used == n-1) break;
            }
        }


        return totalCost;
    }
}