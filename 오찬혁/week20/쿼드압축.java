class Solution {

	int cnt0 = 0, cnt1 = 0;

	public int[] solution(int[][] arr) {
		solve(arr, 0, 0, arr.length);
		return new int[]{cnt0, cnt1};
	}

	void solve(int[][] arr, int r, int c, int size){
		if(allSame(arr, r, c, size)){
			if(arr[r][c] == 0) cnt0++;
			else cnt1++;
			return;
		}

		int half = size / 2;
		solve(arr, r, c, half);
		solve(arr, r, c + half, half);
		solve(arr, r + half, c, half);
		solve(arr, r + half, c + half, half);
	}

	boolean allSame(int[][] arr, int r, int c, int size){
		int v = arr[r][c];
		for(int i = r; i < r + size; i++){
			for(int j = c; j < c + size; j++){
				if(arr[i][j] != v) return false;
			}
		}
		return true;
	}
}