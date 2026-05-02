import java.io.*;
import java.util.StringTokenizer;

public class 에라토스테네스의체{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[N + 1];

        int eraseCnt = counting(visited, N, K);

        System.out.println(eraseCnt);
    }

    static boolean isPrime(int n){
        for(int i = 2; i * i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }

    static int counting(boolean[] visited, int N, int K){
        int cnt = 0;
        for(int i = 2; i <= N; i++){
            if(isPrime(i)){
                for(int j = i; j <= N; j+=i){
                    if(!visited[j]){
                        visited[j] = true;
                        cnt++;
//                        System.out.println("j: " + j + ", cnt: " + cnt);
                        if(cnt == K){
                            return j;
                        }
                    }
                }
            }
        }
        return 0;
    }
}