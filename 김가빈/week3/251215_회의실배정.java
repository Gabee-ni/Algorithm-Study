package week1.array;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int start = 0;
		int end = 0;
		List<int[]> list = new ArrayList<>();
		
		for(int i = 0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			start = Integer.parseInt(st.nextToken());
			end = Integer.parseInt(st.nextToken());
			
			list.add(new int[] {start, end});
		}
		
		//종료시간이 빠른 순으로 정렬, 이전 종료 시간 <= 현재 시작시간 cnt++
		//종료시간 빠른 것만 정렬하면 틀림
		//=> 종료시간이 같은 경우 시작시간이 빠른 순으로 정렬해야지 같은 개수라도 더 긴 회의가 가능 => 개수는 같을지라도 선택에 있어서 안정성 상승
		Collections.sort(list, (o1,o2)->{
			if(o1[1]==o2[1]) return o1[0] - o2[0];
			return o1[1]-o2[1];
		});
		
		int lastEnd = 0;
		int cnt=0;
		
		for(int i=0; i<list.size();i++) {
			if (list.get(i)[0]>= lastEnd) {
				cnt++;
				lastEnd = list.get(i)[1];
			} 
		}
		
		System.out.println(cnt);
		
		
	    
	}

}
