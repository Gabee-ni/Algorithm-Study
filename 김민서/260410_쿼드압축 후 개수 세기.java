class Solution {
    static int[] answer = new int[2];

    public int[] solution(int[][] arr) {
        compress(arr, 0, 0, arr.length);
        return answer;
    }

    private void compress(int[][] arr, int x, int y, int size) {
        int first = arr[x][y];
        boolean same = true;

        // 현재 영역이 모두 같은 값인지 확인
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (arr[i][j] != first) {
                    same = false;
                    break;
                }
            }
            if (!same) break;
        }

        // 모두 같으면 개수 증가
        if (same) {
            answer[first]++;
            return;
        }

        // 다르면 4등분
        int half = size / 2;
        compress(arr, x, y, half); // 왼쪽 위
        compress(arr, x, y + half, half); // 오른쪽 위
        compress(arr, x + half, y, half); // 왼쪽 아래
        compress(arr, x + half, y + half, half); // 오른쪽 아래
    }
}