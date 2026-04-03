import java.util.*;

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
        
        // 1단계: 검은색 바운딩 박스
        int minR = rows, maxR = -1, minC = cols, maxC = -1;
        int blackCount = 0;
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i].charAt(j) == 'X') {
                    minR = Math.min(minR, i);
                    maxR = Math.max(maxR, i);
                    minC = Math.min(minC, j);
                    maxC = Math.max(maxC, j);
                    blackCount++;
                }
            }
        }
        
        // 검은색이 없으면 ㅁ 아님
        if (maxR == -1) return false;
        
        int outerH = maxR - minR + 1;
        int outerW = maxC - minC + 1;
        
        // 바운딩 박스 밖에 X가 없어야 함
        if (blackCount != countBlackInRect(grid, minR, maxR, minC, maxC)) {
            return false;
        }
        
        // 내부가 있으려면 최소 3x3
        if (outerH < 3 || outerW < 3) return false;
        
        // 테두리 4변이 모두 X인지 확인
        for (int j = minC; j <= maxC; j++) {
            if (grid[minR].charAt(j) != 'X' || grid[maxR].charAt(j) != 'X') return false;
        }
        for (int i = minR; i <= maxR; i++) {
            if (grid[i].charAt(minC) != 'X' || grid[i].charAt(maxC) != 'X') return false;
        }
        
        // 내부 흰색 영역의 바운딩 박스
        int hMinR = maxR, hMaxR = minR, hMinC = maxC, hMaxC = minC;
        int dotCount = 0;
        
        for (int i = minR + 1; i < maxR; i++) {
            for (int j = minC + 1; j < maxC; j++) {
                if (grid[i].charAt(j) == '.') {
                    hMinR = Math.min(hMinR, i);
                    hMaxR = Math.max(hMaxR, i);
                    hMinC = Math.min(hMinC, j);
                    hMaxC = Math.max(hMaxC, j);
                    dotCount++;
                }
            }
        }
        
        // 내부에 흰색이 없으면 꽉 찬 직사각형이므로 ㅁ 아님
        if (dotCount == 0) return false;
        
        // 내부 흰색이 정확히 직사각형인지
        int holeH = hMaxR - hMinR + 1;
        int holeW = hMaxC - hMinC + 1;
        if (dotCount != holeH * holeW) return false;
        
        // 전체 검은칸 수 = 외부 직사각형 - 내부 구멍
        int expectedBlack = outerH * outerW - dotCount;
        
        return blackCount == expectedBlack;
    }
    
    private int countBlackInRect(String[] grid, int r1, int r2, int c1, int c2) {
        int count = 0;
        for (int i = r1; i <= r2; i++) {
            for (int j = c1; j <= c2; j++) {
                if (grid[i].charAt(j) == 'X') count++;
            }
        }
        return count;
    }
}