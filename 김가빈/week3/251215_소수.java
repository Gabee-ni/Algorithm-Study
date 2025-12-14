import java.util.*;
import java.io.*;
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<Integer> list = new ArrayList<>();
		
		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		int total = 0;
		
		for(int i=M; i<=N; i++) {
			if(i < 2) continue;
			
			boolean isPrime = true;
			for(int j=2; j<= (int)Math.sqrt(i); j++) {
				if ( i%j == 0) {
					isPrime = false;
					break;
				}
			}
			if (isPrime) list.add(i);
		}
		
		if(list.size()==0) System.out.println(-1);
		else {
			for(int num : list) {
				total += num;
			}
			System.out.println(total);			
			System.out.println(list.get(0));
		}
		
	}

}
