import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Guiter {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		int start = 0;
		int end = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			start = arr[i];
			end += arr[i];
		}

		int min = end;

		while (start <= end) {
			int cnt = 1;
			int mid = (start + end) / 2;
			int sum = 0;

			for (int i = 0; i < n; i++) {
				if (sum + arr[i] > mid) {
					cnt++;
					sum = 0;
				}
				sum += arr[i];
			}

			if (cnt <= m) {
				min = mid;
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}

		System.out.println(min);
	}

}
