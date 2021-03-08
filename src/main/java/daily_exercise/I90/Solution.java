package daily_exercise.I90;
import java.util.*;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        return generate(nums, 0);
    }

    private List<List<Integer>> generate(int[] nums, int start) {
        List<List<Integer>> result = new ArrayList<>();
        if(start == nums.length) {
            result.add(new ArrayList<>());
            return result;
        }

        int end = start+1;
        while(end < nums.length && nums[end] == nums[start]) end++;
        List<List<Integer>> next = generate(nums, end);
        result.addAll(next);
        List<Integer> cur = new ArrayList<>();
        for(int i = start ; i < end;i++) {
            cur.add(nums[i]);
            for(List<Integer> n : next) {
                List<Integer> pre = new ArrayList<>(cur);
                pre.addAll(n);
                result.add(pre);
            }
        }
        return result;

    }
}