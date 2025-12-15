import java.util.*;
import java.io.*;

public class Main {
	
	public static boolean isPrime(int num) {
		for(int i=2; i<=(int)Math.sqrt(num);i++) { 
			if(num%i==0) return false;
		}
		return true;
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		LinkedList<Integer> list = new LinkedList<Integer>();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int cnt = 0; 
		int answer =0;
		int primeNum = 0;
		
		for(int i=2; i<=N; i++) {
			list.add(i);
		}
		Collections.sort(list);
		
		while(list.size()>0) {
			boolean flag = false; 
			for(int i=0; i<list.size();i++) {
				if(isPrime(list.get(i))) {
					primeNum = list.get(i);
					break;
				}
			} 
			
			for(int j=0; j<list.size();j++) {
				if(cnt==K) {
					flag = true; 
					break;
				}
				if(list.get(j)%primeNum==0) {
					answer = list.get(j);
					list.remove(list.get(j));
					cnt++;
				}
			} 
			if(flag) break;
		}
		System.out.println(answer);
	}
}

