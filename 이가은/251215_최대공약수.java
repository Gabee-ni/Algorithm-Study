import java.io.*;
import java.util.*;

public class Main {
    // 유클리드 호제법
    // 두 수의 최대공약수는 큰 수를 작은 수로 나눈 나머지와 작은 수의 최대공약수와 같다
    static long gcd(long a, long b) {
        while (b != 0) {
            long r = a % b;
            a = b;
            b = r;
        }
        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        long g = gcd(a, b);

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        final int CHUNK = 1 << 16; // 2^16 (한 번에 출력할 최대 문자 수)
        char[] ones = new char[CHUNK]; // 2^16 크기의 문자 배열 정의
        Arrays.fill(ones, '1'); // 모든 원소에 1 저장

        while (g >= CHUNK) { // 출력해야 할 1이 2^16개 이상 남아 있다면
            bw.write(ones); // 2^16개의 1을 출력
            g -= CHUNK; // 남은 개수에서 2^16을 뺀다
        }
        if (g > 0) { // CHUNK로 나누어떨어지지 않는 경우 나머지 출력
            bw.write(ones, 0, (int) g);
        }

        // write()로 버퍼에 쌓아둔 데이터를 실제 출력 스트림으로 전송
        bw.flush();
    }
}