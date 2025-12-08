import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] strArr = new String[n];
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++) strArr[i] = bf.readLine();
		
        // 각 문자열마다 팰린드롬 확인
		for (String str : strArr) sb.append(isPalindrome(str.toCharArray(), 1) + "\n");
		
		System.out.println(sb.toString());
	}
	
	static String isPalindrome(char[] s, int cnt) {
		return recursion(s, 0, s.length -1, 1);
	}

	static String recursion(char[] s, int l, int r, int cnt) {
        // 왼쪽 포인터가 오른쪽 포인터 넘어설 경우
        // 양쪽 문자들을 모두 비교했고 모두 동일했다는 것이므로
        // 1 반환
		if (l >= r) return 1 + " " + cnt;

        // 왼쪽 문자와 오른쪽 문자 같지 않을 경우 0 반환
		else if (s[l] != s[r]) return 0 + " " + cnt;

        // 왼쪽 문자와 오른쪽 문자 같으면 왼쪽 포인터 1 증가, 오른쪽 포인터 1 감소시켜 다음 양쪽 문자 비교
        // 재귀 카운트 증가
		else return recursion(s,  l + 1, r - 1, cnt + 1);
	}
	
}