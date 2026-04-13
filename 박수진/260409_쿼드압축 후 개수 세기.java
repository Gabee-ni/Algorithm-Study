class Solution {
    int[] count = new int[2]; // count[0] = 0의 개수, count[1] = 1의 개수

    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return count;
    }

    private void compress(int[][] arr, int row, int col, int size) {
        // 현재 영역이 모두 같은 값인지 확인
        if (isUniform(arr, row, col, size)) {
            count[arr[row][col]]++;
            return;
        }

        // 4등분해서 재귀 호출
        int half = size / 2;
        compress(arr, row,        col,        half); // 좌상
        compress(arr, row,        col + half, half); // 우상
        compress(arr, row + half, col,        half); // 좌하
        compress(arr, row + half, col + half, half); // 우하
    }

    private boolean isUniform(int[][] arr, int row, int col, int size) {
        int val = arr[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (arr[i][j] != val) return false;
            }
        }
        return true;
    }
}