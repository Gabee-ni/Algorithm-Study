import java.util.*;
import java.io.*;
/*
class Disk {
    int from;  // 어디서 왔는지
    int to;    // 어디로 갔는지

    Disk(int from, int to) {
        this.from = from;
        this.to = to;
    }
}
*/
public class Main {
	
	static int cnt = 0;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		//하노이의 탑 종료 조건 개수 ==1
		//재귀 점화식 n-1, from to 
		
//	    Stack<Disk> from = new Stack<>();
//	    Stack<Disk> to = new Stack<>();
	   
		hanoi(N, 1, 3, 2);
		System.out.println(cnt);
		System.out.println(sb.toString());
	   
	}

	private static void hanoi(int n, int from, int to, int via){
		 if (n == 1) {
	            sb.append(from + " " + to + "\n");
	            cnt++;
	            return;
	        }
		 	cnt++;
	        hanoi(n - 1, from, via, to);
	        sb.append(from + " " + to + "\n");
	        hanoi(n - 1, via, to, from);
	}
}
