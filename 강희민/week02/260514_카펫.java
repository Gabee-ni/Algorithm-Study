class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        for (int yellowH = 1; yellowH <= yellow; yellowH++) {
            if (yellow % yellowH == 0) {
                int yellowW = yellow / yellowH;

                int width = yellowW + 2;
                int height = yellowH + 2;

                if (width * height == total) {
                    return new int[]{width, height};
                }
            }
        }

        return new int[]{};
    }
}