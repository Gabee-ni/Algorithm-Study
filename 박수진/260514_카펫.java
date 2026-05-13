class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow; // = width * height

        for (int height = 1; height <= total; height++) {
            if (total % height != 0) continue;

            int width = total / height; // weight >= height

            // 내부가 yellow 확인
            if ((width - 2) * (height - 2) == yellow) {
                return new int[]{width, height};
            }
        }

        return new int[]{0, 0};
    }
}
