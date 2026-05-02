import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 좋다 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cnt = 0;

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(arr);

		for (int i = 0; i < N; i++) {
			int left = 0;
			int right = N - 1;


			while (left < right) {
				if(left == i){
					left++;
					continue;
				}
				if (right == i) {
					right--;
					continue;
				}

				int good = arr[left] + arr[right];
				if(good == arr[i]){
					cnt++;
					break;
				}

				if (good < arr[i]) {
					left++;
				} else {
					right--;
				}
			}

		}

		System.out.println(cnt);
	}
}
