class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int[] clothes = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            clothes[i] = 1;
        }

        for (int student : lost) {
            clothes[student]--;
        }

        for (int student : reserve) {
            clothes[student]++;
        }

        for (int i = 1; i <= n; i++) {
            if (clothes[i] == 0) {

                // 바로 앞 학생에게 여벌이 있으면 빌림
                if (i > 1 && clothes[i - 1] == 2) {
                    clothes[i - 1]--;
                    clothes[i]++;
                }

                // 앞 학생에게 빌리지 못했다면 뒤 학생 확인
                else if (i < n && clothes[i + 1] == 2) {
                    clothes[i + 1]--;
                    clothes[i]++;
                }
            }
        }

        int answer = 0;

        for (int i = 1; i <= n; i++) {
            if (clothes[i] >= 1) {
                answer++;
            }
        }

        return answer;
    }
}