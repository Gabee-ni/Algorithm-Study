class Solution {
	public int solution(String arr[]) {
		int len = (arr.length + 1) / 2;
		int[][] dpMax = new int[len][len];
		int[][] dpMin = new int[len][len];

		int[] nums = new int[len];
		String[] ar = new String[len - 1];
		int idx1 = 0, idx2 = 0;
		for(String s : arr){
			if("+".equals(s) || "-".equals(s)){
				ar[idx2++] = s;
			} else {
				nums[idx1++] = Integer.parseInt(s);
			}
		}

		for(int i = 0; i < len; i++){
			dpMax[i][i] = nums[i];
			dpMin[i][i] = nums[i];
		}

		for(int length = 2; length <= len; length++){
			for(int i = 0; i + length - 1 < len; i++){
				int j = i + length - 1;

				int curMax = Integer.MIN_VALUE;
				int curMin = Integer.MAX_VALUE;
				for(int k = i; k <= j - 1; k++){
					int candMax, candMin;

					if("+".equals(ar[k])){
						candMax = dpMax[i][k] + dpMax[k + 1][j];
						candMin = dpMin[i][k] + dpMin[k + 1][j];
					} else {
						candMax = dpMax[i][k] - dpMin[k + 1][j];
						candMin = dpMin[i][k] - dpMax[k + 1][j];
					}
					curMax = Math.max(curMax, candMax);
					curMin = Math.min(curMin, candMin);
				}

				dpMax[i][j] = curMax;
				dpMin[i][j] = curMin;
			}
		}

		return dpMax[0][len - 1];
	}
}