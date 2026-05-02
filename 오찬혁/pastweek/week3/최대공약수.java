import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최대공약수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long iCount = gcd(A, B);

        for(int i = 0; i < iCount; i++){
            sb.append(1);
        }

        System.out.println(sb);
    }

    static long gcd(long a, long b){
        if(b == 0){
            return a;
        }
        return gcd(b, a % b);
    }
}
