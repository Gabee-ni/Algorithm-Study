import java.util.*;
class Solution {
    static List<List<Integer>> answer;
    public List<List<Integer>> permute(int[] nums) {
        answer = new ArrayList<>();
        permutations(0, nums, new ArrayList<>());
        return answer;
    }

    static private void permutations(int idx, int[] nums, List<Integer> arr){
        if(idx == nums.length){
            answer.add(new ArrayList<>(arr));
            return;
        }

        for(int i=0; i<nums.length; i++){
            if(arr.contains(nums[i])) continue;
            arr.add(nums[i]);
            permutations(idx+1, nums, arr);
            arr.remove(arr.size()-1);
        }
    }
}