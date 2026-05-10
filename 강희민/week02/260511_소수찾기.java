import java.util.*;

class Solution {
    Set<Integer> numberSet = new HashSet<>();
    boolean[] visited;

    public int solution(String numbers) {
        visited = new boolean[numbers.length()];

        makeNumber("", numbers);

        int answer = 0;

        for (int num : numberSet) {
            if (isPrime(num)) {
                answer++;
            }
        }

        return answer;
    }

    // 가능한 숫자 조합 만들기
    private void makeNumber(String current, String numbers) {
        if (!current.equals("")) {
            numberSet.add(Integer.parseInt(current));
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                makeNumber(current + numbers.charAt(i), numbers);
                visited[i] = false;
            }
        }
    }

    // 소수 판별
    private boolean isPrime(int num) {
        if (num < 2) {
            return false;
        }

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }
}