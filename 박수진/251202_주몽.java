import java.util.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        String[] uniqueNum = (br.readLine()).split(" ");
        
        int[] uqn = Arrays.stream(uniqueNum).mapToInt(Integer::parseInt).toArray();
        
        Arrays.sort(uqn);
        
        int start = 0;
        int end = uqn.length-1;
        int answer = 0;
        while (start < end) {
            if (uqn[start]+uqn[end] < m) {
                start++;
            }
            else if (uqn[start]+uqn[end] > m) {
                end--;
            }
            else {
                answer++;
                start++;
                end--;
            }
        }
        
        System.out.println(answer);
    }
}