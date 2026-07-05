import java.util.*;

class Solution {
    public int solution(String[] maps) {
        int[] s = {0,0};
        int[] l = {0,0};
        int[] e = {0,0};
        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[0].length(); j++) {
                char c = maps[i].charAt(j);
                if (c == 'S') {
                    s[0]=i; s[1]=j;
                } else if (c == 'L') {
                    l[0]=i; l[1]=j;
                }else if (c == 'E') {
                    e[0]=i; e[1]=j;
                }
            }
        }
        int a = bfs(maps, s, l);
        int b = bfs(maps, l, e);
        return (a == -1 || b == -1) ? -1 : a + b;
    }

    int bfs(String[] maps, int[] from, int[] to) {
        int n = maps.length;
        int m = maps[0].length();

        int[] dr = {-1,1,0,0};
        int[] dc = {0,0,-1,1};

        boolean[][] v = new boolean[n][m];

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{from[0], from[1], 0});
        v[from[0]][from[1]] = true;

        while (!q.isEmpty()) {
            int[] c = q.poll();
            if (c[0]==to[0] && c[1]==to[1]) {
                return c[2];
            }
            for (int d = 0; d < 4; d++) {
                int nr = c[0]+dr[d];
                int nc = c[1]+dc[d];
                if (nr<0||nc<0||nr>=n||nc>=m||v[nr][nc]||maps[nr].charAt(nc)=='X') {
                    continue;
                }
                v[nr][nc] = true;
                q.add(new int[]{nr, nc, c[2]+1});
            }
        }
        return -1;
    }
}

/**
 레버 당긴 후 출구로 -> 경로를 두 구간으로 분리
 출발 s -> 레버 l bfs
 레버l -> 출구 e bfs
 두 구간 합 = 정답, 둘 중 하나라도 도달 불가-> -1
 **/