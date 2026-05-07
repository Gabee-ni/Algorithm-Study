import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int answer[] = new int [commands.length];

        for(int idx=0; idx < commands.length; idx++) {
            int i = commands[idx][0];
            int j = commands[idx][1];
            int k = commands[idx][2];

            int[] cut = Arrays.copyOfRange(array, i-1, j);
            Arrays.sort(cut);

            answer[idx] = cut[k-1];
        }
        return answer;
    }
}

/** answer 크기 = 명령 수 comands.length
 i j k 꺼내고 copyOfRange 후 sort
 answer[] = k-1번째 수
 **/