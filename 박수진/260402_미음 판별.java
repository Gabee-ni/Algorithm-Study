class Solution {
    public boolean[] solution(String[][] grids) {
        boolean[] answer = new boolean[grids.length];
        for (int g = 0; g < grids.length; g++) {
            answer[g] = isMieum(grids[g]);
        }
        return answer;
    }

    private boolean isMieum(String[] grid) {
        int rows = grid.length;
        int cols = grid[0].length();

        // 1. 검은색 바운딩 박스
        int r1 = rows, r2 = -1, c1 = cols, c2 = -1;
        int blackTotal = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i].charAt(j) == 'X') {
                    r1 = Math.min(r1, i);
                    r2 = Math.max(r2, i);
                    c1 = Math.min(c1, j);
                    c2 = Math.max(c2, j);
                    blackTotal++;
                }
            }
        }

        if (r2 == -1) return false;
        if (r2 - r1 < 2 || c2 - c1 < 2) return false;

        // 2. 바운딩 박스 밖에 X가 없는지
        int outerArea = (r2 - r1 + 1) * (c2 - c1 + 1);
        // blackTotal이 박스 밖에도 있으면 안됨 → 아래에서 최종 검증

        // 3. 테두리 4변이 모두 X인지
        for (int j = c1; j <= c2; j++) {
            if (grid[r1].charAt(j) != 'X') return false;
            if (grid[r2].charAt(j) != 'X') return false;
        }
        for (int i = r1; i <= r2; i++) {
            if (grid[i].charAt(c1) != 'X') return false;
            if (grid[i].charAt(c2) != 'X') return false;
        }

        // 4. 내부 흰색 구멍의 바운딩 박스
        int hr1 = r2, hr2 = r1, hc1 = c2, hc2 = c1;
        int dotCount = 0;

        for (int i = r1 + 1; i < r2; i++) {
            for (int j = c1 + 1; j < c2; j++) {
                if (grid[i].charAt(j) == '.') {
                    hr1 = Math.min(hr1, i);
                    hr2 = Math.max(hr2, i);
                    hc1 = Math.min(hc1, j);
                    hc2 = Math.max(hc2, j);
                    dotCount++;
                }
            }
        }

        if (dotCount == 0) return false;

        // 5. 구멍이 정확히 직사각형인지
        if (dotCount != (hr2 - hr1 + 1) * (hc2 - hc1 + 1)) return false;

        // 6. 전체 검정 수 = 외부 직사각형 - 구멍
        return blackTotal == outerArea - dotCount;
    }
}