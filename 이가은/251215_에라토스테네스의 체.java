import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(bf.readLine());
		int N = Integer.parseInt(st.nextToken()); // 2 ~ N까지의 수
		int K = Integer.parseInt(st.nextToken()); // K번째 지워지는 수
		boolean[] arr = new boolean[N + 1]; // 제거한 숫자 처리

		int remove = 0; // 현재 제거한 수
		int cnt = 0; // 현재 제거한 개수

		int primeNum = 2; // 소수
		int i = 1; // 소수에 곱해지는 수

		while (cnt < K) {
			int nextNum = primeNum * i;

            // 다음 수가 범위를 넘으면
			if (nextNum > N) {
                // 다음 소수를 구함
				for (int j = primeNum + 1; j <= N; j++) {
					if (!arr[j]) {
						primeNum = j; // 다음 소수 업데이트
						i = 1; // 소수에 곱해지는 수 초기화
						break;
					}
				}
				continue;
			}

            // 제거하지 않은 수라면
			if (!arr[nextNum]) {
				remove = nextNum;
				arr[nextNum] = true;
				cnt++;
			}

			i++;
		}

		System.out.println(remove);
	}

}