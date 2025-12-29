import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] t = new int[n+1];
		int[] p = new int[n+1];
		
		for(int i = 1; i <= n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			t[i] = Integer.parseInt(st.nextToken());
			p[i] = Integer.parseInt(st.nextToken());
		}
		
		int[] dp = new int[n+2];
		
		for(int i = n; i > 0; i--) {
			if(i + t[i] > n + 1) {
				dp[i] = dp[i+1];
			} else {
				dp[i] = Math.max(dp[i + 1], dp[i + t[i]] + p[i]); // dp[i+1] 오늘 상담 선택 x, 다음날 상담 선택 | dp[i + t[i]] + p[i] 오늘 상탐 선택 o, 오늘 상담 끝난 후 상담 더함
			}
		}
		
		System.out.println(dp[1]);
	}

}
