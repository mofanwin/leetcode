package daily_exercise.I1755;
import java.util.*;
//[5,-7,3,5]
//6
class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int r = solution.minAbsDifference(new int[]{5,-7,3,5}, 6);
        System.out.println(r);
    }

    public int minAbsDifference(int[] nums, int goal) {
        if(nums.length == 0) return Math.abs(goal);
        Arrays.sort(nums);
        long[] upper = new long[nums.length];
        long[] lower = new long[nums.length];
        upper[upper.length-1] = Math.max(0, nums[nums.length-1]);
        lower[lower.length-1] = Math.min(0, nums[nums.length-1]);
        for(int i = nums.length-2;i>=0;i--) {
            upper[i] = upper[i+1] + Math.max(nums[i], 0);
            lower[i] = lower[i+1] + Math.min(nums[i], 0);
        }
        Long result = null;
        Set<Long> set = new HashSet<>();
        set.add(0L);
        for(int i = 0 ; i < nums.length;i++) {
            Set<Long> next = new HashSet<>();
            for(Long s : set) {
                if(result == null || ((s + lower[i] - goal) <= result  && goal - (s + upper[i]) <= result)) {
                    result = result == null ? Math.abs(s  - goal) : Math.min(result, Math.abs(s - goal));
                    next.add(s);
                    next.add(s+nums[i]);
                }
            }
            set = next;
        }
        for(long s : set) {
            result = Math.min(result,Math.abs(s-goal));
        }
        return (int)(long)result;
    }
}