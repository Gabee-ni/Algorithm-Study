class Solution {
    
    static int[][] array;
    static int zeroCnt = 0;
    static int oneCnt = 0;
    
    public int[] solution(int[][] arr) {
        
        int size = arr.length;
        array = new int[size][size];
        
        for (int i = 0; i < size; i++) {
            array[i] = arr[i].clone();    
        }
        
        dfs(size, 0, 0, size - 1, size - 1);
        
        return new int[] {zeroCnt, oneCnt};
    }
    
    boolean isBlock(int sx, int sy, int ex, int ey, int f) {
        
        for (int i = sx; i <= ex; i++) {
            for (int j = sy; j <= ey; j++) {
                if (array[i][j] != f) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    void dfs(int size, int sx, int sy, int ex, int ey) {
        if (size == 1) {
            if (array[sx][sy] == 0) {
                zeroCnt++;
            } else {
                oneCnt++;
            }
            return;
        }
        
        if (isBlock(sx, sy, ex, ey, array[sx][sy])) {
            if (array[sx][sy] == 0) {
                zeroCnt++;
            } else {
                oneCnt++;
            }
            return;
        }
        
        dfs(size / 2, sx, sy, sx + size / 2 - 1, sy + size / 2 - 1);
        dfs(size / 2, sx + size / 2, sy, ex, sy + size / 2 - 1);
        dfs(size / 2, sx, sy + size / 2, sx + size / 2 - 1, ey);
        dfs(size / 2, sx + size / 2, sy + size / 2, ex, ey);
        
        return;
    }
}