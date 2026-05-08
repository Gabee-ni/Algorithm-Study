import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[5];
		
		for (int i=0; i<5; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
        Arrays.sort(arr);
		int num = arr[0];
		int answer = 0;
	
		while (true) {
			int cnt =0;
			for (int i=0; i<5; i++) {
				if(num%arr[i]==0) cnt++;
			}
			if(cnt>=3) {
				answer = num;
				break;
			}
			num++;
		}
		
		System.out.println(answer);
		
	}

}
