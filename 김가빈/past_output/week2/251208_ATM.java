import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		int[] line = new int[N];
		int sum = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		for(int i=0; i<N; i++) {
			sum+= arr[i];
			line[i] = sum;
		}
		System.out.println(Arrays.stream(line).sum());
	}

}
