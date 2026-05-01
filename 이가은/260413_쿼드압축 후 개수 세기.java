class Solution {
    private int[] cnt = new int[2];

    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return cnt;
    }

    private void compress(int[][] arr, int row, int col, int size) {
        int value = arr[row][col];

        // 현재 영역이 모두 같은 값인지 확인
        boolean same = true;
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != value) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        // 모두 같으면 카운트
        if (same) {
            cnt[value]++;
            return;
        }

        // 다르면 4등분
        int half = size / 2;
        compress(arr, row, col, half);
        compress(arr, row, col + half, half);
        compress(arr, row + half, col, half);
        compress(arr, row + half, col + half, half);
    }
}