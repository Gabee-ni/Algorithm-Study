import java.util.*;

class Solution {

    public int solution(String[][] relation) {
        int row = relation.length;
        int col = relation[0].length;

        List<Integer> candidateKeys = new ArrayList<>();

        // 모든 컬럼 조합
        for (int bit = 1; bit < (1 << col); bit++) {
            // 최소성 검사
            boolean minimal = true;

            for (int key : candidateKeys) {
                if ((key & bit) == key) {
                    minimal = false;
                    break;
                }
            }

            if (!minimal) continue;

            // 유일성 검사
            Set<String> set = new HashSet<>();

            for (int i = 0; i < row; i++) {
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j < col; j++) {
                    if ((bit & (1 << j)) != 0) {
                        sb.append(relation[i][j]).append(",");
                    }
                }

                set.add(sb.toString());
            }

            if (set.size() == row) {
                candidateKeys.add(bit);
            }
        }

        return candidateKeys.size();
    }
}