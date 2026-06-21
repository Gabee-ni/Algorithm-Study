class Solution {
    public int solution(int num) {
        long n = num;

        for (int answer = 0; answer < 500; answer++) {
            if (n == 1) {
                return answer;
            }

            if (n % 2 == 0) {
                n /= 2;
            } else {
                n = n * 3 + 1;
            }
        }

        return -1;
    }
}