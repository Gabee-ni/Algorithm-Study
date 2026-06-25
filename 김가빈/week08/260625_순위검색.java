import java.util.*;

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();

    public int[] solution(String[] info, String[] query){
        for (String inf : info){
            String[] arr= inf.split(" ");
            String[] conditon = {
                    arr[0],
                    arr[1],
                    arr[2],
                    arr[3],
            };
            int score = Integer.parseInt(arr[4]);
            makeKey(conditon,score,0,"");
        }

        for(String key : map.keySet()){
            Collections.sort(map.get(key));
        }

        int[] answer = new int[query.length];

        for(int i=0; i<query.length; i++){
            String q = query[i].replace(" and ", " ");
            String[] arr = q.split(" ");

            String key = arr[0] + arr[1] + arr[2] + arr[3];
            int targetScore = Integer.parseInt(arr[4]);

            if(!map.containsKey(key)){
                answer[i] = 0;
                continue;
            }

            List<Integer> scores = map.get(key);
            int idx = lowerBound(scores, targetScore);
            answer[i] = scores.size() - idx;
        }
        return answer;
    }

    public void makeKey(String[] condition, int score, int depth, String key){
        if(depth == 4){
            map.computeIfAbsent(key, k-> new ArrayList<>()).add(score);
            return;
        }

        makeKey(condition, score, depth+1, key + condition[depth]);
        makeKey(condition, score, depth + 1, key + "-");

    }

    public int lowerBound(List<Integer> score, int target){
        int left = 0;
        int right  = score.size();

        while(left < right){
            int mid = (left + right) /2;

            if(score.get(mid) <target) left = mid +1;
            else right = mid;
        }
        return left;
    }
}