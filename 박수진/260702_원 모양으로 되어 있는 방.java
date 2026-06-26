import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] room = new int[n];

        for(int i = 0; i < n; i++) {
            room[i] = Integer.parseInt(br.readLine());
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int moves = 0;

            for (int j = i+1; j < i+n; j++) {
                moves += (j-i) * room[j%n];
            }

            answer = Math.min(answer, moves);
        }

        System.out.println(answer);
    }
}