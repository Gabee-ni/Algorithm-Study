import java.util.*;

class Solution {
    
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    
    static int tableSize;
    
    static boolean[][] visited;
    
    static List<int[][]> tats = new ArrayList<>();
    static List<int[]> tat;
    
    public int solution(int[][] game_board, int[][] table) {
        
        int cnt = 0;
        
        visited = new boolean[table.length][table.length];
        
        // 조각 좌표 기준으로 뽑아서 저장
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if(table[i][j] == 1 && !visited[i][j]) {
                    
                    visited[i][j] = true;
                    
                    tat = new ArrayList<>();
                    tat.add(new int[] {0, 0});
                    
                    findTat(i, j, i, j, table);
                    
                    int[][] oneTat = tat.toArray(new int[tat.size()][]);
                    
                    normalize(oneTat);
                    
                    tats.add(oneTat);
                }
            }
        }
        
        int[][][] tableTat = tats.toArray(new int[tats.size()][][]);
        
        tats = new ArrayList<>();
        visited = new boolean[table.length][table.length];
        
        // 게임보드 좌표 기준으로 뽑아서 저장
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                if(game_board[i][j] == 0 && !visited[i][j]) {
                    
                    visited[i][j] = true;
                    
                    tat = new ArrayList<>();
                    tat.add(new int[] {0, 0});
                    
                    findBoardTat(i, j, i, j, game_board);
                    
                    int[][] oneTat = tat.toArray(new int[tat.size()][]);
                    
                    normalize(oneTat);
                    
                    tats.add(oneTat);
                }
            }
        }
        
        int[][][] boardTat = tats.toArray(new int[tats.size()][][]);
        
        boolean[] visit = new boolean[boardTat.length];
        
        for (int i = 0; i < tableTat.length; i++) {

            boolean matched = false;

            for (int j = 0; j < boardTat.length; j++) {

                if (visit[j]) continue;
                if (tableTat[i].length != boardTat[j].length) continue;

                if (Arrays.deepEquals(tableTat[i], boardTat[j])) {

                    visit[j] = true;
                    cnt += tableTat[i].length;
                    matched = true;
                    break;
                }

                int[][] oneTat = new int[tableTat[i].length][2];

                for (int k = 0; k < tableTat[i].length; k++) {
                    oneTat[k][0] = tableTat[i][k][0];
                    oneTat[k][1] = tableTat[i][k][1];
                }

                for (int a = 0; a < 3; a++) {

                    oneTat = spin(oneTat);

                    if (Arrays.deepEquals(oneTat, boardTat[j])) {

                        visit[j] = true;
                        cnt += tableTat[i].length;
                        matched = true;
                        break;
                    }
                }

                if (matched) break;
            }
        }
        
        return cnt;
    }
    
    static void findTat(int i, int j, int px, int py, int[][] b) {
        
        for(int a = 0; a < 4; a++) {
            
            int nx = i + dx[a];
            int ny = j + dy[a];

            if(nx >= 0 && ny >= 0 && nx < b.length && ny < b.length) {
                if(b[nx][ny] == 1 && !visited[nx][ny]) {
                    tat.add(new int[] {nx - px, ny - py});
                    visited[nx][ny] = true;

                    findTat(nx, ny, px, py, b);
                }
            }
        }
        
        return;
    }
    
    static void findBoardTat(int i, int j, int px, int py, int[][] b) {
        
        for(int a = 0; a < 4; a++) {
            
            int nx = i + dx[a];
            int ny = j + dy[a];

            if(nx >= 0 && ny >= 0 && nx < b.length && ny < b.length) {
                if(b[nx][ny] == 0 && !visited[nx][ny]) {
                    tat.add(new int[] {nx - px, ny - py});
                    visited[nx][ny] = true;

                    findBoardTat(nx, ny, px, py, b);
                }
            }
        }
        
        return;
    }
    
    static int[][] spin(int[][] oneTat) {

        int[][] rotated = new int[oneTat.length][2];

        // 90도 회전
        for (int i = 0; i < oneTat.length; i++) {
            int a = oneTat[i][0];
            int b = oneTat[i][1];

            rotated[i][0] = b;
            rotated[i][1] = -a;
        }

        // 최소값 찾기
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (int[] pin : rotated) {
            minX = Math.min(minX, pin[0]);
            minY = Math.min(minY, pin[1]);
        }

        // 정규화
        for (int[] pin : rotated) {
            pin[0] -= minX;
            pin[1] -= minY;
        }

        // 정렬
        Arrays.sort(rotated, (a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        return rotated;
    }
    
    static void normalize(int[][] arr) {

        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;

        for (int[] p : arr) {
            minX = Math.min(minX, p[0]);
            minY = Math.min(minY, p[1]);
        }

        for (int[] p : arr) {
            p[0] -= minX;
            p[1] -= minY;
        }

        Arrays.sort(arr, (a,b) -> {
            if(a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });
    }
    
}

/**
 table 돌면서 int[][]로 {{0, 0}, {1, -1}} 이런식으로 모형 한 칸 기준 위치 저장
 dfs 돌면서 도형이 들어가는지 체크 도형 크기순으로 해서 점검
**/