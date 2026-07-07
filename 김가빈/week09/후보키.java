import java.util.*;

class Solution {
    static int row, col;
    static List<Set<Integer>> candidateKeys;
    static String[][] relation;

    public int solution(String[][] inputRelation) {
        relation = inputRelation;
        row = inputRelation.length;
        col = inputRelation[0].length;
        candidateKeys = new ArrayList<>();

        for (int size = 1; size <= col; size++) {
            combination(0, size, new HashSet<>());
        }

        return candidateKeys.size();
    }

    private void combination(int start, int size, Set<Integer> currentCombination) {
        if (currentCombination.size() == size) {
            if (isMinimal(currentCombination) && isUnique(currentCombination)) {
                candidateKeys.add(new HashSet<>(currentCombination));
            }
            return;
        }

        for (int i = start; i < col; i++) {
            currentCombination.add(i);
            combination(i + 1, size, currentCombination);
            currentCombination.remove(i);
        }
    }

    private boolean isMinimal(Set<Integer> combination) {
        for (Set<Integer> key : candidateKeys) {
            if (combination.containsAll(key)) {
                return false;
            }
        }
        return true;
    }

    private boolean isUnique(Set<Integer> combination) {
        Set<String> tupleSet = new HashSet<>();

        for (int r = 0; r < row; r++) {
            StringBuilder sb = new StringBuilder();

            for (int c : combination) {
                sb.append(relation[r][c]).append(",");
            }

            if (!tupleSet.add(sb.toString())) {
                return false;
            }
        }

        return true;
    }
}