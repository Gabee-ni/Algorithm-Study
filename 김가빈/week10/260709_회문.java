import java.io.*;

class Solution {
    public static void main(String args[]) throws Exception {
        int T = 10;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine().trim());

            char[][] arr = new char[8][8];

            for (int i = 0; i < 8; i++) {
                arr[i] = br.readLine().toCharArray();
            }

            int answer = 0;

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {

                    // 가로 검사
                    if (j + N <= 8) {
                        boolean isPalindrome = true;

                        for (int k = 0; k < N / 2; k++) {
                            if (arr[i][j + k] != arr[i][j + N - 1 - k]) {
                                isPalindrome = false;
                                break;
                            }
                        }

                        if (isPalindrome) answer++;
                    }

                    // 세로 검사
                    if (i + N <= 8) {
                        boolean isPalindrome = true;

                        for (int k = 0; k < N / 2; k++) {
                            if (arr[i + k][j] != arr[i + N - 1 - k][j]) {
                                isPalindrome = false;
                                break;
                            }
                        }

                        if (isPalindrome) answer++;
                    }
                }
            }

            sb.append("#").append(test_case).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }
}