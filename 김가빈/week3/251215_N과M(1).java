import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		List<List<Integer>> result = new ArrayList<>();
		int[] arr = new int[N];
		
		for (int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		perm(result, new ArrayList<>(),arr,M);
		
		for (List<Integer> list : result) {
			for(Integer num : list ) {
				System.out.print(num+" ");
			}
			System.out.println();
		}
			
	}
	
	static void perm(List<List<Integer>> result, List<Integer> cur, int[] arr, int M) {
		if (M==0) {
			//결과 리스트에 현재 수열 삽입
			result.add(new ArrayList<>(cur));
			return;
		}
		for (int i=0; i<arr.length; i++) {
			//중복체크
			if (cur.contains(arr[i])) continue;
			cur.add(arr[i]);
			perm(result, cur, arr, M-1);
			//리턴 후 방금 더한 원소를 뺴줘야 다음에도 사용 가능.
			cur.remove(cur.size()-1);
		}
	}
	
	

}
