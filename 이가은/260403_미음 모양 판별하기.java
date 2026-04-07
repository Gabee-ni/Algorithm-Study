package org.example;

import java.util.Arrays;

class Solution {
    public static void main(String[] args) {
        String[][] grids = {
                {".....", ".XXX.", ".X.X.", ".XXX.", "....."},
                {"XXXXX", "XXXXX", "XXX.X", "XXX.X", "XXXXX"},
                {"XXXXX", "X...X", "X.X.X", "X...X", "XXXXX"},
                {"....X", ".....", "XXX..", "X.X..", "XXX.."},
                {"......", "XXX.XXX", "X.X.X.X", "XXX.XXX", "......"},
                {"XXXXX", "XX.XX", "X...X", "XX.XX", "XXXXX"}
        };

        System.out.println(Arrays.toString(solution(grids)));
    }

    static boolean[] solution(String[][] grids) {
        boolean[] answer = new boolean[grids.length];

        for (int g = 0; g < grids.length; g++) {
            String[] grid = grids[g];

            int Y = grid.length;
            int X = grid[0].length();

            char[][] cGrid = new char[Y][X];
            for (int y = 0; y < Y; y++) {
                cGrid[y] = grid[y].toCharArray();
            }

            // 1. 검은색 시작점 찾기
            int[] blackStart = findStart(true, cGrid, 0, 0, Y, X);
            if (blackStart[0] == -1) {
                continue;
            }

            int blackY = blackStart[0];
            int blackX = blackStart[1];

            // 2. 검은 직사각형 크기 구하기
            int[] blackLength = getLength(true, blackY, blackX, Y, X, cGrid); // [height, width]
            int blackHeight = blackLength[0];
            int blackWidth = blackLength[1];

            if (blackHeight < 3 || blackWidth < 3) {
                continue;
            }

            int blackEndY = blackY + blackHeight;
            int blackEndX = blackX + blackWidth;

            // 3. 검은 직사각형 내부에서 흰색 시작점 찾기
            int[] whiteStart = findStart(false, cGrid, blackY, blackX, blackEndY, blackEndX);
            if (whiteStart[0] == -1) {
                continue;
            }

            int whiteY = whiteStart[0];
            int whiteX = whiteStart[1];

            // 4. 흰 직사각형 크기 구하기
            int[] whiteLength = getLength(false, whiteY, whiteX, blackEndY, blackEndX, cGrid); // [height, width]
            int whiteHeight = whiteLength[0];
            int whiteWidth = whiteLength[1];

            int whiteEndY = whiteY + whiteHeight;
            int whiteEndX = whiteX + whiteWidth;

            // 흰 직사각형은 반드시 검은 직사각형 내부에 완전히 들어가야 함
            if (whiteY <= blackY || whiteX <= blackX || whiteEndY >= blackEndY || whiteEndX >= blackEndX) {
                continue;
            }

            // 5. 검은 직사각형 내부 전체 검증
            boolean valid = true;

            for (int y = blackY; y < blackEndY && valid; y++) {
                for (int x = blackX; x < blackEndX; x++) {
                    boolean inWhite = (whiteY <= y && y < whiteEndY && whiteX <= x && x < whiteEndX);

                    if (inWhite) {
                        if (cGrid[y][x] != '.') {
                            valid = false;
                            break;
                        }
                    } else {
                        if (cGrid[y][x] != 'X') {
                            valid = false;
                            break;
                        }
                    }
                }
            }

            if (!valid) {
                continue;
            }

            // 6. 바깥 직사각형 밖에 다른 X가 있으면 안 됨
            for (int y = 0; y < Y && valid; y++) {
                for (int x = 0; x < X; x++) {
                    boolean inBlack = (blackY <= y && y < blackEndY && blackX <= x && x < blackEndX);

                    if (!inBlack && cGrid[y][x] == 'X') {
                        valid = false;
                        break;
                    }
                }
            }

            answer[g] = valid;
        }

        return answer;
    }

    static int[] findStart(boolean isBlack, char[][] cGrid, int startY, int startX, int endY, int endX) {
        char target = isBlack ? 'X' : '.';

        for (int y = startY; y < endY; y++) {
            for (int x = startX; x < endX; x++) {
                if (cGrid[y][x] == target) {
                    return new int[]{y, x};
                }
            }
        }

        return new int[]{-1, -1};
    }

    static int[] getLength(boolean isBlack, int startY, int startX, int endY, int endX, char[][] cGrid) {
        char target = isBlack ? 'X' : '.';

        int height = 0;
        int width = 0;

        // 가로 길이
        for (int x = startX; x < endX; x++) {
            if (cGrid[startY][x] != target) {
                break;
            }
            width++;
        }

        // 세로 길이
        for (int y = startY; y < endY; y++) {
            if (cGrid[y][startX] != target) {
                break;
            }
            height++;
        }

        return new int[]{height, width};
    }
}