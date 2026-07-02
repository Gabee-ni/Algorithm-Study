import java.util.*;

class Solution {
    int[] di = {-1,1,0,0}, dj = {0,0,-1,1};
    int answer = Integer.MAX_VALUE;
    boolean flag = false;

    public int solution(String[] maps) {

        int ci = 0, cj = 0;
        int li = 0, lj = 0;

        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                if(maps[i].charAt(j) == 'S'){
                    ci = i;
                    cj = j;
                } else if(maps[i].charAt(j) == 'L'){
                    li = i;
                    lj = j;
                }
            }
        }

        int toL = bfs(ci, cj, 'L', maps);
        if (toL == -1) return -1;

        int toE = bfs(li, lj, 'E', maps);
        if (toE == -1) return -1;

        return toL + toE;
    }

    public int bfs(int ci, int cj, char target, String[] maps){
        Deque<int[]> q = new ArrayDeque<>();
        boolean[][] visited = new boolean[maps.length][maps[0].length()];

        q.offer(new int[]{ci, cj, 0});
        visited[ci][cj] = true;

        while(!q.isEmpty()){

            int[] cur = q.poll();

            if(maps[cur[0]].charAt(cur[1]) == target){
                return cur[2];
            }

            for (int d=0; d<4; d++){
                int ni = cur[0] + di[d];
                int nj = cur[1] + dj[d];

                if (ni < 0 || nj < 0 || ni >= maps.length || nj >= maps[0].length()) continue;
                if (maps[ni].charAt(nj) == 'X' || visited[ni][nj]) continue;


                q.offer(new int[]{ni, nj, cur[2]+1});
                visited[ni][nj] = true;
            }
        }
        return -1;

    }
}