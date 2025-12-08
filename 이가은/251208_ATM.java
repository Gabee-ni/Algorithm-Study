import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;


public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));	
		int n = Integer.parseInt(bf.readLine());
		int[] arr = new int[n];
		int answer = 0;
		int temp = 0;
		
		StringTokenizer st = new StringTokenizer(bf.readLine());
		for (int i = 0; i < n; i++) arr[i]= Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		for (int i = 0; i < n; i++) {
			answer += temp +  arr[i]; // 대기 시간 + 본인 시간
			temp += arr[i]; // 대기 시간 증가
		}
		
		System.out.println(answer);
	}
}