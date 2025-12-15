import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Main {
    static int N, M;
    static int[] arr;    // 수열을 담을 배열
    static boolean[] check;
    static StringBuilder answer = new StringBuilder();
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        check = new boolean[N+1];
        arr = new int[M];
        
        perm(0);
        
        System.out.println(answer);
    }
    
    // depth : 현재까지 고른 숫자의 개수
    public static void perm(int depth) {
        if (depth == M) {
            for (int val : arr) {
                answer.append(val).append(' ');
            }
            answer.append('\n');
            return;
        }
        
        for (int i=1; i<=N; i++) {
            if (!check[i]) {
                check[i] = true;
                arr[depth] = i;
                perm(depth + 1);
                check[i] = false; // 백트래킹 (재귀가 끝나면 방문 해제)
            }
        }
    }
}