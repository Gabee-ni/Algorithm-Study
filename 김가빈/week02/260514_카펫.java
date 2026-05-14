class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for (int height = 3; height <= total; height++) {
            if (total % height != 0) continue;

            int width = total / height;

            if (width < height) continue;

            int innerWidth = width - 2;
            int innerHeight = height - 2;

            if (innerWidth * innerHeight == yellow) {
                return new int[]{width, height};
            }
        }

        return new int[]{};
    }
}