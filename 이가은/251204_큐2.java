import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		String[] commands = new String[n];
		ArrayDeque<Integer> queue = new ArrayDeque <>();
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n; i++ ) commands[i] = bf.readLine();
		
		
		for (String command : commands) {
			if (command.startsWith("push")) {
				queue.addLast(Integer.parseInt(command.substring(5)));
				continue;
			}
			
			if (command.equals("size")) {
				sb.append(queue.size() + "\n");
				continue;
			}
			
			if (command.equals("empty")) {
				sb.append((queue.isEmpty() ? 1 : 0) + "\n");
				continue;
			}
			
			if (command.equals("pop")) {
				sb.append((queue.isEmpty() ? -1 : queue.pollFirst()) + "\n");
				continue;
			}
			
			if (command.equals("front")) {
				sb.append((queue.isEmpty() ? -1 : queue.peekFirst()) + "\n");
				continue;
			}

			if (command.equals("back")) {
				sb.append((queue.isEmpty() ? -1 : queue.peekLast()) + "\n");
				continue;
			}
			
		}
		
		System.out.println(sb.toString());
			
	}
}