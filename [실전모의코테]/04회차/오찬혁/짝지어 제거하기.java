class Solution{
	public int solution(String s){
		int answer = -1;
		int top = -1;
		char[] stk = new char[s.length()];

		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);

			if(top >= 0 && stk[top] == c){
				top--;
			} else {
				stk[++top] = c;
			}
		}


		return top == -1 ? 1 : 0;
	}
}