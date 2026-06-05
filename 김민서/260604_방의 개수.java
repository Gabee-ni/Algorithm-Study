import java.util.*;

class Solution {
    
    static int[][] ways = {{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
    static Set<String> points = new HashSet<>();
    static Set<String> lines = new HashSet<>();
    
    public int solution(int[] arrows) {
        
        int room = 0;
        
        int[] cur = {0, 0};
        points.add("0,0");
        
        for(int a : arrows) {
            for(int i = 1; i <= 2; i++) {
                int[] next = {cur[0] + ways[a][0], cur[1] + ways[a][1]};
                String nextPoint = makePoint(next);
                String[] nextLines = makeLine(cur, next);
                
                if (points.contains(nextPoint) && !lines.contains(nextLines[0])) {
                    room++;
                }
                
                points.add(nextPoint);
                lines.add(nextLines[0]);
                lines.add(nextLines[1]);
                
                cur = next.clone();
            }
        }
        
        return room;
    }
    
    static String[] makeLine(int[] cur, int[] next) {
        String l1 = cur[0] + "," + cur[1] + "-" + next[0] + "," + next[1];
        String l2 = next[0] + "," + next[1] + "-" + cur[0] + "," + cur[1];
        
        return new String[] {l1, l2};
    }
    
    static String makePoint(int[] next) {
        return next[0] + "," + next[1];
    }
}

/**
2배로 늘려서 하기
좌표 저장, 선 저장 string으로
지난 선이 포함 x, 지난 좌표 o -> 방++
**/