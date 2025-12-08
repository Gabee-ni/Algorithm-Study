import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
	static char[] nArr;
	static Set<Integer> primeSet;

	public static int solution(String numbers) {
		nArr = numbers.toCharArray();

		List<Character> nList = new ArrayList<>();
		for (char c : nArr) nList.add(c);

		primeSet = new HashSet<>();

		for (int i = 0; i < numbers.length(); i++) {
			perm(i, 1, new StringBuilder(), nList);
		}
		
		return primeSet.size();
	}

	static void perm(int index, int size, StringBuilder sb, List<Character> nList) {
		if (size > nArr.length) return;

		StringBuilder newSb = new StringBuilder(sb);
		newSb.append(nList.get(index));
		int num = Integer.parseInt(newSb.toString());
		if (isPrime(num))
			primeSet.add(num);

		List<Character> newNlist = new ArrayList<>(nList);
		newNlist.remove(index);

		for (int i = 0; i < newNlist.size(); i++) {
			perm(i, size + 1, newSb, newNlist);
		}

	}

	static boolean isPrime(int n) {
		if (n <= 1) return false;

		for (int i = 2; i < n; i++) if (n % i == 0) return false;

		return true;
	}

}