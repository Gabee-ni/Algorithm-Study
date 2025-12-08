import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static Stack<Integer>[] stacks = new Stack[4];
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(bf.readLine());
		
		for (int i = 1; i <= 3; i++) stacks[i] = new Stack<>(); // 3개의 스택(장대) 초기화
		
		for (int i = n; i >= 1; i--) stacks[1].push(i); // 첫 번째 장대에 원판 삽입
		
		System.out.println(hanoi(n, 1, 2, 3));
		System.out.println(sb.toString());
	}
	
	static int hanoi(int n, int from, int via, int to) {
		int move = 0;
		
        // 원판 한 개 일때는 from -> to로 이동 후 1 반환
		if (n == 1) {
			sb.append(from + " " + to + "\n");
			stacks[to].push(stacks[from].pop());
			return 1;
		}
		
        // 가장 무거운 원판을 제외한 n-1개의 원판들을 중간 장대로 이동
		move += hanoi(n-1, from, to, via);

        // 가장 무거운 원판을 최종 장대로 이동
		sb.append(from + " " + to + "\n");
		stacks[to].push(stacks[from].pop());
		move++;
		
        // 중간 장대에 있던 n-1개의 원판들을 최종 장대로 이동
		move += hanoi(n-1, via, from, to);
		
		return move;
		
	}
}
