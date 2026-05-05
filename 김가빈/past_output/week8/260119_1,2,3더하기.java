package task;

import java.util.*;
import java.io.*;

public class Main {
	static int[] dp;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			dp = new int[N+1];
			System.out.println(dp(N));
		}
		
	}
	
	public static int dp(int N) {
		if(N<3) return N;
		if(N==3) return 4;
		
		dp[1]=1; dp[2]=2; dp[3]=4;
		for(int i=4; i<=N;i++) {
			dp[i]= dp[i-1] + dp[i-2] + dp[i-3];
		}
		return dp[N];
	}
	
}

