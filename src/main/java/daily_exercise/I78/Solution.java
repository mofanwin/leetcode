package daily_exercise.I78;
import java.util.*;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return generate(nums, 0);
    }

    List<List<Integer>> generate(int[] nums, int start) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = start;i <= nums.length;i++) {
            List<Integer> pre = new ArrayList<>();
            for(int j = start;j<i;j++) {
                pre.add(nums[j]);
            }
            List<List<Integer>> suf = generate(nums, i+1);
            if(suf.isEmpty()) result.add(pre);
            else {
                for(List<Integer> next : suf) {
                    List<Integer> tmp = new ArrayList<>(pre);
                    tmp.addAll(next);
                    result.add(tmp);
                }
            }
        }
        return result;
    }
}