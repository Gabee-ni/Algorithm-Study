class Solution {
	public int solution(int n) {
		int result = 0;
		String temp = "";

		for(int i = n; i > 0; i/=3){
			int j = i % 3;
			temp += String.valueOf(j);
		}

		long num = Long.parseLong(temp);
		int cnt = 0;

		for(long i = num; i > 0; i/=10){
			long j = i % 10;
			for(long k = 0; k < cnt; k++){
				j *= 3;
			}
			cnt++;
			result += j;
		}

		return result;
	}
}