import java.util.*;
class Solution {
    static boolean[] visited;
    static int[] output;
    static int[] arr;
    static List<Integer> result;
    
    public int solution(String numbers) {
        int answer = 0;
        result = new ArrayList<Integer>();
        String[] st = numbers.split("");
        arr = new int[st.length];
        for(int j=0; j<arr.length; j++){  
            arr[j] = Integer.valueOf(st[j]);
        }
        int n = arr.length;
        for(int i=1; i<=numbers.length(); i++){
            output = new int[i];
            visited = new boolean[n];
            p(0, n, i);
        }
        for(int a : result){
            if(find(a)) answer++;
        }
        return answer;
    }
    
    public void p(int dept, int n, int r){
        if(dept == r){
            StringBuilder sb = new StringBuilder();
            for(int x : output){
                sb.append(x);
            }
            int a = Integer.parseInt(sb.toString());

            if(!result.contains(a)){
                result.add(a);
            }
            return;
        }
        for(int j=0; j<n; j++){
            if(!visited[j]){
                visited[j] = true;
                output[dept] = arr[j];
                p(dept+1, n, r);
                visited[j] = false;
            }
        }
    }
    
    public boolean find(int n){
        if(n<2) return false;
        for(int i = 2; i<=n/2; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}