import java.util.*;
class Solution {
    Set<Integer> set = new HashSet<>();

    public int[] solution(int[] numbers) {
        combination(0,numbers,new ArrayList<>());
        List<Integer> answer = new ArrayList<>(set);
        Collections.sort(answer);
        return answer.stream().mapToInt(i->i).toArray();
    }

    private void combination(int idx, int[] numbers, List<Integer> list){
        if (list.size() == 2){
            int sum = 0;
            for (int num : list){
                sum += num;
            }
            set.add(sum);
            return;
        }

        for(int i=idx; i<numbers.length; i++){
            list.add(numbers[i]);
            combination(i+1, numbers, list);
            list.remove(list.size()-1);
        }
    }
}