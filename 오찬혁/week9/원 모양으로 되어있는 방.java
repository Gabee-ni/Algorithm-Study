import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];

		for(int i = 0; i < N; i++){
			arr[i] = Integer.parseInt(br.readLine());
		}

		int min = Integer.MAX_VALUE;
		for(int i = 0; i < arr.length; i++){
			int sum = 0;
			for(int j = i; j < i + arr.length; j++){
				// System.out.print((j) % arr.length + ", ");
				sum += arr[j % arr.length] * (j - i);
			}
			// System.out.println("sum: " + sum);
			min = Math.min(min, sum);
		}

		System.out.println(min);
	}
}