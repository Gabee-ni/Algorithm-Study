import java.io.*;
import java.util.*;

public class Main {

	public static int cnt=0;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for(int t=0; t<T; t++) {
			cnt=0;
			String str = br.readLine();
			System.out.println(isPalindrome(str,0)+" "+cnt);
		}
	}
	
	public static int isPalindrome(String s, int idx){
		cnt++;
		if(idx >= s.length()-1-idx) return 1;
		else if(s.charAt(idx)==s.charAt(s.length()-(idx+1))) {
			return isPalindrome(s, idx+1);
		}
		else return 0;
	}
}
