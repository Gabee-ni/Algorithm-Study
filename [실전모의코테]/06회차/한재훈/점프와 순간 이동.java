class Solution {
    public int solution(int n) {
        int answer = 0;
        while (n > 0) {
            if (n % 2 == 0) {
                n /= 2;
            } else {
                n -= 1;
                answer++;
            }
        }
        return answer;
    }
}

/**
 뒤에서부터 거꾸로 /2
 홀수 -1,count
 짝수 -> /2
 홀수 -> -1, answer++
 **/