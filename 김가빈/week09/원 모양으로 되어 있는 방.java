import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int min = Integer.MAX_VALUE;

        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for(int i=0; i<N; i++){
            int sum =0;
            for(int j=0; j<N; j++){
                int gap = ( j - i + N ) % N;
                sum += arr[j] * gap;
            }
            min = Math.min(min, sum);
        }

        System.out.println(min);
    }
    // static int min = Integer.MAX_VALUE;
    // static int N;
    // public static void main(String[] args) throws IOException {
    //     BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    //     N = Integer.parseInt(br.readLine());
    //     int[] arr = new int[N];

    //     for (int i=0; i<N; i++) {
    //         arr[i] = Integer.parseInt(br.readLine());
    //     }

    //     dfs(0,arr);

    //     System.out.println(min);
    // }

    // public static void dfs(int cur, int[] arr){
    //     if(cur == arr.length) {
    //         return;
    //     }

    //     int idx = 0, sum =0;
    //     while(idx < N){
    //         int gap = (idx < cur) ? (idx + N) - cur : idx - cur;
    //         sum += arr[idx % arr.length] * gap;
    //         idx++;
    //     }
    //     min = Math.min(min, sum);

    //     dfs(cur+1,arr);
    // }
}