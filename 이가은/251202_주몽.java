import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		int m = Integer.parseInt(bf.readLine());
		List<Integer> list = new ArrayList<>();
		int answer = 0;
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		
		for (int i = 0; i < n; i++) {
			int k = Integer.parseInt(st.nextToken());
			if (k < m) list.add(k);
		}
		
		int[] arr = list.stream().mapToInt(i->i).toArray();
		int size = arr.length;
		
		for (int i = 0; i < size; i++) {
			
			for (int j = i + 1; j < size; j++) {
				if (p + arr[j] == m) answer++;
			}
		}
		
		System.out.println(answer);
	}

}
