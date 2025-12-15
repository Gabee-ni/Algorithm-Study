import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> primeList = new ArrayList<>();
		StringBuilder answer = new StringBuilder(); // 합과 최솟값
		int sum = 0;

		// M 이상 N 이하
		int M = Integer.parseInt(bf.readLine());
		int N = Integer.parseInt(bf.readLine());

		for (int i = M; i <= N; i++) {
			if (isPrime(i)) {
				primeList.add(i);
				sum += i;
			}
		}

		if (primeList.size() == 0) {
			System.out.println(-1);
			return;
		}

		answer.append(sum + " ");
		answer.append(primeList.get(0));

		System.out.println(answer.toString());
	}

	static boolean isPrime(int n) {
		if (n == 1)
			return false;

		for (int k = 2; k <= Math.sqrt(n); k++) {
			if (n % k == 0)
				return false;
		}
		return true;
	}

}