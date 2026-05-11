import java.util.*;
class Solution {
    Set<Integer> numberSet = new HashSet<>();

    public int solution(String numbers) {
        String[] arr = numbers.split("");
        boolean[] visited = new boolean[arr.length];
        StringBuilder sb = new StringBuilder();

        dfs(arr, visited, sb);

        int answer = 0;

        for(int num : numberSet){
            if(isPrime(num)){
                answer++;
            }
        }
        return answer;
    }

    public void dfs (String[] arr, boolean[] visited, StringBuilder sb){
        if(sb.length() > 0){
            numberSet.add(Integer.parseInt(sb.toString()));
        }

        for(int i=0; i<arr.length; i++){
            if(!visited[i]){
                visited[i] = true;
                sb.append(arr[i]);

                dfs(arr, visited, sb);

                sb.deleteCharAt(sb.length()-1);
                visited[i] = false;
            }
        }
    }

    public boolean isPrime(int num){
        if(num < 2) return false;
        for(int i=2; i<=Math.sqrt(num); i++){
            if(num %i == 0) return false;
        }
        return true;
    }
}